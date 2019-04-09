package com.lambdaschool.android_fragments_basics;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new ItemFragment()).commit();
    }

    @Override
    public void onItemListFragmentInteraction(Item item) {
        Log.i(TAG, "List Fragment Interacted");

        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", item);
        detailsFragment.setArguments(bundle);

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,detailsFragment).addToBackStack(null).commit();
        if (getResources().getBoolean(R.bool.is_tablet)) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_details, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}
