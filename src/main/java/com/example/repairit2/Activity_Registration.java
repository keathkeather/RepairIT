package com.example.repairit2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_Registration extends AppCompatActivity {
    TextInputEditText Email,Password;
    Button btnRegister;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView clickText;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent openMain  = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(openMain);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.RegEmail);
        Password=findViewById(R.id.RegPassword);
        btnRegister = findViewById(R.id.btnRegister);
        progressBar = findViewById(R.id.progressBar);
        clickText = findViewById(R.id.loginNow);
        clickText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity_Login.class);
                startActivity(intent);
                finish();
            }
        });



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String inputEmail,inputPassword;
                inputEmail = String.valueOf(Email.getText());
                inputPassword = String.valueOf(Password.getText());

                if(TextUtils.isEmpty(inputEmail)){
                    Toast.makeText(Activity_Registration.this,"Enter Email",Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(inputPassword)){
                    Toast.makeText(Activity_Registration.this,"Enter Password",Toast.LENGTH_SHORT).show();

                }

                mAuth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(Activity_Registration.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Activity_Registration.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
        });
    }
}