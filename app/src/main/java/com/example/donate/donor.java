package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donate.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donor extends AppCompatActivity {


    EditText donorname,donoritems,donoremail,date;
    Button btns;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        donorname = findViewById(R.id.dname);
        donoritems = findViewById(R.id.d_items);
        donoremail = findViewById(R.id.dmail);
        date = findViewById(R.id.ddate);
        btns = findViewById(R.id.submit);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = donorname.getText().toString();
                String email = donoremail.getText().toString();
                String items = donoritems.getText().toString();
                String Date = date.getText().toString();
                User user = new User(name, email,items,Date);

                // Store the user object in Firebase
                String userId = databaseReference.push().getKey();
                databaseReference.child(userId).setValue(user);
                if (name.length() == 0 || email.length() == 0 || items.length() == 0 || Date.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();
                // Clear the form fields
                donorname.setText("");
                donoremail.setText("");
                donoritems.setText("");
                date.setText("");
            }
        });

    }}




