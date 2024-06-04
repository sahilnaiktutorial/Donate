package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donate.Model.Donors;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class celebration extends AppCompatActivity {
    EditText Event, AdditionalInformation, Email, Address;
    Button btnn;
    private DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebration);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Event = findViewById(R.id.eventtype);
        AdditionalInformation = findViewById(R.id.addition);
        Email = findViewById(R.id.eemail);
        Address = findViewById(R.id.address);
        btnn = findViewById(R.id.submitt);
        databaseReference = FirebaseDatabase.getInstance().getReference("duser");
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eevent = Event.getText().toString();
                String additional = AdditionalInformation.getText().toString();
                String Eemail = Email.getText().toString();
                String Addresses = Address.getText().toString();
                Donors duser = new Donors(eevent, additional, Eemail, Addresses);

                // Store the user object in Firebase
                String userId = databaseReference.push().getKey();
                databaseReference.child(userId).setValue(duser);
                if (eevent.length() == 0 || additional.length() == 0 || Eemail.length() == 0 || Addresses.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Your event has been registered successfully", Toast.LENGTH_SHORT).show();
                // Clear the form fields
                Event.setText("");
                AdditionalInformation.setText("");
                Email.setText("");
                Address.setText("");
            }
        });
    }
}