package com.example.patrickjmartin.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.patrickjmartin.android_fragments_basics.PokemonAPI.Pokemon;

public class MainActivity extends AppCompatActivity implements PokemonFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PokemonFragment fragment = new PokemonFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();

    }

    @Override
    public void onListFragmentInteraction(Pokemon item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("pokemon", item);


    }


}
