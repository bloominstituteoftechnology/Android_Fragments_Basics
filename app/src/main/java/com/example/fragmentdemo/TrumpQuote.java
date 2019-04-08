package com.example.fragmentdemo;

import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrumpQuote implements Serializable {
    private String quote;
    private String url;

    public String getQuote() {
        return quote;
    }



    public String getUrl() {
        return url;
    }

}
