package com.trantan.myrecyclerview.model;

import java.util.ArrayList;

public class Story {
    private String mName;
    private ArrayList<Hero> mHeroes;

    public Story() {
        mName = "";
        mHeroes = new ArrayList<>();
    }

    public Story(String name, ArrayList<Hero> heroes) {
        this.mName = name;
        this.mHeroes = heroes;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<Hero> getHeroes() {
        return mHeroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        mHeroes = heroes;
    }
}
