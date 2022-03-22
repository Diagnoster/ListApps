package com.example.httpreqapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyTask extends AsyncTask<String, Void, String> {

    TextView output;

    public MyTask(TextView output) {
        this.output = output;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String stringURL = strings[0];
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer buffer = null;

        try {
            URL url = new URL(stringURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Recuperando dados em bytes
            inputStream = connection.getInputStream();
            //Converte String
            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            buffer  = new StringBuffer();
            String line = "";
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        output.setText(s);
    }



}
