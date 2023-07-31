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
import com.sodabazapplication.Modelclasses.Dashboard_Market_ModelClass;
import com.sodabazapplication.R;

import java.util.ArrayList;

public class BidsPlaceAdapter extends RecyclerView.Adapter<BidsPlaceAdapter.ViewHolder> {
    ArrayList<Dashboard_Market_ModelClass> trad_data2 = new ArrayList<>();
    Context context;

    public BidsPlaceAdapter(ArrayList<Dashboard_Market_ModelClass> trad_data2, Context context) {
        this.trad_data2 = trad_data2;
        this.context = context;
    }

    @NonNull
    @Override
    public BidsPlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bidsplacecard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BidsPlaceAdapter.ViewHolder holder, int position) {
        holder.tradetitle.setText(trad_data2.get(position).getTitle());
        holder.tradesubtitle.setText(trad_data2.get(position).getSubtitle());
        holder.tradesubtitle1.setText(trad_data2.get(position).getSubtitle());
        holder.tradeactualprice.setText(trad_data2.get(position).getActualprice());
        Glide.with(context)
                .load(trad_data2.get(position).getImage())
                .into(holder.tradeimage);
    }

    @Override
    public int getItemCount() {
        return trad_data2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView tradeimage;
        TextView tradetitle,tradeactualprice,tradesubtitle,tradesubtitle1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tradetitle = itemView.findViewById(R.id.tradetitle);
            tradesubtitle = itemView.findViewById(R.id.tradesubtitle);
            tradesubtitle1 = itemView.findViewById(R.id.tradesubtitle1);
            tradeactualprice = itemView.findViewById(R.id.tradeactualprice);
            tradeimage = itemView.findViewById(R.id.tradeimage);

        }
    }
}
