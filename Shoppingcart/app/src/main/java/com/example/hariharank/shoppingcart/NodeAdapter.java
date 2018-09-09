package com.example.hariharank.shoppingcart;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NodeAdapter extends RecyclerView.Adapter<NodeHolder> {
    Context context;
    List<Phone> phones;
    public NodeAdapter(Context context, List<Phone> list){
        this.context = context;
        phones = list;
    }

    @NonNull
    @Override
    public NodeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_phone, parent,false );
        NodeHolder nh = new NodeHolder(v);
        return nh;
    }

    @Override
    public void onBindViewHolder(@NonNull NodeHolder hold, int position) {

        final String phone = phones.get(position).getModel();
        hold.model.setText(phones.get(position).getModel());
        hold.manufacturer.setText(phones.get(position).getManufacturer());
        hold.price.setText("₹" + phones.get(position).getPrice());
        hold.itemView.setOnClickListener(v -> search(phone));
        Glide.with(context).load(Uri.parse(phones.get(position).getImage())).into(hold.imageView);

    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    public void search(final String phone){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.activity_dialogue, null);
        dialog.setView(view);

        final EditText username = view.findViewById(R.id.username);
        final EditText quantity = view.findViewById(R.id.quantity);

        dialog.setPositiveButton("OK", (dialog1, which) -> {
            Api api = ApiClient.RetrofitCall().create(Api.class);
            Call<Buy> call = api.getBuy(phone, username.getText().toString(), quantity.getText().toString());
            call.enqueue(new Callback<Buy>() {
                @Override
                public void onResponse(Call<Buy> call, Response<Buy> response) {
                    Toast.makeText(context, "Absolutely right !!", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<Buy> call, Throwable t) {
                    Toast.makeText(context,t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });
        dialog.setNegativeButton("CANCEL", (dialog12, which) -> dialog12.dismiss());
        dialog.setTitle("Information: ");
        AlertDialog hello = dialog.create();

        hello.show();
    }

}