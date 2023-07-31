package com.sodabazapplication.UserFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.airbnb.lottie.L;
import com.google.android.material.button.MaterialButton;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.Modelclasses.Dashboard_Market_ModelClass;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.UserDashboard.Dashboard;
import com.sodabazapplication.UserFragments.Adapter.BidsPlaceAdapter;
import com.sodabazapplication.UserFragments.Adapter.BidsPlaceAdapter1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BidsPlaced extends Fragment {
    RecyclerView recycle,recycle1;
    Endpoints endpoints;
    ArrayList<DashboardModel_Class> trad_data1 = new ArrayList<>();
    ArrayList<Dashboard_Market_ModelClass> trad_data2 = new ArrayList<>();
    MaterialButton tradebtn;
    ProgressBar progressbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bids_placed, container, false);
        recycle = view.findViewById(R.id.recycle);
        recycle1 = view.findViewById(R.id.recycle1);
        tradebtn = view.findViewById(R.id.tradebtn);
        progressbar = view.findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);
        endpoints = RetrofitClient.getEndpoints();
        tradebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        BidsPlaceAdapter bidsPlaceAdapter = new BidsPlaceAdapter(trad_data2,getContext());
        recycle.setAdapter(bidsPlaceAdapter);


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle1.setLayoutManager(linearLayoutManager1);
        BidsPlaceAdapter1 bidsPlaceAdapter1 = new BidsPlaceAdapter1(trad_data1,getContext());
        recycle1.setAdapter(bidsPlaceAdapter1);


        Call<List<Dashboard_Market_ModelClass>> call1 = endpoints.getDashboardMarketData();
        call1.enqueue(new Callback<List<Dashboard_Market_ModelClass>>() {
            @Override
            public void onResponse(Call<List<Dashboard_Market_ModelClass>> call, Response<List<Dashboard_Market_ModelClass>> response) {
                try {
                    if (response.isSuccessful() && response.body()!=null){
                        progressbar.setVisibility(View.GONE);
                        List<Dashboard_Market_ModelClass> data = response.body();
                        trad_data2.addAll(data);
                        bidsPlaceAdapter.notifyDataSetChanged();
                    }
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<Dashboard_Market_ModelClass>> call, Throwable t) {

            }
        });




        Call<List<DashboardModel_Class>> call = endpoints.getDashboardData();
        call.enqueue(new Callback<List<DashboardModel_Class>>() {
            @Override
            public void onResponse(Call<List<DashboardModel_Class>> call, Response<List<DashboardModel_Class>> response) {
                try {
                    if (response.isSuccessful() && response.body()!=null){
                        progressbar.setVisibility(View.GONE);
                        List<DashboardModel_Class> data = response.body();
                        trad_data1.addAll(data);
                        bidsPlaceAdapter1.notifyDataSetChanged();
                    }
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<DashboardModel_Class>> call, Throwable t) {

            }
        });
        return view;
    }
}