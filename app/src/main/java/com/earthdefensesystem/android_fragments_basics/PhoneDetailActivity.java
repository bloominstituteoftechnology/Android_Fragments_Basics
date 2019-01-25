package com.earthdefensesystem.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhoneDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);

        final DetailsFragment detailsFragment = DetailsFragment.newInstance((Comic)getIntent().getSerializableExtra("swapi_item"));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_detail, detailsFragment).commit();
    }
}
