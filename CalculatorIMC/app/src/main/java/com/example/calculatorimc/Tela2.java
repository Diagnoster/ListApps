package com.example.calculatorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        TextView out = findViewById(R.id.textViewImc);
        TextView res = findViewById(R.id.textViewResult);

        Intent it = getIntent();

        if (it != null) {
            Bundle params = it.getExtras();

            if (params != null) {
                String result = params.getString("key_imc");
                res.setText("IMC: " + result);
                double imc = Double.parseDouble(result);

               if(imc < 15) {
                   out.setText("Extremamente abaixo do peso");
               } else if (imc >= 15 && imc < 16) {
                   out.setText("Gravemente abaixo do peso");
                } else if (imc >= 16 && imc < 18.5) {
                   out.setText("Abaixo do peso ideal");
               } else if (imc >= 18.5 && imc < 25) {
                   out.setText("Faixa de peso ideal");
               } else if (imc >= 25 && imc < 30) {
                   out.setText("Sobrepeso");
               } else if (imc >= 30 && imc < 35) {
                   out.setText("Obesidade grau I");
               } else if (imc >= 35 && imc < 40) {
                   out.setText("Obesidade grau II (grave)");
               } else if ( imc > 40) {
                   out.setText("Obesidade grau III (mórbida)");
               }
            }

        }
    }


}