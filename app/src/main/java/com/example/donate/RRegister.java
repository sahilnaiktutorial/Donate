package com.example.donate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RRegister extends AppCompatActivity {
    private EditText Rname, Remail, Rpass;
    private Button Rregister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rregister);

        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        Rname = findViewById(R.id.rname);
        Remail = findViewById(R.id.remail);
        Rpass = findViewById(R.id.rpass);
        Rregister = findViewById(R.id.rregister);

        // Handle register button click
        Rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Rname.getText().toString();
                String email = Remail.getText().toString();
                String password = Rpass.getText().toString();

                // Validate the registration details
                if (isValidRegistration(name, email, password)) {
                    // Create a new user with Firebase Authentication
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Registration success
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        if (user != null) {
                                            // Set the user's display name
                                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                    .setDisplayName(name)
                                                    .build();
                                            user.updateProfile(profileUpdates);

                                            // Start the login activity
                                            startActivity(new Intent(RRegister.this, dashboard.class));
                                            finish();
                                        }
                                    } else {
                                        // Registration failed
                                        Toast.makeText(RRegister.this, "Registration failed",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        // Check if the email is empty or does not match a valid email pattern
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        // Check if the password is at least 6 characters long
        return !TextUtils.isEmpty(password) && password.length() >= 6;
    }

    private boolean isValidRegistration(String name, String email, String password) {
        if (TextUtils.isEmpty(name)) {
            // Name is empty, show an error message
            Toast.makeText(RRegister.this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isValidEmail(email)) {
            // Email is invalid, show an error message
            Toast.makeText(RRegister.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isValidPassword(password)) {
            // Password is invalid, show an error message
            Toast.makeText(RRegister.this, "Invalid password. Password must be at least 6 characters long.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
