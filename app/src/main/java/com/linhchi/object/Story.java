package com.linhchi.object;

public class Story {
    private int id;
    private String name;
    private String content;
    private int idGenres;

    public Story() {
    }

    public Story(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Story(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getIdGenres() {
        return idGenres;
    }
}
