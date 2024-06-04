package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
    private Button Donatee;
    private Button Ccelebration;
    private Button Contact;
    private Button Feedback;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Welcome," +
                       "Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
                Donatee = findViewById(R.id.donatee);
                Donatee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create an intent to navigate to the OtherActivity
                        Intent intent = new Intent(dashboard.this, donor.class);
                        startActivity(intent);
                    }
                });
        Ccelebration = findViewById(R.id.loveandlaughter);
        Ccelebration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(dashboard.this, celebration.class);
                startActivity(intent);
            }
        });
        Contact = findViewById(R.id.ccontact);
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(dashboard.this, contact.class);
                startActivity(intent);
            }
        });
        Feedback = findViewById(R.id.feedback);
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the OtherActivity
                Intent intent = new Intent(dashboard.this, Feedbackform.class);
                startActivity(intent);
            }
        });








            }
        }





