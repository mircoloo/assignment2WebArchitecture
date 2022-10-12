package com.example.assignment2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class FileWriterReader {
    FileOutputStream f;
    ObjectOutputStream o;
    User user1 = new User("Mirco", "pas123");

    public Map<> init(){

    }
    public void addUser(){
        try{
            f = new FileOutputStream(new File("Users.txt"));
            o = new ObjectOutputStream(f);
            o.writeObject(user1);
            o.close();
            f.close();
        }catch (IOException e) {
            System.out.println("File not found");

        }
    }

    public User getUser(){
        return new User();
    }
}
