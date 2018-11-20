package com.trantan.myrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trantan.myrecyclerview.ItemClickListener;
import com.trantan.myrecyclerview.R;
import com.trantan.myrecyclerview.model.Story;

import java.util.ArrayList;

public class ParentsAdapter extends RecyclerView.Adapter<ParentsAdapter.ViewHolder> {
    private ArrayList<Story> mStories;
    private ItemClickListener mItemClickListener;

    public ParentsAdapter(ArrayList<Story> stories, ItemClickListener itemClickListener) {
        mStories = stories;
        mItemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recycler_parent, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(mStories.get(i));
    }

    @Override
    public int getItemCount() {
        return mStories == null ? 0 : mStories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView mRecyclerChild;
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_name_story);
            mRecyclerChild = itemView.findViewById(R.id.recycler_child);
        }

        public void setData(Story story) {
            mTextView.setText(story.getName());
            ChildsAdapter adapter =
                    new ChildsAdapter(story.getHeroes(), mItemClickListener);
            mRecyclerChild.setAdapter(adapter);
        }
    }
}
