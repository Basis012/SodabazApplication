package com.sodabazapplication.UserFragments.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sodabazapplication.Modelclasses.DashboardModel_Class;
import com.sodabazapplication.R;

import java.util.ArrayList;

public class BidsPlaceAdapter1 extends RecyclerView.Adapter<BidsPlaceAdapter1.ViewHolder>{

    ArrayList<DashboardModel_Class> trad_data1 = new ArrayList<>();
    Context context;

    public BidsPlaceAdapter1(ArrayList<DashboardModel_Class> trad_data1, Context context) {
        this.trad_data1 = trad_data1;
        this.context = context;
    }

    @NonNull
    @Override
    public BidsPlaceAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bidsplacecard1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BidsPlaceAdapter1.ViewHolder holder, int position) {
        holder.tradetitle.setText(trad_data1.get(position).getTitle());
        holder.tradenumber.setText(trad_data1.get(position).getActualprice());
        holder.tradepoints.setText(trad_data1.get(position).getInitialprice());
        Glide.with(context)
                .load(trad_data1.get(position).getImage())
                .into(holder.tradeimage);


    }

    @Override
    public int getItemCount() {
        return trad_data1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tradetitle,tradenumber,tradepoints;
        ImageView tradeimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tradeimage = itemView.findViewById(R.id.tradeimage);
            tradetitle = itemView.findViewById(R.id.tradetitle);
            tradenumber = itemView.findViewById(R.id.tradenumber);
            tradepoints = itemView.findViewById(R.id.tradepoints);
        }
    }
}
