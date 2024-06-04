package com.example.donate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contact extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 1;
    private String adminEmail = "nehav2066@gmail.com";
    private String adminPhoneNumber = "9535701921";
    private Button Phone,Mail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Welcome," +
                "Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        Phone=findViewById(R.id.phone);
        Mail=findViewById(R.id.mail);
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(contact.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(contact.this,
                                new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                    } else {
                        startPhoneCall();
                    }
                }
               


        });
        Mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String userEmail = "user@example.com"; // Replace with the user's email address

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:" + adminEmail));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Donation Inquiry");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "User Email: " + userEmail);

                    try {
                        startActivity(Intent.createChooser(emailIntent, "Send Email"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(contact.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }

    private void startPhoneCall() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + adminPhoneNumber));
        startActivity(callIntent);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PHONE_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startPhoneCall();
            } else {
                Toast.makeText(contact.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
