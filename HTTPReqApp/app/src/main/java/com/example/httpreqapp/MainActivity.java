package com.example.httpreqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    public void getData(View view) {
        String moeda = "USD";
        String value = "500";
        String urlBlockChain = "https://blockchain.info/tobtc?currency=" + moeda + "&value=" + value;
        MyTask task = new MyTask(output);
        task.execute(urlBlockChain);
    }


}