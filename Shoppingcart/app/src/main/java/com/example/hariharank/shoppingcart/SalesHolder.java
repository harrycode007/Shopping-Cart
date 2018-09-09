package com.example.hariharank.shoppingcart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SalesHolder extends RecyclerView.ViewHolder{
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;

    public SalesHolder(View itemView){
        super(itemView);
        t1 = itemView.findViewById(R.id.invoice);
        t2 = itemView.findViewById(R.id.model);
        t3 = itemView.findViewById(R.id.quantity);
        t4 = itemView.findViewById(R.id.username);

    }
}