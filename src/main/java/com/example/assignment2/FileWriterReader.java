package com.example.assignment2;

import java.io.*;

public class FileWriterReader {
    FileOutputStream f;
    ObjectOutputStream o;
    String filePathName;

    FileWriterReader(String pathname){
        filePathName = pathname;
    }

    public void addUser(String username, String password) {

        try {
            File myFile = new File(filePathName);
            f = new FileOutputStream(myFile);
            o = new ObjectOutputStream(f);
            //Add user
            User user1 = new User(username, password);
            o.writeObject(user1);
            System.out.println("Added user: " + user1.toString());
            //Close stream
            o.close();
            f.close();
        } catch (IOException e) {
            System.out.println("File not found");

        }
    }

    public void getUser() throws IOException{

        try {
            File myFile = new File(filePathName);
            FileInputStream fi = new FileInputStream(myFile);
            ObjectInputStream oi = new ObjectInputStream(fi);

            User pr1 = (User) oi.readObject();
            System.out.println(pr1.toString());

            oi.close();
            fi.close();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}

