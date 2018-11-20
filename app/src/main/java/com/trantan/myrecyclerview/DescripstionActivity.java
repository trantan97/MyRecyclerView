package com.trantan.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trantan.myrecyclerview.model.Hero;

public class DescripstionActivity extends AppCompatActivity {
    public static final String EXTRA_HERO = "com.trantan.myrecyclerview.EXTRA_HERO";
    private ImageView mImageHero;
    private TextView mNameHero;
    private Hero mHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripstion);
        setUpUi();
    }

    private void setUpUi() {
        mHero = (Hero) getIntent()
                .getSerializableExtra(DescripstionActivity.EXTRA_HERO);
        mNameHero = findViewById(R.id.text_name_hero);
        mImageHero = findViewById(R.id.image_hero);

        mNameHero.setText(mHero.getName());
        Picasso.get().load(mHero.getImageUrl()).into(mImageHero);
    }

    public static Intent getProfileIntent(Context context, Hero hero) {
        Intent intent = new Intent(context, DescripstionActivity.class);
        intent.putExtra(DescripstionActivity.EXTRA_HERO, hero);
        return intent;
    }
}
