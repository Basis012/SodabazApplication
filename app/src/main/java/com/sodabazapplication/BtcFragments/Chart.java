package com.sodabazapplication.BtcFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.sodabazapplication.R;

import java.util.ArrayList;

public class Chart extends Fragment {
    PieChart pieChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_chart, container, false);
       pieChart = view.findViewById(R.id.piechart);
       ArrayList<PieEntry> pieEntries = new ArrayList<>();
       for (int i=0;i<10;i++){
           float value = (float) (i*10.0);
           PieEntry pieEntry = new PieEntry(i,value);
           pieEntries.add(pieEntry);
       }

       PieDataSet pieDataSet = new PieDataSet(pieEntries,"Users");
       pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
       pieChart.setData(new PieData(pieDataSet));
       pieChart.animateXY(2000,2000);
       pieChart.getDescription().setEnabled(false);
       return view;
    }
}