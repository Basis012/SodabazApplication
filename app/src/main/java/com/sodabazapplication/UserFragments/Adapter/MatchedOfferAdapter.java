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
import com.sodabazapplication.Modelclasses.Market_Model_Class;
import com.sodabazapplication.R;

import java.util.ArrayList;

public class MatchedOfferAdapter extends RecyclerView.Adapter<MatchedOfferAdapter.ViewHolder> {
    ArrayList<Market_Model_Class> market_data = new ArrayList<>();
    ArrayList<Market_Model_Class> filtereddata = new ArrayList<>();
    Context context;

    public MatchedOfferAdapter(ArrayList<Market_Model_Class> market_data, ArrayList<Market_Model_Class> filtereddata, Context context) {
        this.market_data = market_data;
        this.filtereddata = filtereddata;
        this.context = context;
    }

    @NonNull
    @Override
    public MatchedOfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.matchoffercard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchedOfferAdapter.ViewHolder holder, int position) {
        Market_Model_Class item = filtereddata.get(position);


        holder.marketsubtitle.setText(item.getSubtitle());
        holder.markettitle.setText(item.getTitle());
        holder.marketsellactualprice.setText(item.getSellactualprice());
        holder.marketsellinitialprice.setText(item.getSellinitialprice());
        holder.marketbuyactualprice.setText(item.getBuyactualprice());
        holder.marketbuyinitialprice.setText(item.getBuyinitialprice());
        Glide.with(context)
                .load(market_data.get(position).getImage())
                .into(holder.marketimage);
        holder.marketsubtitle.setText(market_data.get(position).getSubtitle());
    }
    @Override
    public int getItemCount() {
        return filtereddata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView marketimage;
        TextView markettitle,marketbuyactualprice,marketsellactualprice,marketsubtitle,marketbuyinitialprice,marketsellinitialprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            marketimage = itemView.findViewById(R.id.marketimage);
            markettitle = itemView.findViewById(R.id.markettitle);
            marketbuyactualprice = itemView.findViewById(R.id.marketbuyactualprice);
            marketsellactualprice = itemView.findViewById(R.id.marketsellactualprice);
            marketsubtitle = itemView.findViewById(R.id.marketsubtitle);
            marketbuyinitialprice = itemView.findViewById(R.id.marketbuyinitialprice);
            marketsellinitialprice = itemView.findViewById(R.id.marketsellinitialprice);
        }
    }
}
