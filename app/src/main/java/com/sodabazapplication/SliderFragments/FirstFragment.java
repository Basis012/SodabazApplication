package com.sodabazapplication.SliderFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.sodabazapplication.R;
import com.sodabazapplication.Screens.DescriptionScreen;
import com.sodabazapplication.Screens.LoginScreen;

public class FirstFragment extends Fragment {
    MaterialButton gotonext;
    ViewPager viewPager;
    CardView skipbtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
   gotonext = view.findViewById(R.id.gotonext);
   skipbtn = view.findViewById(R.id.skipbtn);
   skipbtn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           startActivity(new Intent(getContext(), DescriptionScreen.class));
       }
   });
   viewPager = getActivity().findViewById(R.id.viewpager);
        gotonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               viewPager.setCurrentItem(1);
            }
        });
        return view;
    }
}