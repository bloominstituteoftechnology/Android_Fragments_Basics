package com.example.israel.android_fragments_basics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class DetailsDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        PlayerProfile playerProfile = (PlayerProfile)getArguments().getSerializable(MainActivity.KEY_PLAYER_PROFILE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(playerProfile.getName() + "\nLevel " + playerProfile.getLevel());
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(DetailsDialogFragment.this).commit();
            }
        });

        return builder.create();

    }
}
