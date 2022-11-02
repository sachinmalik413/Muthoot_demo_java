package com.example.muthootdemo1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.domain.usecases.CatResponseUseCase;
import com.example.domain.usecases.MainUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final MainUseCase useCase;
    private final CatResponseUseCase useCase1;

    public MutableLiveData<String> newData = new MutableLiveData<>("");

    @Inject
    MainViewModel(MainUseCase useCase, CatResponseUseCase useCase1) {
        this.useCase = useCase;
        this.useCase1 = useCase1;
    }

    public void init() {
        if (newData != null) {
            return;
        }
        newData = useCase1.getData();
    }

    public void fetchApi() {
        useCase.fetchApi();
    }

    public LiveData<String> getData() {
        return newData;
    }
}
