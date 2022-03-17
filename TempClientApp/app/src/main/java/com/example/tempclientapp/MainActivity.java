package com.example.tempclientapp;

import androidx.appcompat.app.AppCompatActivity;

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

    public void Convert(View view) {
        EditText input = findViewById(R.id.editNumberDecimal);
        TextView output = findViewById(R.id.textViewOut);

        Double temp = Double.parseDouble(input.getText().toString());
        RequestTask task = new RequestTask(output);
        task.execute(temp);

    }
}