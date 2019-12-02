package com.example.readstory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.readstory.Data.ProcessDatabase;
import com.linhchi.interf.IStory;
import com.linhchi.object.Story;
import com.linhchi.adapter.StoryAdapter;

import java.util.List;

public class ListStoryActivity extends AppCompatActivity implements IStory {

    private TextView tvTitle;
    private ProcessDatabase processDatabase;
    private RecyclerView rcListStory;
    private List<Story> listStory;
    private StoryAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liststory);
        initViews();
    }

    private void initViews() {
        rcListStory = findViewById(R.id.rcv_list_story);
        adapter = new StoryAdapter(this);
        processDatabase = new ProcessDatabase(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("idGenres",1);
        String name = intent.getStringExtra("nameGenres");

        tvTitle = findViewById(R.id.tv_genres);
        tvTitle.setText(name);

        listStory = processDatabase.getNameStoryByCat(id);
        adapter = new StoryAdapter(this);

        rcListStory.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        rcListStory.setAdapter(adapter);
    }


    @Override
    public void onclick(int position) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra("nameStory",listStory.get(position).getName());
        intent.putExtra("contentStory",listStory.get(position).getContent());
        startActivity(intent);
    }

    @Override
    public Story getData(int position) {
        return listStory.get(position);
    }

    @Override
    public int getCount() {
        return listStory.size();
    }
}
