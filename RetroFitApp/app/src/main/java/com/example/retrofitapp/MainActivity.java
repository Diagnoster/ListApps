package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Model.Address;
import apiCEP.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView input = findViewById(R.id.inputCep);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Consultando endereço...");
        progressDialog.show();

        Call<Address> call = new RetrofitConfig().getCEPService().getFullAddress();
        call.enqueue(new Callback<Address>() {
            @Override
            public void onResponse (Call <Address> call, Response <Address> response){
                if (response.isSuccessful()) {
                    Address address = response.body();
                    progressDialog.dismiss();
                    input.setText(address.getLogradouro() + " - " + address.getComplemento()
                            + "\n" + address.getBairro() + "\n" + address.getLocalidade() +
                            "\n" + address.getUf());
                }
            }

            @Override
            public void onFailure(Call<Address> call, Throwable t) {

            }
        });
    }
}