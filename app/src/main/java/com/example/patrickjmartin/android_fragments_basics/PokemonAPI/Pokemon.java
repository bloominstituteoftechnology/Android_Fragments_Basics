package com.example.patrickjmartin.android_fragments_basics.PokemonAPI;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {

    private static String BASE_IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/";

    private String name, spriteURL, type;
    private int ID;

    public Pokemon(String name, String spriteURL, String type, int ID) {
        this.name = name;
        this.spriteURL = spriteURL;
        this.type = type;
        this.ID = ID;
    }

    public Pokemon(JSONObject caught){
        JSONObject temp;
        JSONArray tempAry;
        

    }

    public String getName() {
        return name;
    }

    public String getSpriteURL() {
        return spriteURL;
    }

    public String getType() {
        return type;
    }

    public int getID() {
        return ID;
    }
}
