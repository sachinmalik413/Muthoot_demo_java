package com.example.data;

import com.example.data.networkClient.NetworkService;
import com.example.domain.entities.CatResponse;
import com.example.domain.repository.CatResponseInterface;
import com.example.domain.repository.MainRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepositoryImpl implements MainRepository {

    private NetworkService service;
    private CatResponseInterface catResponseInterface;

    @Inject
    public NetworkRepositoryImpl(NetworkService service, CatResponseInterface catResponseInterface) {
        this.service = service;
        this.catResponseInterface = catResponseInterface;
    }

    @Override
    public void fetchApi() {
        service.fetchApi().enqueue(new Callback<CatResponse>() {
            @Override
            public void onResponse(Call<CatResponse> call, Response<CatResponse> response) {
                catResponseInterface.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<CatResponse> call, Throwable t) {

            }
        });
    }
}
