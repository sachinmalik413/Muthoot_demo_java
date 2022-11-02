package com.example.domain.usecases;

import com.example.domain.repository.MainRepository;

import javax.inject.Inject;

public class MainUseCase {

    private MainRepository repository;

    @Inject
    public MainUseCase(MainRepository repository) {
        this.repository = repository;
    }

    public void fetchApi() {
        repository.fetchApi();
    }
}
