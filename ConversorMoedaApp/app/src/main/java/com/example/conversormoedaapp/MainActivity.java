package com.example.conversormoedaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view) {
        RadioButton deReal = findViewById(R.id.radioButtonDeReal);
        RadioButton deDolar = findViewById(R.id.radioButtondeDolar);
        RadioButton deEuro = findViewById(R.id.radioButtonDeEuro);
        RadioButton paraReal = findViewById(R.id.radioButtonParaReal);
        RadioButton paraDolar = findViewById(R.id.radioButtonParaDolar);
        RadioButton paraEuro = findViewById(R.id.radioButtonParaEuro);
        EditText input = findViewById(R.id.editTextInput);
        TextView output = findViewById(R.id.textViewOutput);

        double inputMoney = Double.parseDouble(input.getText().toString());
        double outputMoney = 0;

        if(input.length() == 0) {
            Toast.makeText(this, "Digite um valor", Toast.LENGTH_SHORT).show();
        } else {
            if (deReal.isChecked() && paraDolar.isChecked()) {
                outputMoney = inputMoney * 5.50;
                output.setText(String.valueOf(outputMoney));
            } else if (deReal.isChecked() && paraEuro.isChecked()) {
                outputMoney = inputMoney * 6.20;
            } else if (deReal.isChecked() && paraReal.isChecked()) {
                outputMoney = inputMoney;
            }
            output.setText(String.valueOf(outputMoney));

            if (deDolar.isChecked() && paraReal.isChecked()) {
                outputMoney = inputMoney * 5.50;
            } else if (deDolar.isChecked() && paraEuro.isChecked()) {
                outputMoney = inputMoney * 0.88;
            } else if(deDolar.isChecked() && paraDolar.isChecked()) {
                outputMoney = inputMoney;
            }
            output.setText(String.valueOf(outputMoney));
            if (deEuro.isChecked() && paraReal.isChecked()) {
                outputMoney = inputMoney * 6.20;
            } else if (deEuro.isChecked() && paraDolar.isChecked()) {
                outputMoney = inputMoney / 0.88;
            } else if (deEuro.isChecked() && paraEuro.isChecked()) {
                outputMoney = inputMoney;
            }
            output.setText(String.valueOf(outputMoney));
        }

    }
}