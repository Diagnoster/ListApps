package com.example.pokemonapiapp.Retrofit;

import com.example.pokemonapiapp.Models.Pokedex;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IPokemonDex {
    @GET("pokedex.json")
    Observable<Pokedex> getListPokemon();

}
