package com.example.asynctask1;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    ProgressBar progressBar;
    Context myContext;

    public MyAsyncTask(ProgressBar progressBar, Context context) {
        this.progressBar = progressBar;
        this.myContext = context;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Integer ... integers) {
        for (int i = 0; i < integers[0]; i++) {
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Finalizado.";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(myContext, s, Toast.LENGTH_SHORT).show();
        progressBar.setProgress(0);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer ... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    

}
