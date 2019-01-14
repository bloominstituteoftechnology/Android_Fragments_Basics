package com.example.jacob.android_fragments_basics;

import java.io.Serializable;

public class FlashCard implements Serializable {
    private int multiplicand;
    private int multiplier;
    private int time;
    private boolean userAnswerCorrect;

    public FlashCard(int multiplicand, int multiplier) {
        this.multiplicand = multiplicand;
        this.multiplier = multiplier;
        this.time = 0;
        userAnswerCorrect = true;

    }

    public int getMultiplicand() {
        return multiplicand;
    }

    public void setMultiplicand(int multiplicand) {
        this.multiplicand = multiplicand;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isUserAnswerCorrect() {
        return userAnswerCorrect;
    }

    public void setUserAnswerCorrect(boolean userAnswerCorrect) {
        this.userAnswerCorrect = userAnswerCorrect;
    }
}
