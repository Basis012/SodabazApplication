package com.sodabazapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.sodabazapplication.PrefManager;
import com.sodabazapplication.Screens.ImageSlider.IntroAdapter;
import com.sodabazapplication.R;
import com.sodabazapplication.UserDashboard.Dashboard;

public class Slider extends AppCompatActivity {
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        PrefManager prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            // Show the introductory screen
            setContentView(R.layout.fragment_first); // Replace with the layout containing the introductory screen
            prefManager.setFirstTimeLaunch(false); // Set the flag to false to indicate the screen has been shown once
        } else {
            // The introductory screen has been shown before, proceed with your regular content
            setContentView(R.layout.activity_login_screen); // Replace with your main layout
        }

        SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
        String checkUserStatus = sharedPreferences.getString("isUserLoggedIn", "");
        if (checkUserStatus.equals("true")){
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }
        else {
            startActivity(new Intent(getApplicationContext(),LoginScreen.class));
        }
        viewPager = findViewById(R.id.viewpager);
        getSupportActionBar().hide();
        IntroAdapter adapter = new IntroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}