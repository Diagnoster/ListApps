package com.example.heroesapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.heroesapp.R;
import com.example.heroesapp.adapter.AdapterHeroes;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHeroes = findViewById(R.id.recyclerViewHeroes);

        //configuração do adapter
        AdapterHeroes adapter = new AdapterHeroes();

        //Configurando RecyclerView com layout linear
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHeroes.setLayoutManager(layoutManager);

        //Otimizando recyclerView
        recyclerViewHeroes.setHasFixedSize(true);

        //Liga adapter ao recycler
        recyclerViewHeroes.setAdapter(adapter);



    }
}