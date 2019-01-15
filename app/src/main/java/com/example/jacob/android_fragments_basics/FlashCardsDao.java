package com.example.jacob.android_fragments_basics;

import java.util.ArrayList;

public class FlashCardsDao {

    static ArrayList<FlashCard> generateFlashCards(int multiplier) {
        ArrayList<FlashCard> cards = new ArrayList<>();
        for(int i=0;i<=25;++i) {
            cards.add(new FlashCard(multiplier,i));
        }
        return cards;
    }

}
