package com.example.administrator.appintroduction;

import java.util.ArrayList;

public class Index {
    public String index;
    public ArrayList<String> contents = new ArrayList<String>();

    public Index(String index){
        this.index = index;
    }

    public String toString () {
        return index;
    }

}

