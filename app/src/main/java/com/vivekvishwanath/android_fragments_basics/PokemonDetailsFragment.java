package com.vivekvishwanath.android_fragments_basics;


import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonDetailsFragment extends Fragment {

    private ImageView pokemonSprite;

    public PokemonDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final Pokemon pokemon = (Pokemon) getArguments().getSerializable("pokemon_key");

        pokemonSprite = view.findViewById(R.id.pokemon_detail_image);
        final TextView pokemonName = view.findViewById(R.id.pokemon_detail_name);
        final TextView pokemonId = view.findViewById(R.id.pokemon_detail_id);

        new Thread(new Runnable() {
            @Override
            public void run() {
                new DownloadImageTask().execute(pokemon.getSpriteUrl());

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pokemonName.setText(pokemon.getName());
                        pokemonId.setText(Integer.toString(pokemon.getId()));
                    }
                });
            }
    }).start();
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = PokemonDao.getPokemonSprite(strings[0]);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            pokemonSprite.setImageBitmap(bitmap);
        }
    }
}
