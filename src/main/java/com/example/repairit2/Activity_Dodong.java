package com.example.repairit2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.repairit2.databinding.ActivityDodongBinding;

public class Activity_Dodong extends AppCompatActivity {


    Button bookDBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodong);
        bookDBtn=findViewById(R.id.bookDBtn);
        bookDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Dodong.this,Activity_bookedDodong.class);
                startActivity(intent);
                finish();
            }
        });
    }




}