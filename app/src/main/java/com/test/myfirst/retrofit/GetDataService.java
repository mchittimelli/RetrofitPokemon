package com.test.myfirst.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("Vy2abloQD")
    Call<List<Pokemon>> getPokemons();

}
