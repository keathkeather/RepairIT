package com.example.repairit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_Ask extends AppCompatActivity {
    Button submitBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        submitBtn = findViewById(R.id.submitBtn);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Ask.this,"Problem Submitted!",Toast.LENGTH_SHORT).show();
                Intent toExpertList = new Intent(Activity_Ask.this,Activity_expertList.class);
                startActivity(toExpertList);
                finish();
            }
        });


    }
}