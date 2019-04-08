package com.example.android_fragments_basics;

import java.io.Serializable;

public class RandomItem implements Serializable {
    String randomString;
    int randomInt;

    public RandomItem(String randomString, int randomInt) {
        this.randomString = randomString;
        this.randomInt = randomInt;
    }

    public RandomItem(String randomString) {
        this.randomString = randomString;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }
}
