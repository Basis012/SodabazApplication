package com.sodabazapplication.UserFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.Adapter.BidsReceiveAdapter;

public class BidsReceived extends Fragment {
    RecyclerView recycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bids_received, container, false);
        recycle  = view.findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycle.setLayoutManager(linearLayoutManager);
        BidsReceiveAdapter bidsReceiveAdapter = new BidsReceiveAdapter();
        recycle.setAdapter(bidsReceiveAdapter);
        return view;
    }
}