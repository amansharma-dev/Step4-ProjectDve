package com.example.step4_projectdve.Model;

public class Name {
    private int id;
    private String name;
    private String date;
    private String time;


    public Name() {
    }

    public Name(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Name(int id, String name, String date, String time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
