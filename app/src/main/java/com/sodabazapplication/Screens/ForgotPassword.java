package com.sodabazapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sodabazapplication.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();
    }
}