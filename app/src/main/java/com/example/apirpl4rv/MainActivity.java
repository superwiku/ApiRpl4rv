package com.example.apirpl4rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    List<Hewan>daftarHewan;
    ApiInterface apiInterface;
    HewanAdapter hewanAdapter;
    RecyclerView rvHewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHewan=(RecyclerView) findViewById(R.id.rv_hewan);
        layoutManager=new LinearLayoutManager(this);
        rvHewan.setLayoutManager(layoutManager);
        apiInterface=ApiClient.ambilData().create(ApiInterface.class);
        Call<List<Hewan>> getHewannya = apiInterface.getListHewan();
        getHewannya.enqueue(new Callback<List<Hewan>>() {
            @Override
            public void onResponse(Call<List<Hewan>> call, Response<List<Hewan>> response) {
                daftarHewan=response.body();
                hewanAdapter=new HewanAdapter(MainActivity.this,daftarHewan);
                rvHewan.setAdapter(hewanAdapter);
            }

            @Override
            public void onFailure(Call<List<Hewan>> call, Throwable t) {

            }
        });
    }
}