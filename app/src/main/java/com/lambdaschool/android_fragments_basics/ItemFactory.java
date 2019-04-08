package com.lambdaschool.android_fragments_basics;

import java.util.ArrayList;

public class ItemFactory {

    public static ArrayList<Item> getItems() {
        ArrayList<Item> itemArrayList = new ArrayList<>();

        for (int i = 0; i < ItemConstants.ICON_IDS.length; i++) {
            itemArrayList.add(new Item(i, ItemConstants.ICON_IDS[i], ItemConstants.ITEM_NAMES_RAW[i].replaceAll("_", " ")));
        }

        return itemArrayList;
    }
}
