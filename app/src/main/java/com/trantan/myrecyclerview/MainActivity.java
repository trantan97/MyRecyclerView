package com.trantan.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.trantan.myrecyclerview.adapter.ParentsAdapter;
import com.trantan.myrecyclerview.model.Hero;
import com.trantan.myrecyclerview.model.Story;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView mParentRecycler;
    private ArrayList<Story> mStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUi();
    }

    private void setUpUi() {
        mParentRecycler = findViewById(R.id.recycler_parent);
        mStories = getStories();
        ParentsAdapter adapter = new ParentsAdapter(mStories, this);
        mParentRecycler.setAdapter(adapter);
    }

    private ArrayList<Story> getStories() {
        ArrayList<Story> stories = new ArrayList<>();
        String nameHeros[] = getResources().getStringArray(R.array.name_heroes);
        String nameStorys[] = getResources().getStringArray(R.array.name_storys);
        Field[] idField = R.raw.class.getFields();
        for (int i = 0; i < idField.length; i++) {
            Story story = new Story();
            story.setName(nameStorys[i]);
            for (int j = 0; j < 10; j++) {
                try {
                    story.getHeroes()
                            .add(new Hero(nameHeros[i], idField[i].getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            stories.add(story);
        }
        return stories;
    }

    @Override
    public void onClick(Hero hero) {
        startActivity(DescripstionActivity.getProfileIntent(this, hero));
    }
}
