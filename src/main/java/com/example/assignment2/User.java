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

    public void updateScore(int score){
        if(score < 0){
             this.score = 0;
        }else{
            this.score = score;
        }
    }

    public String toString(){
        return "Name:" + username + " Score: " + score;
    }

}
