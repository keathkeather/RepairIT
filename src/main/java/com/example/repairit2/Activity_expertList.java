package com.example.repairit2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_expertList extends AppCompatActivity implements View.OnClickListener {
    Button bogartBtn, arielBtn, dodongBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list);

        bogartBtn = findViewById(R.id.bogartBtn);
        arielBtn = findViewById(R.id.arielBtn);
        dodongBtn = findViewById(R.id.dodongBtn);

        bogartBtn.setOnClickListener(this);
        arielBtn.setOnClickListener(this);
        dodongBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogartBtn:
                Intent intent1 = new Intent(Activity_expertList.this, Acitivty_Bogart.class);
                startActivity(intent1);
                break;
            case R.id.arielBtn:
                Intent intent2 = new Intent(Activity_expertList.this, Activity_Ariel.class);
                startActivity(intent2);
                break;
            case R.id.dodongBtn:
                Intent intent3 = new Intent(Activity_expertList.this, Activity_Dodong.class);
                startActivity(intent3);
                break;
        }
    }
}
