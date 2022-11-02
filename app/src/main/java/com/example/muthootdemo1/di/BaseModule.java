package com.example.muthootdemo1.di;

import com.example.data.NetworkRepositoryImpl;
import com.example.data.networkClient.NetworkService;
import com.example.domain.repository.CatResponseInterface;
import com.example.domain.repository.MainRepository;
import com.example.domain.usecases.CatResponseUseCase;
import com.example.domain.usecases.MainUseCase;

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
    MainRepository provideMainRepository(NetworkService service, CatResponseInterface catResponseInterface) {
        return new NetworkRepositoryImpl(service, catResponseInterface);
    }

    @Provides
    @Singleton
    MainUseCase provideUseCase(MainRepository repository) {
        return new MainUseCase(repository);
    }

    @Provides
    @Singleton
    CatResponseUseCase provideCatUseCase() {
        return new CatResponseUseCase();
    }
}
