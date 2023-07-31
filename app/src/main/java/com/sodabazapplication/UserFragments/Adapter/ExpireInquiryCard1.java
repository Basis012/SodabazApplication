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

public class ExpireInquiryCard1 extends RecyclerView.Adapter<ExpireInquiryCard1.ViewHolder> {
    ArrayList<DashboardModel_Class> wallet_data = new ArrayList<>();
    Context context;

    public ExpireInquiryCard1(ArrayList<DashboardModel_Class> wallet_data, Context context) {
        this.wallet_data = wallet_data;
        this.context = context;
    }

    @NonNull
    @Override
    public ExpireInquiryCard1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.expireinquirycard1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpireInquiryCard1.ViewHolder holder, int position) {
          holder.walletinitialprice.setText(wallet_data.get(position).getInitialprice());
        holder.walletactualprice.setText(wallet_data.get(position).getActualprice());
        holder.walletsubtitle.setText(wallet_data.get(position).getSubtitle());
        holder.wallettitle.setText(wallet_data.get(position).getTitle());
        Glide.with(context)
                .load(wallet_data.get(position).getImage())
                .into(holder.walletimage);

    }

    @Override
    public int getItemCount() {
        return wallet_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView walletimage;
        TextView wallettitle,walletsubtitle,walletactualprice,walletinitialprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            walletimage = itemView.findViewById(R.id.walletimage);
            wallettitle = itemView.findViewById(R.id.wallettitle);
            walletsubtitle = itemView.findViewById(R.id.walletsubtitle);
            walletactualprice = itemView.findViewById(R.id.walletactualprice);
            walletinitialprice = itemView.findViewById(R.id.walletinitialprice);
        }
    }
}
