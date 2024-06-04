package com.example.donate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donate.Adapter.Myadapter;
import com.example.donate.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//public class donorlist extends AppCompatActivity {
//    private DatabaseReference database;
//    private RecyclerView recyclerView;
//    Myadapter myadapter;
//    ArrayList<User> list;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_donorlist);
//
//        recyclerView = findViewById(R.id.donorlist);
//        database = FirebaseDatabase.getInstance().getReference("users");
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        myadapter=new Myadapter(this,list);
//        recyclerView.setAdapter(myadapter);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    list.clear();
//                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
//                    User user=dataSnapshot.getValue(User.class);
//                    list.add(user);
//                }
//                myadapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(donorlist.this, "Not Populating", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//    @Override
//    public void onBackPressed() {
//        finish();
//        super.onBackPressed();
//    }
//}




//updated code from chatgpt

public class donorlist extends AppCompatActivity {
    private DatabaseReference database;
    private RecyclerView recyclerView;
    Myadapter myadapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorlist);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);

        recyclerView = findViewById(R.id.donorlist);
        database = FirebaseDatabase.getInstance().getReference("users");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>(); // Initialize the list

        myadapter = new Myadapter(this, list);
        recyclerView.setAdapter(myadapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(donorlist.this, "Not Populating", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
