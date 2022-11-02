package com.example.domain.usecases;

import androidx.lifecycle.MutableLiveData;

import com.example.domain.entities.CatResponse;
import com.example.domain.repository.CatResponseInterface;

public class CatResponseUseCase implements CatResponseInterface {

    private final MutableLiveData<String> newData = new MutableLiveData<>();

    @Override
    public void onResponse(CatResponse response) {
        newData.setValue(response.getFact());
    }

    public MutableLiveData<String> getData() {
        return newData;
    }
}
