package com.sodabazapplication.SliderFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.sodabazapplication.R;
import com.sodabazapplication.Screens.DescriptionScreen;

public class ThirdFragment extends Fragment {
   MaterialButton gotonext;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
     gotonext = view.findViewById(R.id.gotonext);
        viewPager = getActivity().findViewById(R.id.viewpager);
      gotonext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(getActivity(), DescriptionScreen.class));
          }
      });
      return view;
    }
}