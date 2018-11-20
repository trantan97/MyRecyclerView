package com.trantan.myrecyclerview.model;

import java.io.Serializable;

public class Hero implements Serializable {
    private String mName;
    private int mImageUrl;

    public Hero(String name, int imageUrl) {
        this.mName = name;
        this.mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(int imageUrl) {
        mImageUrl = imageUrl;
    }
}
