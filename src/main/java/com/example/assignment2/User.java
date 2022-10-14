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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0){
            this.score = 0;
        }else{
            this.score = score;
        }
    }

    public void print(){
        System.out.println("Name:" + username + " Passsword:" + password + " Score: " + score);
    }

    public String toString(){
        return "Name:" + username + " Score: " + score;
    }

}
