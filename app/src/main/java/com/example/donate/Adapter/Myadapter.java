package com.example.donate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donate.R;
import com.example.donate.Model.User;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public Myadapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new  MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user=list.get(position);
        holder.Firstname.setText(user.getName());
        holder.DonatingItems.setText(user.getItems());
        holder.EEmail.setText(user.getEmail());

    }


    @Override
    public int getItemCount() {
//        return list.size();
        return list != null ? list.size() : 0;
    }

//        return 0;



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Firstname,DonatingItems,EEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Firstname=itemView.findViewById(R.id.event);
            DonatingItems=itemView.findViewById(R.id.add);
            EEmail=itemView.findViewById(R.id.usermail);
        }
    }
}
