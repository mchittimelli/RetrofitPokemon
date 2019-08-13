package com.test.myfirst.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
PokemonRecycleAdapter adapter;
ArrayList pokeArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service= RetrofitClientInstance .getRetrofitInstance().create(GetDataService.class);

       Call<PokemonPojo> call= service.getPokemonObj();

      call.enqueue(new Callback<PokemonPojo>() {
          @Override
          public void onResponse(Call<PokemonPojo> call, Response<PokemonPojo> response) {
              PokemonPojo pokemonPojo=response.body();
              pokeArray=new ArrayList<>(pokemonPojo.getPokemon());
              generateData(pokeArray);
          }

          @Override
          public void onFailure(Call<PokemonPojo> call, Throwable t) {
              Toast.makeText(getApplicationContext(),"Try it later..!",Toast.LENGTH_LONG).show();
          }
      });

       /* Call<List<Pokemon>> call= service.getPokemons();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
            generateData(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Try it later..!",Toast.LENGTH_LONG).show();
            }
        });*/

    }

    public void generateData(ArrayList<Pokemon> pokemonsList){

     /*   ArrayList<Pokemon> pokes=(ArrayList<Pokemon>) pokemonsList;*/
        adapter=new PokemonRecycleAdapter(pokemonsList,getApplicationContext());
        @SuppressLint("WrongConstant") LinearLayoutManager linearLayout=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView=findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);


    }
}
