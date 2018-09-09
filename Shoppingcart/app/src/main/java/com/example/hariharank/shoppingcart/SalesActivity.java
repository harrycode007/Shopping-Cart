package com.example.hariharank.shoppingcart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesActivity extends AppCompatActivity {
    View load;
    RecyclerView recycler;
    RecyclerView.LayoutManager layoutManager1;
    SalesAdapter sadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        load = findViewById(R.id.progress);
        load.setVisibility(View.VISIBLE);
        recycler = findViewById(R.id.recycler_buy);
        Retrofit retrofit = ApiClient.RetrofitCall();
        Api api = retrofit.create(Api.class);

        Call<List<Buy>> call;
        call = api.getSales();

        call.enqueue(new Callback<List<Buy>>() {
            @Override
            public void onResponse(Call<List<Buy>> call, Response<List<Buy>> response) {
                List<Buy> arr = response.body();
                layoutManager1 = new LinearLayoutManager(getApplicationContext());
                recycler.setLayoutManager(layoutManager1);
                sadapter = new SalesAdapter(getApplicationContext(),arr);
                load.setVisibility(View.INVISIBLE);
                recycler.setAdapter(sadapter);

            }

            @Override
            public void onFailure(Call<List<Buy>> call, Throwable t) {
                Log.i("url call",call.request().url().toString());
                Toast.makeText(getApplicationContext(), call.request().url().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}