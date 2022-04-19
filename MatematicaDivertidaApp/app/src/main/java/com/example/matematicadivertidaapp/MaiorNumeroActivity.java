package com.example.matematicadivertidaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MaiorNumeroActivity extends AppCompatActivity {

    public TextView txtDigit1;
    public TextView txtDigit2;
    public TextView txtDigit3;
    public TextView txtAnswer;
    public EditText inputAnswer;
    public Button btnAnswer;
    public List<Integer> digits;
    public int answer;
    public int result;
    public double wins = 0;
    public double losses = 0;
    public double runs = 0;
    public double finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior_numero);


    }

    public void startGame() {
        if (runs == 5) {
            finalScore = (wins / runs) * 100;
            int finalScoreInt = (int) finalScore;
            final AlertDialog alertDialog = new AlertDialog.Builder(MaiorNumeroActivity.this).create();
            alertDialog.setTitle("Fim de jogo");
            alertDialog.setMessage("Nota final " + finalScoreInt + "!");

            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        } else {
            newGame();
        }
    }

    public void newGame() {
        runs++;
        inputAnswer.setText("");
        digits = new ArrayList<Integer>();
        int drawResult;
        for (int i = 0; i < 3; i++) {
            drawResult = draw(0, 9);
            digits.add(drawResult);
        }
        txtDigit1.setText(String.valueOf(digits.get(0)));
        txtDigit2.setText(String.valueOf(digits.get(1)));
        txtDigit3.setText(String.valueOf(digits.get(2)));
        Collections.sort(digits, Collections.reverseOrder());
        String resultString = String.valueOf(digits.get(0)) + String.valueOf(digits.get(1)) + String.valueOf(digits.get(2));
        result = Integer.valueOf(resultString);
        txtAnswer.setText(String.valueOf(result));
    }


    public int draw(int min, int max) {
        Random r = new Random();
        int result = r.nextInt(max - min + 1) + min;
        return result;
    }

    public void checkAnswer(View view) {
        answer = Integer.parseInt(inputAnswer.getText().toString());
        final AlertDialog alertDialog = new AlertDialog.Builder(MaiorNumeroActivity.this).create();
        alertDialog.setTitle("Resultado");
        if (answer == result) {
            wins++;
            alertDialog.setMessage("Resposta certa!");

        } else {
            losses++;
            alertDialog.setMessage("Resposta errada! A resposta correta era " + result);

        }
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startGame();
                    }
                });
        alertDialog.show();
    }

    public void back(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);

    }

}