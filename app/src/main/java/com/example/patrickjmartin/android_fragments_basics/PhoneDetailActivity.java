package com.example.patrickjmartin.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.patrickjmartin.android_fragments_basics.PokemonAPI.Pokemon;

public class PhoneDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);

        final DetailsFragment detailsFragment = DetailsFragment.
                newInstance((Pokemon)getIntent().getSerializableExtra("pokemon"));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .commit();

    }
}
