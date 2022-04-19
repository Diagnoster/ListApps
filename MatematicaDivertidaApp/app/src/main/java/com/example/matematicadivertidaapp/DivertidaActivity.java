package com.example.matematicadivertidaapp;

import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DivertidaActivity extends AppCompatActivity {

    int tries = 0;
    int pontos= 0;
    int numero1;
    int numero2;
    String operador;
    int operando;
    int result =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divertida);
        TextView geraExpressao = findViewById(R.id.expressao);
        numero1 = sortear(0, 9);
        numero2 = sortear(0, 9);
        operando = sortear(1,2);

        //sorteia o operador
        if (operando == 1){
            operador = "+";
            result = numero1 + numero2;
        }else {
            operador = "-";
            result = numero1 - numero2;
        }

        geraExpressao.setText(String.valueOf(numero1) + operador + String.valueOf(numero2));
    }

    public void calculoExpressao(View view){
        String message;
        if(tries < 5){
            EditText resposta = findViewById(R.id.editTextNumberAri);
            String verificaVazio = resposta.getText().toString();
            if (verificaVazio.equals("")){
                Toast.makeText(this, "Insira uma resposta válida", Toast.LENGTH_LONG).show();
            }else{
                int repostaInserida = Integer.parseInt(resposta.getText().toString());
                if(repostaInserida == result){
                    message = "Parabéns, você acertou!";
                    pontos += 20;
                }else{
                    message = "Resposta inserida incorreta. Resposta correta " + result;
                }
                new AlertDialog.Builder(this)
                        .setTitle("Resposta")
                        .setMessage(message)
                        .show();
                tries++;

                TextView expression = findViewById(R.id.expressao);

                numero1 = sortear(0, 9);
                numero2 = sortear(0, 9);
                operando = sortear(1,2);

                if (operando == 1){
                    operador = "+";
                    result = numero1 + numero2;
                }else {
                    operador = "-";
                    result = numero1 - numero2;
                }
                expression.setText(String.valueOf(numero1) + operador + String.valueOf(numero2));
                resposta.setText("");
            }
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Fim de jogo!")
                    .setMessage("A pontuação foi de " + pontos)
                    .show();
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            finish();
        }
    }

    public int sortear(int min, int max) {
        Random r = new Random();
        int result = r.nextInt(max - min + 1) + min;
        return result;
    }

    public void back(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);

    }


}
