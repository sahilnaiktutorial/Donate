package com.example.donate.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.donate.Model.Donors;
import com.example.donate.R;
import com.example.donate.Model.User;

import java.util.ArrayList;

public class Adminadapter extends RecyclerView.Adapter<Adminadapter.MyViewHolder> {
    Context context;
    ArrayList<Donors> list;

    public Adminadapter(Context context, ArrayList<Donors> list) {
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
        Donors duser=list.get(position);
        holder.Eventname.setText(duser.getEevent());
        holder.Additional.setText(duser.getAaditional());
        holder.Mail.setText(duser.getEemail());
        holder.Addresses.setText(duser.getAddresses());

    }


    @Override
    public int getItemCount() {
//        return list.size();
        return list != null ? list.size() : 0;
    }

//        return 0;



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Eventname,Additional,Mail,Addresses;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Eventname=itemView.findViewById(R.id.event);
            Additional=itemView.findViewById(R.id.add);
            Mail=itemView.findViewById(R.id.usermail);
            Addresses=itemView.findViewById(R.id.address);
        }
    }
}
