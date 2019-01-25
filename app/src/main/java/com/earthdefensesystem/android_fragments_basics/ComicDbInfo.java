package com.earthdefensesystem.android_fragments_basics;

public class ComicDbInfo {
    private long timestamp;
    private int favorite, comicId;


    public ComicDbInfo(long timestamp, int favorite, int comicId) {
        this.timestamp = timestamp;
        this.favorite = favorite;
        this.comicId = comicId;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }
}

