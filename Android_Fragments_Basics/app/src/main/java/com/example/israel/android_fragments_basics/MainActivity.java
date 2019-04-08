package com.example.israel.android_fragments_basics;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements
        PlayerProfileFragment.OnListFragmentInteractionListener,
        DetailsFragment.OnFragmentInteractionListener {

    public static final String KEY_PLAYER_PROFILE = "player_profile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**@NOTE the challenge uses hard coded fragment, which makes passing a bundle impossible
         * that means that the items cannot be passed to the list fragment on initialization*/

        ArrayList<PlayerProfile> playerProfiles = new ArrayList<>();
        playerProfiles.add(new PlayerProfile("Player0", 99));
        playerProfiles.add(new PlayerProfile("Player1", 90));
        PlayerProfileFragment fragment = PlayerProfileFragment.newInstance(1, playerProfiles);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_fragment_player_profile_list_slot, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onListFragmentInteraction(PlayerProfile item) {
        if (getResources().getBoolean(R.bool.is_tablet)) {
            DetailsFragment detailsFragment = DetailsFragment.newInstance("ExampleArg1", "ExampleArg2", item);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.linear_layout_player_profile_details, detailsFragment);
            fragmentTransaction.commit();
        } else {
//            Intent intent = new Intent(this, DetailsActivity.class);
//            intent.putExtra(KEY_PLAYER_PROFILE, item);
//            startActivity(intent);

            DetailsDialogFragment detailsDialogFragment = new DetailsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(KEY_PLAYER_PROFILE, item);
            detailsDialogFragment.setArguments(bundle);
            detailsDialogFragment.show(getSupportFragmentManager(), "details");
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
