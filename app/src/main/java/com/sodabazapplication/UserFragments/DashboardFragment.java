package com.sodabazapplication.UserFragments;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.airbnb.lottie.L;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.Modelclasses.Dashboard_Market_ModelClass;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.UserFragments.Adapter.DashboardAdapter2;
import com.sodabazapplication.UserFragments.Adapter.UserAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DashboardFragment extends Fragment {


    ArrayList<DashboardModel_Class> dashboard_data = new ArrayList<>();

    ArrayList<Dashboard_Market_ModelClass> dashboardModel_classes = new ArrayList<>();
    RecyclerView recycle,recycle2;
    Endpoints endpoints;
    ProgressBar progressbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24-hour format
        int minute = calendar.get(Calendar.MINUTE);
        Log.d(TAG, "This is time: "+String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
        // You can now use the 'hour' and 'minute' variables as needed.
        // For example, to display the current time in a TextView:
        recycle = view.findViewById(R.id.recycle);
        recycle2 = view.findViewById(R.id.recycle2);
        endpoints = RetrofitClient.getEndpoints();
        progressbar = view.findViewById(R.id.progressbar);
        progressbar.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        UserAdapter userAdapter = new UserAdapter(dashboardModel_classes,getContext());
        recycle.setAdapter(userAdapter);




        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle2.setLayoutManager(new GridLayoutManager(getContext(),2));
        DashboardAdapter2 dashboardAdapter2 = new DashboardAdapter2(dashboard_data,getContext());
        recycle2.setAdapter(dashboardAdapter2);




        Call<List<DashboardModel_Class>> call = endpoints.getDashboardData();
        call.enqueue(new Callback<List<DashboardModel_Class>>() {
            @Override
            public void onResponse(@NonNull Call<List<DashboardModel_Class>> call, @NonNull Response<List<DashboardModel_Class>> response) {
                if (response.isSuccessful()){
                    progressbar.setVisibility(View.GONE);
                    List<DashboardModel_Class> data = response.body();
                    assert data != null;
                    dashboard_data.addAll(data);
                    for (int i=0;i<data.size();i++){
                        Log.d(TAG, "my is: "+data.get(i).getTitle());
                        Log.d(TAG,"ssssssss");
                    }
                    dashboardAdapter2.notifyDataSetChanged();
                    userAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DashboardModel_Class>> call, Throwable t) {

            }
        });

        Call<List<Dashboard_Market_ModelClass>> call1 = endpoints.getDashboardMarketData();
        call1.enqueue(new Callback<List<Dashboard_Market_ModelClass>>() {
            @Override
            public void onResponse(Call<List<Dashboard_Market_ModelClass>> call, Response<List<Dashboard_Market_ModelClass>> response) {
                try {
                    if (response.isSuccessful() && response.body()!=null){
                         List<Dashboard_Market_ModelClass> mydata = response.body();
                         dashboardModel_classes.addAll(mydata);
                         userAdapter.notifyDataSetChanged();
                    }
                }
                catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<Dashboard_Market_ModelClass>> call, Throwable t) {

            }
        });


        return view;
    }
}