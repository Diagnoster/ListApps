package com.example.conversormoedasapp;

import com.example.conversormoedasapp.Model.Conversor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConversorService {
    @GET("{cep}/json/")
    Call <Conversor> getFullAddress(@Path("cep") String convert);

}
