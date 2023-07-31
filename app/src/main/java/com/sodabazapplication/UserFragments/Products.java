package com.sodabazapplication.UserFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.Adapter.ProductAdapter;

public class Products extends Fragment {
    RecyclerView recycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        recycle = view.findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        ProductAdapter productAdapter = new ProductAdapter();
        recycle.setAdapter(productAdapter);
        return view;
    }
}