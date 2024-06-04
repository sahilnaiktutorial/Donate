package com.example.donate;

import static android.app.ProgressDialog.show;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class Startpage extends AppCompatActivity {

    private EditText Loginemail, LoginPassword;
    private Button Login, Register;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        // Set custom action bar
        //ActionBar actionBar = getSupportActionBar();
        // if (actionBar != null) {
        // actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // actionBar.setCustomView(R.layout.custom_action_bar);
        // actionBar.setElevation(0); // Optional: Remove elevation shadow
        //  }
        TextView tvTitle = findViewById(R.id.action_bar_title);
        tvTitle.setText("Donate2Share");
        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        Loginemail = findViewById(R.id.loginemail);
        LoginPassword = findViewById(R.id.loginpassword);
        Login = findViewById(R.id.login);
        Register = findViewById(R.id.register);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Loginemail.getText().toString();
                String password = LoginPassword.getText().toString();
                if (isValidCredentials(email, password)) {
                    // Perform login with Firebase Authentication
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Login success
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        if (user != null) {
                                            // Check if the user is an admin
                                            if (isAdmin(user, "admin123")) {
                                                // Start the admin activity
                                                startActivity(new Intent(Startpage.this,Admindashboard.class));
                                            } else {
                                                // Start the user activity
                                                startActivity(new Intent(Startpage.this, dashboard.class));
                                            }
                                            finish();
                                        }
                                    } else {
                                        // Login failed
                                        Toast.makeText(Startpage.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(Startpage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Handle register button click
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the register activity
                startActivity(new Intent(Startpage.this, RRegister.class));

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

    private boolean isValidCredentials(String email, String password) {
        if (!isValidEmail(email)) {
            // Email is invalid, show an error message
            Toast.makeText(Startpage.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!isValidPassword(password)) {
            // Password is invalid, show an error message
            Toast.makeText(Startpage.this, "Invalid password. Password must be at least 6 characters long.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    
    private boolean isAdmin(FirebaseUser user, String password) {
        // Implement your logic to check if the user is an admin
        // For example, you can compare the provided password with a predefined admin password

        // Replace this with your own admin check logic
        String adminEmail = "nehav2066@gmail.com";
        String adminPassword = "admin123";

        String userEmail = user.getEmail();
        if (userEmail != null && userEmail.equals(adminEmail)) {
            if (password != null && password.equals(adminPassword)) {
                return true; // User is an admin
            }
        }

        return false; // User is not an admin
    }





    }


