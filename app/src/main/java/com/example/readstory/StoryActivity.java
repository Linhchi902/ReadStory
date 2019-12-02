package com.example.readstory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.example.readstory.R;

public class StoryActivity extends AppCompatActivity {

    private TextView tvNameStory;
    private TextView tvContentStory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        initViews();
    }

    private void initViews() {
        tvNameStory = findViewById(R.id.tv_story);
        tvContentStory = findViewById(R.id.tv_content_story);
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameStory");
        String content = intent.getStringExtra("contentStory");

        tvNameStory.setText(name);
        tvContentStory.setText(android.text.Html.fromHtml(content));
    }

}
