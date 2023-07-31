package com.sodabazapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sodabazapplication.R;

public class DescriptionScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_screen);
        getSupportActionBar().hide();
    }

    public void register(View view) {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
    public void signin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginScreen.class));
    }
}