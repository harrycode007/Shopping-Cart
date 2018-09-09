package com.example.hariharank.shoppingcart;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NodeHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView model;
    TextView manufacturer;
    TextView price;


    public NodeHolder(View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        model = itemView.findViewById(R.id.model);
        manufacturer = itemView.findViewById(R.id.manufacturer);
        price = itemView.findViewById(R.id.price);
    }

}