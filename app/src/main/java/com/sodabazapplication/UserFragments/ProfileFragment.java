package com.sodabazapplication.UserFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.bottomnavfragment.About;
import com.sodabazapplication.UserFragments.bottomnavfragment.Contact;
import com.sodabazapplication.UserFragments.bottomnavfragment.Home;

public class ProfileFragment extends Fragment {
    BottomNavigationView bottomnav1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
       bottomnav1 = view.findViewById(R.id.bottomnav1);
       bottomnav1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();
               if (id==R.id.page1){
                   gotoFragment(new Home());
               }
               else if (id==R.id.page2){
                   gotoFragment(new About());
               }
               else if (id==R.id.page3){
                   gotoFragment(new Contact());
               }
               return false;
           }
       });
       return view;
    }
    public void gotoFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}