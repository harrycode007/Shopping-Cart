package com.example.hariharank.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter<NodeHolder> madapter;
    List<Phone> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<Phone>();
        Api api = ApiClient.RetrofitCall().create(Api.class);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Call<List<Phone>> call = api.getResult();
        if(bundle != null) {
            String model = bundle.getString("Model");
            String manufacturer = bundle.getString("Manufacturer");
            String minprice = bundle.getString("min_price");
            String maxprice = bundle.getString("max_price");


            if (model == null && manufacturer == null && minprice == null && maxprice == null) {

                call = api.getResult();
            } else {
                call = api.getResult(manufacturer,model, minprice, maxprice);
            }
        }


        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                Log.i("url",call.request().url().toString());
                arrayList = response.body();
                renderPhones();
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.info:
                Intent intentx = new Intent(MainActivity.this,SalesActivity.class);
                startActivity(intentx);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void renderPhones(){
        madapter = new NodeAdapter(this , arrayList);
        madapter.notifyDataSetChanged();
        recyclerView.setAdapter(madapter);

    }

    @Override
    public void onBackPressed() {
        Intent main = new Intent(Intent.ACTION_MAIN);
        main.addCategory(Intent.CATEGORY_HOME);
        main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(main);
    }
}