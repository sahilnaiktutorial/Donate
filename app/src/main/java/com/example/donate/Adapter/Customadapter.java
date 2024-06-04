package com.example.donate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donate.Model.DDonorfeedback;
import com.example.donate.R;

import java.util.ArrayList;

public class Customadapter extends RecyclerView.Adapter<Customadapter.MyViewHolder>{
    Context context;
    ArrayList<DDonorfeedback> list;

    public Customadapter(Context context, ArrayList<DDonorfeedback> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Customadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.iitems,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DDonorfeedback ddonorfeedback=list.get(position);
        holder.FFirstname.setText(ddonorfeedback.getDDName());
        holder.DDFeedback.setText(ddonorfeedback.getFeedbackmail());


    }


    @Override
    public int getItemCount() {
//       return list.size();
        return list != null ?
                list.size() : 0;
    }

//        return 0;



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView FFirstname,DDFeedback;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            FFirstname=itemView.findViewById(R.id.nname);
            DDFeedback=itemView.findViewById(R.id.response);

        }
    }

}
