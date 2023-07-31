package com.sodabazapplication.UserFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.Adapter.SubCategoryAdapter;
import com.sodabazapplication.UserFragments.Adapter.UserAdapter;

public class SubCategoryFragment extends Fragment {
    RecyclerView recycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter(getContext());
        recycler.setAdapter(subCategoryAdapter);
        return view;
    }
}