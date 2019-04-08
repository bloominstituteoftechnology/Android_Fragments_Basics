package com.example.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements RandomItemFragment.OnListFragmentInteractionListener {
 RandomItem randomItem;
    public static ArrayList<RandomItem> randomList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomList = new ArrayList<>(100);
        for(int i = 0; i<99;i++){
            randomItem = new RandomItem(String.valueOf(i));
            randomItem.setRandomInt(i);
            randomList.add(randomItem);

        }

    }
    @Override
    public void onListFragmentInteraction(RandomItem item) {
        DetailsFragment detailsFragment = new DetailsFragment();
    }
}
