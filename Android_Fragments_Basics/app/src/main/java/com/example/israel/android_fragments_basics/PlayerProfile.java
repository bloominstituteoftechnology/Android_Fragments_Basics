package com.example.israel.android_fragments_basics;

import java.io.Serializable;

public class PlayerProfile implements Serializable {

    public PlayerProfile(String name, int level) {
        this.name = name;
        this.level = level;
    }

    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
