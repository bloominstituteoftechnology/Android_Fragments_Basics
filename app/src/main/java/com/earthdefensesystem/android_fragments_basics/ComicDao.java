package com.earthdefensesystem.android_fragments_basics;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

public class ComicDao {
    private final static String BASE_URL = "https://xkcd.com/";
    private final static String URL_ENDING = "info.0.json";
    private final static String SPECIFIC_COMIC = BASE_URL + "%d/" + URL_ENDING;

    private static Comic getComic(String url){
        Comic comic = null;
        try {
            JSONObject jsonObject = new JSONObject(NetworkAdapter.httpRequest(url));
            comic = new Comic(jsonObject);
            Bitmap imageBitMap = NetworkAdapter.httpImageRequest(comic.getImg());
            comic.setBitMap(imageBitMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return comic;
    }

    static Comic getComic(int id) {
        Comic comic = null;
        String url = SPECIFIC_COMIC.replace("%d/", Integer.toString(id));
        comic = getComic(url);
        return comic;
    }

}