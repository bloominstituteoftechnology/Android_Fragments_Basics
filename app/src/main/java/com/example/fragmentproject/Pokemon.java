package com.example.fragmentproject;

import java.util.ArrayList;

public class Pokemon {

    private String[] elementType;
    private String imageURL;
    private int number;
    private String name;
    private String[] moves;
    ArrayList<String> movesArrList;

    public Pokemon(String[] elementType, String imageURL, int number, String name, ArrayList<String> movesArrList) {
        this.elementType = elementType;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String[] getMoves() {
        return moves;
    }
}
