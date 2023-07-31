package com.sodabazapplication.UserFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.UserFragments.Adapter.ExpireInquiryAdapter;
import com.sodabazapplication.UserFragments.Adapter.ExpireInquiryCard1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpiredEnquiries extends Fragment {
    RecyclerView recycle1;
    BarChart barchart;
    Endpoints endpoints;
    ArrayList<DashboardModel_Class> wallet_data = new ArrayList<>();
    ProgressBar progressbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expired_enquiries, container, false);
        recycle1 = view.findViewById(R.id.recycle1);
        barchart = view.findViewById(R.id.barchart);
        progressbar = view.findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);
        endpoints = RetrofitClient.getEndpoints();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i=1;i<10;i++){
            float value = (float) (i*10.0);
            BarEntry barEntry = new BarEntry(i,value);
            barEntries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries,"Employee");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(false);
        barchart.setData(new BarData(barDataSet));
        barchart.animateX(2500);
        barchart.getDescription().setText("Employee Chart");
        barchart.getDescription().setTextColor(Color.BLUE);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle1.setLayoutManager(linearLayoutManager1);
        ExpireInquiryCard1 expireInquiryCard1 = new ExpireInquiryCard1(wallet_data,getContext());
        recycle1.setAdapter(expireInquiryCard1);

        Call<List<DashboardModel_Class>> call = endpoints.getDashboardData();
        call.enqueue(new Callback<List<DashboardModel_Class>>() {
            @Override
            public void onResponse(Call<List<DashboardModel_Class>> call, Response<List<DashboardModel_Class>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    progressbar.setVisibility(View.GONE);
                   List<DashboardModel_Class> dashboardModel_class = response.body();
                   wallet_data.addAll(dashboardModel_class);
                   expireInquiryCard1.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DashboardModel_Class>> call, Throwable t) {

            }
        });
        return view;
    }
}