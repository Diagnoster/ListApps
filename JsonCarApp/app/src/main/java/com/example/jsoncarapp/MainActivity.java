package com.example.jsoncarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView carInfo = (TextView) findViewById(R.id.carInfo);
        try {
            carInfo.setText(adicaoSimplesDeDados().toString());
            carInfo.setText(carInfo.getText() + "\n" + adicaoDeUmObjeto());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject adicaoSimplesDeDados() throws JSONException {
        Carro carro = new Carro();
        carro.setId(1);
        carro.setModelo("Celta");
        carro.setPlaca("AQN4599");

        JSONObject carroJson = new JSONObject();

        carroJson.put("id", carro.getId());
        carroJson.put("modelo", carro.getModelo());
        carroJson.put("placa", carro.getPlaca());

        return carroJson;
    }

    private String adicaoDeUmObjeto() throws JSONException {
        Carro carro = new Carro();
        carro.setId(2);
        carro.setModelo("Celta");
        carro.setPlaca("AQN4599");

        JSONObject carroJson = new JSONObject();
        carroJson.put("Carro", carro);

        return carroJson.toString();
    }
}