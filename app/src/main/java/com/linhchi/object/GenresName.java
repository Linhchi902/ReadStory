package com.linhchi.object;

public class GenresName {
    private String name;
    private int id_cat;

    public GenresName(int img, String name) {
        this.name = name;
        this.id_cat = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
}
