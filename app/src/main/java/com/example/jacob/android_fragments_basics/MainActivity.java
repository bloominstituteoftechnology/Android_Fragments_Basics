package com.example.jacob.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jacob.android_fragments_basics.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements FlashCardFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlashCardFragment fragment = new FlashCardFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder, fragment).commit();
            }
        });
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
