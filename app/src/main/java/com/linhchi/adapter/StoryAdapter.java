package com.linhchi.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.readstory.R;
import com.linhchi.interf.IStory;
import com.linhchi.object.Story;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    IStory inter;

    public StoryAdapter(IStory inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_list_item,viewGroup,false);
        return new ViewHolder(view,inter);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Story story = inter.getData(i);
        viewHolder.tvName.setText(story.getName());
    }

    @Override
    public int getItemCount() {
        return inter.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName;
        IStory iStory;
        public ViewHolder(@NonNull View itemView,IStory story) {
            super(itemView);
            this.iStory = story;
            tvName= itemView.findViewById(R.id.tv_namestory);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iStory.onclick(getAdapterPosition());
        }
    }
}
