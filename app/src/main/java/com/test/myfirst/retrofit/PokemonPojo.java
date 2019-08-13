package com.test.myfirst.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonPojo {
    @SerializedName("Pokemon")
    @Expose
    private List<Pokemon> pokemon = null;

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
