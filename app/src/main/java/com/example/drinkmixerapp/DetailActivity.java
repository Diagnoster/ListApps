package com.example.drinkmixerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int drinkId = 3;
        Intent it = getIntent();

        String[] drinks = new String[]{"Batida de Sonho de Valsa", "Drink dos Deuses", "Quentão"};

        String[] ingredients = new String[] {"3 bombons Sonho de valsa \n" +
                "1 lata de Leite Condensado \n" +
                "1/2 garrafa de Pinga \n" +
                "1 latinha de Guaraná"};
        TextView drinkName = findViewById(R.id.textViewDrinkName);
        TextView ingBox = findViewById(R.id.textViewIngredients);
        TextView prepBox = findViewById(R.id.textViewPreparo);

        if(it != null)
            drinkId = it.getIntExtra("drinkId", 3);
        if (drinkId == 3) {
            drinkName.setText("");
            ingBox.setText("");
            prepBox.setText("");

            Toast.makeText( this, "Drink não encontrado", Toast.LENGTH_SHORT).show();
        } else {
            drinkName.setText(drinks[drinkId]);
            ingBox.setText(ingredients[drinkId]);
            prepBox.setText(preparation[drinkId]);
        }



    }
}