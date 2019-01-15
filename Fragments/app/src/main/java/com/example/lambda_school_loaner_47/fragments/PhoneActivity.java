package com.example.lambda_school_loaner_47.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        Bundle args = new Bundle();
       // args.putSerializable(MainActivity.PERSON_ITEM, item);

        /*DetailsFragment fragment = DetailsFragment.newInstance();
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();*/
    }
}
