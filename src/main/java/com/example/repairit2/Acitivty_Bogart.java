package com.example.repairit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acitivty_Bogart extends AppCompatActivity {
    Button bookBBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivty_bogart);

        bookBBtn=findViewById(R.id.bookBBtn);
        bookBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acitivty_Bogart.this,Activity_bookedBogart.class);
                startActivity(intent);
                finish();
            }
        });

    }
}