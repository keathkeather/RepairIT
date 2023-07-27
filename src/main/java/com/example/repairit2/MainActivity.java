package com.example.repairit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth auth;
    Button logoutBtn,askBtn,bookBtn;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logoutBtn = findViewById(R.id.logoutBtn);
        askBtn = findViewById(R.id.askBtn);
        bookBtn = findViewById(R.id.bookBtn);
//        textView =findViewById(R.id.user_details);
        user=auth.getCurrentUser();

        askBtn.setOnClickListener(this);
        bookBtn.setOnClickListener(this);

        if(user==null){
            Intent intent = new Intent(getApplicationContext(),Activity_Login.class);
            startActivity(intent);
            finish();

        }else{
//            textView.setText(user.getEmail());
        }
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Activity_Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.askBtn:
                Intent intent1 = new Intent(this, Activity_Ask.class);
                startActivity(intent1);
                break;
            case R.id.bookBtn:
                Intent intent2 = new Intent(this, Activity_expertList.class);
                startActivity(intent2);
                break;
        }
    }


}