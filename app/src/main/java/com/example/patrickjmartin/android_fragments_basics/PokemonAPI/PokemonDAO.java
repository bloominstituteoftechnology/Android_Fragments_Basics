package com.example.patrickjmartin.android_fragments_basics.PokemonAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokemonDAO {

    public interface ObjectCallback<T> {
        void returnPokemonObject(T object);
    }

    private static String BASE_POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final String SELECTED_POKEMON_URL = BASE_POKEMON_URL + "%d" + "/";

    private static String BASE_TYPE_URL = "https://pokeapi.co/api/v2/type/";
    private static final String SELECTED_TYPE_URL = BASE_TYPE_URL + "%d" + "/";


    public static void getAllPokemonType(int typeID, final ObjectCallback<ArrayList<Pokemon>> objectCallback) {
        String typeURL = String.format(SELECTED_TYPE_URL, typeID);

        final ArrayList<Pokemon> typesOfPokemon = new ArrayList<>();
        final NetworkAdapter.NetworkCallback callback = (Boolean success, String result) -> {
            try {
                JSONObject pageJSON = new JSONObject(result);
                String type = pageJSON.optString("name");
                JSONArray resultsArray = pageJSON.getJSONArray("pokemon");

                for (int i = 0; i < resultsArray.length(); i++) {
                    String pokeURL = resultsArray.getJSONObject(i).getJSONObject("pokemon").optString("url");

                }

            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                objectCallback.returnPokemonObject(typesOfPokemon);
            }

        };
        NetworkAdapter.httpGetRequest(typeURL, callback);
    }



}
