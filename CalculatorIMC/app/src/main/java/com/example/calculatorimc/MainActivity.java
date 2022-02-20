package com.example.calculatorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText inputHeight = findViewById(R.id.editTextHeight);
        EditText inputWeight = findViewById(R.id.editTextWeight);
        double height = Double.parseDouble(inputHeight.getText().toString());
        double weight = Double.parseDouble(inputWeight.getText().toString());
        double imc = weight / (height * height);
        String result = Double.toString(imc);

        Intent it = new Intent(this, Tela2.class);
        Bundle params = new Bundle(); // vai carregar os dados para a outra activity
        params.putString("key_imc", result);

        it.putExtras(params); // para intent carregar os parametros
        startActivity(it);
    }
}