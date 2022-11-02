package com.example.data.networkClient;

import com.example.domain.entities.CatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("fact")
    Call<CatResponse> fetchApi();
}
