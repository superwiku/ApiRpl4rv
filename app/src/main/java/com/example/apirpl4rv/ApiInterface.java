package com.example.apirpl4rv;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("apirpl4")
    Call<List<Hewan>> getListHewan();
}
