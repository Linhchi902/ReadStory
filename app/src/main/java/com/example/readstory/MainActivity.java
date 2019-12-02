package com.example.readstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.readstory.Data.ProcessDatabase;
import com.linhchi.object.GenresName;
import com.linhchi.interf.IGenres;
import com.linhchi.adapter.MyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGenres {
    private ProcessDatabase processDatabase;
    private RecyclerView rcvGenres;
    private List<GenresName> listNameGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        rcvGenres = findViewById(R.id.rcv_genres);
        processDatabase=new ProcessDatabase(this);
        listNameGenres=processDatabase.getAllGenresName();

        MyAdapter adapter= new MyAdapter(this,listNameGenres,this);
        rcvGenres.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcvGenres.setAdapter(adapter);
    }


    @Override
    public void onclick(int position) {
        Intent intent = new Intent(this, ListStoryActivity.class);
        intent.putExtra("nameGenres",listNameGenres.get(position).getName());
        intent.putExtra("idGenres",listNameGenres.get(position).getId_cat());
        startActivity(intent);
    }

    @Override
    public GenresName getData(int position) {
        return listNameGenres.get(position);
    }

    @Override
    public int getCount() {
        return listNameGenres.size();
    }

}
