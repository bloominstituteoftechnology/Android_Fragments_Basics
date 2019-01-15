package com.example.jacob.android_fragments_basics;

import java.util.ArrayList;

public class FlashCardsDao {
private static final int reps = 102;

    static ArrayList<FlashCard> generateFlashCards(int multiplier) {
        ArrayList<FlashCard> cards = new ArrayList<>();
        for(int i=0;i<reps;++i) {
            cards.add(new FlashCard(multiplier,i));
        }
        return cards;
    }

}
