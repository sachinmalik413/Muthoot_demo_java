package com.example.data.di;

import com.example.data.NetworkHelper;
import com.example.data.networkClient.NetworkService;
import com.example.domain.repository.CatResponseInterface;
import com.example.domain.usecases.CatResponseUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class BaseModule {

    @Provides
    @Singleton
    NetworkService provideNetworkService() {
        return new NetworkHelper().getRetrofitObject();
    }


    @Provides
    @Singleton
    CatResponseInterface provideCatResponse() {
        return new CatResponseUseCase();
    }
}