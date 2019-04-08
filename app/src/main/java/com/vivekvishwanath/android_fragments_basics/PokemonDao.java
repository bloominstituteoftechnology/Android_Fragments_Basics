package com.vivekvishwanath.android_fragments_basics;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

public class PokemonDao {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public static JSONObject getPokemon(String nameOrId) {
        JSONObject pokemonJSON = null;
        String pokemonUrl = BASE_URL + nameOrId;
        String result = NetworkAdapter.httpGETRequest(pokemonUrl);

        try {
            pokemonJSON = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return pokemonJSON;
    }

    public static Bitmap getPokemonSprite(String spriteUrl) {
        Bitmap sprite = NetworkAdapter.getBitmapFromUrl(spriteUrl);
        return sprite;
    }
}
