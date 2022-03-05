package com.example.asynctask1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    ProgressBar progressBar;
    Context myContext;

    public MyAsyncTask(ProgressBar progressBar, Context context) {
        this.progressBar = progressBar;
        this.myContext = context;
    }

    

}
