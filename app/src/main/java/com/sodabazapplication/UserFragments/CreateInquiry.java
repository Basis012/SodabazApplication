package com.sodabazapplication.UserFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.L;
import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.Adapter.CreateInquiryAdapter;

public class CreateInquiry extends Fragment {
    RecyclerView recycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_inquiry, container, false);
        recycle = view.findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        CreateInquiryAdapter createInquiryAdapter = new CreateInquiryAdapter();
        recycle.setAdapter(createInquiryAdapter);
        return view;
    }
}