package com.jakeesveld.android_fragments_basics;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AppListingFragment.OnListFragmentInteractionListener{

    public static final String APP_KEY = "App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new AppListingFragment()).commit();

    }

    @Override
    public void onListFragmentInteraction(AppListing item) {
        AppItemFragment fragment = new AppItemFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(APP_KEY, item);
        fragment.setArguments(bundle);

        if(getResources().getBoolean(R.bool.is_tablet)){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_details, fragment).addToBackStack(null).commit();
        }else{
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).addToBackStack(null).commit();
        }
    }
}
