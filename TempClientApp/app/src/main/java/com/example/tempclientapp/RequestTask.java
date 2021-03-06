package com.example.tempclientapp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestTask extends AsyncTask<Double, Void, Double>{
    private TextView output;
    private static final String IP = "10.153.117.150";
    private static final int port = 12345;

    public RequestTask(TextView output) {
        this.output = output;
    }

    @Override
    protected void onPostExecute(Double aDouble){
        super.onPostExecute(aDouble);
        output.setText(String.valueOf(aDouble));
    }

    @Override
    protected Double doInBackground(Double... doubles) {
        Double tempF = 0.0;

        try {
            Socket socket = new Socket(IP, port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeDouble(doubles[0]);
            output.flush();
            tempF = input.readDouble();
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempF;
    }

}
