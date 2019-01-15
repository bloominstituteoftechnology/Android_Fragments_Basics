package com.example.jacob.android_fragments_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.jacob.android_fragments_basics.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements FlashCardFragment.OnListFragmentInteractionListener {

    public static final String MULTIPLIER_KEY = "multiplier";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(MULTIPLIER_KEY, Integer.parseInt(((EditText) findViewById(R.id.edit_multiplier)).getText().toString()));
                FlashCardFragment fragment = new FlashCardFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder, fragment).commit();
            }
        });

    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
