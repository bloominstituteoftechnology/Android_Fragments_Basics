package com.example.fragmentproject;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {

    private String[] elementType;
    private Bitmap image;
    private int number;
    private String name;
    private String[] moves;
    ArrayList<String> movesArrList;

    public Pokemon(String[] elementType, Bitmap image, int number, String name, ArrayList<String> movesArrList) {
        this.elementType = elementType;
        this.image = image;
        this.number = number;
        this.name = name;
        this.movesArrList = movesArrList;

        moves = new String[movesArrList.size()];
        for (int i = 0; i < moves.length; i++) {
            moves[i] = movesArrList.get(i);
        }
    }


    public String[] getElementType() {
        return elementType;
    }


    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }
}
