package com.example.donwloadtaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText url;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        url = findViewById(R.id.editTextURL);
        url.setText("https://upload.wikimedia.org/wikipedia/en/a/a3/Paladin%27s_Quest_box_art.jpg");
    }

    public void eventHandler(View view) {
        DownloadTask task = new DownloadTask(this, imageView);
        task.execute(url.getText().toString());

    }
}