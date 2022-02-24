package com.example.heroesapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.LinearLayout;


import android.os.Bundle;

import com.example.heroesapp.R;
import com.example.heroesapp.adapter.AdapterHeroes;
import com.example.heroesapp.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHeroes;
    private List<Hero> listHeroes = new ArrayList<>();

    public void createHero() {
        Hero obj = new Hero(R.drawable.flash, "Flash", "DC");
        listHeroes.add(obj);
        obj = new Hero(R.drawable.ironman, "Iron Man", "Marvel");
        listHeroes.add(obj);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHeroes = findViewById(R.id.recyclerViewHeroes);

        //configuração do adapter
        this.createHero();
        AdapterHeroes adapter = new AdapterHeroes(listHeroes);

        //Configurando RecyclerView com layout linear
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHeroes.setLayoutManager(layoutManager);

        //Otimizando recyclerView
        recyclerViewHeroes.setHasFixedSize(true);

        //Liga adapter ao recycler
        recyclerViewHeroes.setAdapter(adapter);



    }
}