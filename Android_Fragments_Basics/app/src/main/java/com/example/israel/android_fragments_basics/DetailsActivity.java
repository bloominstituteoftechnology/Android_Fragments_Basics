package com.example.israel.android_fragments_basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        PlayerProfile playerProfile = (PlayerProfile)intent.getSerializableExtra(MainActivity.KEY_PLAYER_PROFILE);

        TextView nameTextView = findViewById(R.id.text_view_player_name);
        nameTextView.setText(playerProfile.getName());

        TextView levelTextView = findViewById(R.id.text_view_player_level);
        levelTextView.setText(Integer.toString(playerProfile.getLevel()));
    }
}
