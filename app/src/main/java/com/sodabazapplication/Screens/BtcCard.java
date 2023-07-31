package com.sodabazapplication.Screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.sodabazapplication.BtcFragments.Chart;
import com.sodabazapplication.BtcFragments.OrderBook;
import com.sodabazapplication.BtcFragments.Trades;
import com.sodabazapplication.R;

import java.util.ArrayList;

public class BtcCard extends AppCompatActivity {
 BottomNavigationView bottom;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btc_card);
        getSupportActionBar().hide();
       pieChart = findViewById(R.id.piechart);
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
//        bottom = findViewById(R.id.bottom);
//        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId()==R.id.saqib1){
//                    gotoFragment(new Chart());
//                }
//                else if (item.getItemId()==R.id.saqib2){
//                    gotoFragment(new OrderBook());
//                }
//                else if (item.getItemId()==R.id.saqib3){
//                    gotoFragment(new Trades());
//                }
//                return false;
//            }
//        });
    }
    public void gotoFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}