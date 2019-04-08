package com.example.fragmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PokemonFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 200; i++){
                    PokemonDao.addPokemonToRepo(PokemonDao.getPokemon(i));
                }
            }
        }).start();

    }


    @Override
    public void onListFragmentInteraction(Pokemon pokemon) {

    }
}
