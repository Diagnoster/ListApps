package com.example.conversormoedasapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;


    public RetrofitConfig() {
        //url web service
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://economia.awesomeapi.com.br/json")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
