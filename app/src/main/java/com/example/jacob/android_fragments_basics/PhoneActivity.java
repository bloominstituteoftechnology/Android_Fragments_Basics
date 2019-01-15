package com.example.jacob.android_fragments_basics;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhoneActivity extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        final DetailsFragment detailFragment = DetailsFragment.newInstance((FlashCard) getIntent().getSerializableExtra(MainActivity.SELECTION_KEY));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_details, detailFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}