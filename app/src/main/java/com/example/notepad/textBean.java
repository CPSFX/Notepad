package com.example.notepad;

import java.util.Date;

public class textBean {
    private int id;
    private String title;
    private String name;
    private String Context;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public textBean(int id, String title,String name, String context, String date) {
        this.id = id;
        this.title = title;
        this.name = name;
        Context = context;
        this.date = date;
    }
}
