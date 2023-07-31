package com.sodabazapplication.UserFragments.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.Modelclasses.Dashboard_Market_ModelClass;
import com.sodabazapplication.R;
import com.sodabazapplication.Screens.MoreInfo;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
 ArrayList<Dashboard_Market_ModelClass> dashboardModel_classes = new ArrayList<>();
 Context context;

    public UserAdapter(ArrayList<Dashboard_Market_ModelClass> dashboardModel_classes, Context context) {
        this.dashboardModel_classes = dashboardModel_classes;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dashboardcard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
           holder.subcategory.setText(dashboardModel_classes.get(position).getTitle());
        holder.category.setText(dashboardModel_classes.get(position).getSubtitle());
        holder.initialprice.setText(dashboardModel_classes.get(position).getInitialprice());
        holder.actualprice.setText(dashboardModel_classes.get(position).getActualprice());
        Glide.with(context)
                .load(dashboardModel_classes.get(position).getImage())
                .into(holder.cardimage1);
    }

    @Override
    public int getItemCount() {
        return dashboardModel_classes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView category, subcategory,actualprice,initialprice;
      ImageView cardimage1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
      category = itemView.findViewById(R.id.category);
      subcategory = itemView.findViewById(R.id.subcategory);
      actualprice = itemView.findViewById(R.id.actualprice);
      initialprice = itemView.findViewById(R.id.initialprice);
            cardimage1 = itemView.findViewById(R.id.cardimage1);
        }
    }
}
