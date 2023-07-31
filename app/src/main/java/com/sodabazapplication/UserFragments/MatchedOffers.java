package com.sodabazapplication.UserFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.sodabazapplication.Modelclasses.Market_Model_Class;
import com.sodabazapplication.R;
import com.sodabazapplication.RetrofitClient;
import com.sodabazapplication.Services.Endpoints;
import com.sodabazapplication.UserFragments.Adapter.MatchedOfferAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchedOffers extends Fragment {
    RecyclerView recycle;
    TextInputEditText coinname;
    MatchedOfferAdapter matchedOfferAdapter;
    ArrayList<Market_Model_Class> market_data = new ArrayList<>();

    ArrayList<Market_Model_Class> filtereddata = new ArrayList<>();


    Endpoints endpoints;
    ProgressBar progressbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_matched_offers, container, false);
    recycle = view.findViewById(R.id.recycle);
    progressbar = view.findViewById(R.id.progressbar);
    coinname = view.findViewById(R.id.coinname);
    coinname.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String searchtext = charSequence.toString().toLowerCase().trim();
            if (searchtext.isEmpty()){
                filtereddata.clear();
                filtereddata.addAll(market_data);
                matchedOfferAdapter.notifyDataSetChanged();
            }
            else {
                filtereddata.clear();
                for (Market_Model_Class item: market_data){
                   if (item.getTitle().toLowerCase().contains(searchtext)){
                       filtereddata.add(item);
                   }
                }
                matchedOfferAdapter.notifyDataSetChanged();
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });
    progressbar.setVisibility(View.VISIBLE);
    endpoints = RetrofitClient.getEndpoints();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        matchedOfferAdapter = new MatchedOfferAdapter(market_data,filtereddata,getContext());
        recycle.setAdapter(matchedOfferAdapter);


        Call<List<Market_Model_Class>> call = endpoints.getMarketData();
        call.enqueue(new Callback<List<Market_Model_Class>>() {
            @Override
            public void onResponse(Call<List<Market_Model_Class>> call, Response<List<Market_Model_Class>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    progressbar.setVisibility(View.GONE);
                    List<Market_Model_Class> data = response.body();
                    market_data.clear();
                    filtereddata.addAll(data);
                    market_data.addAll(data);
                    matchedOfferAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Market_Model_Class>> call, Throwable t) {

            }
        });
    return view;
    }
}