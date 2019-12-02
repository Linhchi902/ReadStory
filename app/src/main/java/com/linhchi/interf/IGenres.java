package com.linhchi.interf;


import com.linhchi.object.GenresName;

public interface IGenres {
    void onclick(int position);
    GenresName getData(int position);
    int getCount();
}
