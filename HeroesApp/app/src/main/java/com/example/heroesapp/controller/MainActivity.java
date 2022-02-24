package com.example.heroesapp.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;


import android.os.Bundle;
import android.widget.Toast;

import com.example.heroesapp.R;
import com.example.heroesapp.RecyclerItemClickListener;
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

        //Configura RecyclerView com layout linear
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewHeroes.setLayoutManager(layoutManager);

        //Otimizador recyclerView
        recyclerViewHeroes.setHasFixedSize(true);

        //Divisor celulas
        recyclerViewHeroes.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Liga adapter ao recycler
        recyclerViewHeroes.setAdapter(adapter);

        recyclerViewHeroes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewHeroes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Hero obj = listHeroes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Selecionado " + obj.getName(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }
}