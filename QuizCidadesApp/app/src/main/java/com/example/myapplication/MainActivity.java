package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check(){
        Random r = new Random();
        int num = r.nextInt(6);
        TextView out = findViewById(R.id.output);
        EditText input = findViewById(R.id.input);

        if (input.length() == 0) {
            Toast msg = Toast.makeText(this, "Insira um valor", Toast.LENGTH_SHORT);
            msg.show();
        } else if(input == "") {
            Toast msg = Toast.makeText(this, "Clique no botão próxima para sortear um Estado", Toast.LENGTH_SHORT);
            msg.show();
        } else if (tries <= 4){
        }
    }

}