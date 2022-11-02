package com.example.muthootdemo1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.muthootdemo1.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.init();
        initListener();
        initObserver();
    }

    private void initListener() {
        button.setOnClickListener(view -> viewModel.fetchApi());
    }

    private void initObserver() {
        viewModel.getData().observe(this, s -> {
            Log.e("TAG", "onResponse: " + s);
            if (!s.isEmpty()) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}