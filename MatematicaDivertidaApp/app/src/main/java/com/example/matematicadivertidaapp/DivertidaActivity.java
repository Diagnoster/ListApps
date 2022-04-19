package com.example.matematicadivertidaapp;

import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DivertidaActivity extends AppCompatActivity {

    public RadioGroup answer;
    public RadioButton answerSelected;
    public TextView txtDrawnNumber;
    public int drawnNumber;
    public int rightAnswerPosition;
    public double wins = 0;
    public double losses = 0;
    public double runs = 0;
    public double finalScore = 0;
    TableLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divertida);

        startGame();
    }

    public void startGame() {
        if (runs == 5) {
            finalScore = (wins/runs)*100;
            int finalScoreInt = (int)finalScore;
            final AlertDialog alertDialog = new AlertDialog.Builder(DivertidaActivity.this).create();
            alertDialog.setTitle("Fim de jogo");
            alertDialog.setMessage("Sua nota foi " + finalScoreInt + "!");

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
        // aumenta o contador de perguntas (jogadas)
        runs++;

        // mapeia os componentes da tela
        answer = findViewById(R.id.radioGroupAnswer);
        RadioButton radioA = findViewById(R.id.radioAnswer1);
        RadioButton radioB = findViewById(R.id.radioAnswer2);
        RadioButton radioC = findViewById(R.id.radioAnswer3);
        txtDrawnNumber = findViewById(R.id.txtDrawnNumber);
        layout = (TableLayout) findViewById(R.id.tablelayout);

        layout.removeAllViews();
        answer.clearCheck();

        TextView numero1 = findViewById(R.id.number1);
        TextView operador = findViewById(R.id.operador);
        TextView numero2 = findViewById(R.id.number2);

        drawnNumber = sortear(1, 10);
        numero1.setText(String.valueOf(drawnNumber));
        if (drawnNumber < 5) {
            operador.setText(String.valueOf("+"));
        } else {
            operador.setText(String.valueOf("-"));
        }
        numero2.setText(String.valueOf(drawnNumber));


        txtDrawnNumber.setText(String.valueOf(drawnNumber));

        layout.setStretchAllColumns(true);
        layout.bringToFront();
        TableRow tr =  new TableRow(this);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(30, 30);
        for(int i = 0; i < drawnNumber; i++){
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.img);;

            iv.setLayoutParams(layoutParams);
            tr.addView(iv);
        }
        layout.addView(tr);

        int aValue, bValue, cValue;
        rightAnswerPosition = sortear(1, 3);
        switch(rightAnswerPosition) {
            case 1:
                radioA.setText(String.valueOf(drawnNumber));
                bValue = sortear(1, 10);
                while (bValue == drawnNumber) {
                    bValue = sortear(1, 10);
                }
                radioB.setText(String.valueOf(bValue));

                cValue = sortear(1, 10);
                while (cValue == drawnNumber || cValue == bValue) {
                    cValue = sortear(1, 10);
                }
                radioC.setText(String.valueOf(cValue));
                break;
            case 2:
                radioB.setText(String.valueOf(drawnNumber));
                aValue = sortear(1, 10);
                while (aValue == drawnNumber) {
                    aValue = sortear(1, 10);
                }
                radioA.setText(String.valueOf(aValue));

                cValue = sortear(1, 10);
                while (cValue == drawnNumber || cValue == aValue) {
                    cValue = sortear(1, 10);
                }
                radioC.setText(String.valueOf(cValue));
                break;
            case 3:
                radioC.setText(String.valueOf(drawnNumber));
                aValue = sortear(1, 10);
                while (aValue == drawnNumber) {
                    aValue = sortear(1, 10);
                }
                radioA.setText(String.valueOf(aValue));

                bValue = sortear(1, 10);
                while (bValue == drawnNumber || bValue == aValue) {
                    bValue = sortear(1, 10);
                }
                radioB.setText(String.valueOf(bValue));
                break;
        }
    }

    public void checkAnswer(View view) {
        answerSelected = findViewById(answer.getCheckedRadioButtonId());
        final AlertDialog alertDialog = new AlertDialog.Builder(DivertidaActivity.this).create();
        alertDialog.setTitle("Resultado");
        if (answerSelected.getText().equals(String.valueOf(drawnNumber))) {
            wins++;
            alertDialog.setMessage("Resposta certa!");

        } else {
            losses++;
            alertDialog.setMessage("Resposta errada! A resposta correta era " + drawnNumber);

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
