package com.example.assignment2;

import java.io.Serializable;

public class User implements Serializable{

    private String username;
    private String password;
    private int score;

    User(){

    }

    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return "Name:" + username + " Score: " + score;
    }

}
