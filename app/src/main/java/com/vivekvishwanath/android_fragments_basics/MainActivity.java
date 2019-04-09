 package com.vivekvishwanath.android_fragments_basics;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity implements PokemonListFragment.OnPokemonListFragmentInteractionListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new PokemonListFragment()).commit();
    }

    @Override
    public void OnPokemonListFragmentInteractionListener(Pokemon pokemon) {
        PokemonDetailsFragment pokemonDetailsFragment = new PokemonDetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("pokemon_key", pokemon);
        pokemonDetailsFragment.setArguments(bundle);

        if (getResources().getBoolean(R.bool.is_tablet)){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_details, pokemonDetailsFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            findViewById(R.id.main_layout).setBackgroundColor(getResources().getColor(android.R.color.white));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, pokemonDetailsFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

}
