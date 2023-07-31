package com.sodabazapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sodabazapplication.R;
import com.sodabazapplication.UserFragments.Adapter.MoreInfoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MoreInfo extends AppCompatActivity {
 RecyclerView morerecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        getSupportActionBar().hide();
        morerecycle = findViewById(R.id.morerecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        morerecycle.setLayoutManager(linearLayoutManager);
        MoreInfoAdapter moreInfoAdapter = new MoreInfoAdapter();
        morerecycle.setAdapter(moreInfoAdapter);
    }
}