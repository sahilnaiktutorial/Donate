package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donate.Model.DDonorfeedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedbackform extends AppCompatActivity {


    EditText username,userinformation;
    Button Fill;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackform);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        username = findViewById(R.id.donorname);
        userinformation = findViewById(R.id.information);

        Fill = findViewById(R.id.fill);

        databaseReference = FirebaseDatabase.getInstance().getReference("donorFeedback");
        Fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ddname = username.getText().toString();
                String ddfeedback = userinformation.getText().toString();
                DDonorfeedback donorFeedback = new DDonorfeedback(ddname,ddfeedback);

                // Store the user object in Firebase
                String donorId = databaseReference.push().getKey();
                databaseReference.child(donorId).setValue(donorFeedback);
                if (ddname.length() == 0 || ddfeedback.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Form submitted successfully", Toast.LENGTH_SHORT).show();
                // Clear the form fields
                username.setText("");
                userinformation.setText("");
            }
        });

    }}









