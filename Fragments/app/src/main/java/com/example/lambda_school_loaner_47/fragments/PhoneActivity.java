package com.example.lambda_school_loaner_47.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhoneActivity extends AppCompatActivity implements DetailsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        DetailsFragment fragment = DetailsFragment.newInstance((Person) getIntent().getSerializableExtra(MainActivity.PERSON_ITEM));
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
