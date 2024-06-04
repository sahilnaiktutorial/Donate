package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Admindashboard extends AppCompatActivity {
    private Button options;
    private Button llist;
    private  Button eventlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });
        options = findViewById(R.id.rv);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(Admindashboard.this, opinions.class);
                startActivity(intent);
            }
        });

        llist = findViewById(R.id.button);
        llist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(Admindashboard.this, donorlist.class);
                startActivity(intent);
            }
        });
         eventlist= findViewById(R.id.eventlist);
        eventlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(Admindashboard.this, opinions.class);
                startActivity(intent);
            }
        });


    }
}