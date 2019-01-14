package com.example.patrickjmartin.android_fragments_basics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDAO {

    public interface ObjectCallback<T> {
        void returnPokemon(T object);
    }

    private static String BASE_URL = "https://pokeapi.co/api/v2/type/";

    private static final String SELECTED_TYPE_URL = BASE_URL + "%d" + "/";

    public static Pokemon getAllPokemon(int typeID, final ObjectCallback<ArrayList<Pokemon>> objectCallback) {
        String pokeURL = String.format(SELECTED_TYPE_URL, typeID);

        final ArrayList<Pokemon> typesOfPokemon = new ArrayList<>();
        final NetworkAdapter.NetworkCallback callback = (success, result) -> {
            try {
                JSONObject pageJSON = new JSONObject(result);
                JSONArray resultsArray = pageJSON.getJSONArray("pokemon");

                for (int i = 0; i < resultsArray.length(); i++) {

                }

            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                objectCallback.returnPokemon(typesOfPokemon);
            }

        };
        NetworkAdapter.httpGetRequest(pokeURL, callback);
    }



}
