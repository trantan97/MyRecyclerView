package com.trantan.myrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trantan.myrecyclerview.ItemClickListener;
import com.trantan.myrecyclerview.R;
import com.trantan.myrecyclerview.model.Hero;

import java.util.ArrayList;

public class ChildsAdapter extends RecyclerView.Adapter<ChildsAdapter.ViewHolder> {
    private ArrayList<Hero> mHeros;
    private ItemClickListener mItemClickListener;

    public ChildsAdapter(ArrayList<Hero> heros, ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
        mHeros = heros;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recycler_child, viewGroup, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.setData(mHeros.get(i));
    }

    @Override
    public int getItemCount() {
        return mHeros == null ? 0 : mHeros.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextHeroName;
        private ImageView mImageHero;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            mTextHeroName = itemView.findViewById(R.id.text_name_hero);
            mImageHero = itemView.findViewById(R.id.image_hero);

            mImageHero.setOnClickListener(this);
        }

        public void setData(Hero hero) {
            mTextHeroName.setText(hero.getName());
            Picasso.get().load(hero.getImageUrl()).into(mImageHero);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(mHeros.get(getAdapterPosition()));
        }
    }
}
