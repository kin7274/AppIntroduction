package com.example.administrator.appintroduction;

import java.util.ArrayList;

public class Position {
    public String position;
    public ArrayList<String> players = new ArrayList<String>();

    public Position(String position){
        this.position = position;
    }

    public String toString () {
        return position;
    }

}

