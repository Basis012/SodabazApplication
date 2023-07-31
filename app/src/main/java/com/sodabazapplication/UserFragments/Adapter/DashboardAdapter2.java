package com.sodabazapplication.UserFragments.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.R;
import com.sodabazapplication.Screens.BtcCard;
import com.sodabazapplication.UserDashboard.Dashboard;

import java.util.ArrayList;

public class DashboardAdapter2 extends RecyclerView.Adapter<DashboardAdapter2.ViewHolder> {
    ArrayList<DashboardModel_Class> dashboard_data = new ArrayList<>();
    Context context;

    public DashboardAdapter2(ArrayList<DashboardModel_Class> dashboard_data, Context context) {
        this.dashboard_data = dashboard_data;
        this.context = context;
    }

    @NonNull
    @Override
    public DashboardAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dashboardcard2,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter2.ViewHolder holder, int position) {
            holder.category.setText(dashboard_data.get(position).getTitle());
        holder.subcategory.setText(dashboard_data.get(position).getSubtitle());
        holder.initialprice.setText(dashboard_data.get(position).getInitialprice());
        holder.actualprice.setText(dashboard_data.get(position).getActualprice());
        Glide.with(context)
                .load(dashboard_data.get(position).getImage())
                .into(holder.cardimage);
    }

    @Override
    public int getItemCount() {
        return dashboard_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView cardimage;
        TextView category,subcategory,initialprice,actualprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            category = itemView.findViewById(R.id.category);
            subcategory = itemView.findViewById(R.id.subcategory);
            initialprice = itemView.findViewById(R.id.initialprice);
            actualprice = itemView.findViewById(R.id.actualprice);
            cardimage = itemView.findViewById(R.id.cardimage);
        }
    }
}
