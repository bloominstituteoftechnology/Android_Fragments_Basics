package com.lambdaschool.android_fragments_basics;

import java.io.Serializable;

public class Item implements Serializable {
    private int itemId;
    private int itemResource;
    private String itemName;

    public Item(int itemId, int itemResource, String itemName) {
        this.itemId = itemId;
        this.itemResource = itemResource;
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemResource() {
        return itemResource;
    }

    public void setItemResource(int itemResource) {
        this.itemResource = itemResource;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
