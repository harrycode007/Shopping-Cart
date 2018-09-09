package com.example.hariharank.shoppingcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesHolder> {
    Context context;
    List<Buy> buy;

    public SalesAdapter(Context context, List<Buy> buy) {
        this.context = context;
        this.buy = buy;
    }

    @NonNull
    @Override
    public SalesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.buyinfo, parent, false);
        SalesHolder sh = new SalesHolder(v);
        return sh;
    }

    @Override
    public void onBindViewHolder(@NonNull SalesHolder hold, int position) {
        hold.t1.setText("Invoice Number: " + buy.get(position).getInvoiceNumber());
        hold.t2.setText("Model: " + buy.get(position).getModel());
        hold.t3.setText("Quantity: " + buy.get(position).getQuantity());
        hold.t4.setText("Username: " + buy.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return buy.size();
    }

}