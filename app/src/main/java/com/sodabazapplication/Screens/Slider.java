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
        SharedPreferences onboard = getSharedPreferences("onboarding",Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
        boolean hasShownOnboarding = onboard.getBoolean("hasShownOnboarding", false);
        if (hasShownOnboarding){
            String checkUserStatus = sharedPreferences.getString("isUserLoggedIn", "");

            if (checkUserStatus.equals("true")) {
                // User is logged in, go to the Dashboard
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            } else {
                // User is not logged in, go to the login screen
                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
            }
            finish();
        }
        else {
            getSupportActionBar().hide();

            // Initialize ViewPager and set up the adapter
            viewPager = findViewById(R.id.viewpager);
            IntroAdapter adapter = new IntroAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);

            // Set the flag to indicate that onboarding has been shown
            SharedPreferences.Editor editor = onboard.edit();
            editor.putBoolean("hasShownOnboarding", true);
            editor.apply();
        }

//            if (checkUserStatus.equals("true")){
//                startActivity(new Intent(getApplicationContext(), Dashboard.class));
//                finish();
//            }
//            else {
//                startActivity(new Intent(getApplicationContext(),LoginScreen.class));
//                viewPager = findViewById(R.id.viewpager);
//                getSupportActionBar().hide();
//                IntroAdapter adapter = new IntroAdapter(getSupportFragmentManager());
//                viewPager.setAdapter(adapter);
//            }

    }
}