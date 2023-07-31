package com.sodabazapplication.UserDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import com.sodabazapplication.R;
import com.sodabazapplication.Screens.LoginScreen;
import com.sodabazapplication.UserFragments.BidsPlaced;
import com.sodabazapplication.UserFragments.BidsReceived;
import com.sodabazapplication.UserFragments.CategoryFragment;
import com.sodabazapplication.UserFragments.CreateInquiry;
import com.sodabazapplication.UserFragments.DashboardFragment;
import com.sodabazapplication.UserFragments.ExpiredEnquiries;
import com.sodabazapplication.UserFragments.Logout;
import com.sodabazapplication.UserFragments.MatchedOffers;
import com.sodabazapplication.UserFragments.Products;
import com.sodabazapplication.UserFragments.ProfileFragment;
import com.sodabazapplication.UserFragments.SubCategoryFragment;
import com.sodabazapplication.UserFragments.Units;
import com.sodabazapplication.UserFragments.ViewInquiry;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Dashboard extends AppCompatActivity {
 DrawerLayout drawer;
 NavigationView navigation;
 ChipNavigationBar nav;
 TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username",null);
        navigation = findViewById(R.id.navigation);
        username = navigation.getHeaderView(0).findViewById(R.id.username);
        username.setText(name);
        getSupportActionBar().setTitle("");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,new DashboardFragment());
        fragmentTransaction.commit();
        drawer = findViewById(R.id.drawer);

        nav = findViewById(R.id.nav);
       nav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
           @Override
           public void onItemSelected(int i) {
               if (i==R.id.page1){
                   goFragment(new DashboardFragment());
               }
               else if (i==R.id.page2){
                   goFragment(new MatchedOffers());
               }
               else if (i==R.id.page3){
                   goFragment(new BidsPlaced());
               }
               else if (i==R.id.page4){
                   goFragment(new ExpiredEnquiries());
               }
           }
       });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.item1){
                    goFragment(new DashboardFragment());
                }
                else if (item.getItemId()==R.id.item2){
                    goFragment(new ProfileFragment());
                }
                else if (item.getItemId()==R.id.item3){
                    goFragment(new CategoryFragment());
                }
                else if (item.getItemId()==R.id.item4){
                    goFragment(new SubCategoryFragment());
                }
                else if (item.getItemId()==R.id.item5){
                    goFragment(new Units());
                }
                else if (item.getItemId()==R.id.item6){
                    goFragment(new Products());
                }
                else if (item.getItemId()==R.id.item7){
                    goFragment(new ViewInquiry());
                }
                else if (item.getItemId()==R.id.item8){
                    goFragment(new CreateInquiry());
                }
                else if (item.getItemId()==R.id.item10){
                    goFragment(new BidsReceived());
                }
                else if (item.getItemId()==R.id.item13){
                    SharedPreferences sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                    finish();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
if (item.getItemId()==android.R.id.home){
           if (drawer.isOpen()){
               drawer.close();
           }
           else {
               drawer.openDrawer(GravityCompat.START);
           }
}
        return super.onOptionsItemSelected(item);
    }
    public void goFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
        drawer.close();
    }
}