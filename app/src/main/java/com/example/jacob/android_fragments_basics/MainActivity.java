package com.example.jacob.android_fragments_basics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements FlashCardFragment.OnListFragmentInteractionListener, DetailsFragment.OnFragmentInteractionListener {

    public static final String MULTIPLIER_KEY = "multiplier";
    public static final String SELECTION_KEY = "selection_key";
    Activity activity;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        context = this;

        findViewById(R.id.button_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(activity);
                for (Fragment f : getSupportFragmentManager().getFragments()) {
                    getSupportFragmentManager().beginTransaction().remove(f).commit();
                }
                Bundle bundle = new Bundle();
                bundle.putInt(MULTIPLIER_KEY, Integer.parseInt(((EditText) findViewById(R.id.edit_multiplier)).getText().toString()));
                FlashCardFragment fragment = new FlashCardFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_holder_list, fragment).commit();
            }
        });

    }


    @Override
    public void onListFragmentInteraction(FlashCard item) {
        if (getResources().getBoolean(R.bool.is_tablet)) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(SELECTION_KEY, item);
            DetailsFragment fragment = new DetailsFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_details, fragment).commit();
        } else {
            Intent intent = new Intent(context, PhoneActivity.class);
            intent.putExtra(SELECTION_KEY, item);
            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
