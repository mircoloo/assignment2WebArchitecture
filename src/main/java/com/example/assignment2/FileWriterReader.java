package com.example.assignment2;

import java.io.*;
import java.util.ArrayList;

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
            f = new FileOutputStream(myFile, true);
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

    public User getUser() throws IOException{

        try {
            File myFile = new File("Users.txt");
            FileInputStream fi = new FileInputStream(myFile);
            ObjectInputStream oi = new ObjectInputStream(fi);

            User pr1 = (User)oi.readObject();

            System.out.println("Retrieved user:" + pr1.getUsername()); //pr2.toString() + pr3.toString());

            oi.close();
            fi.close();

            return pr1;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<User> getUsers() throws IOException, ClassNotFoundException {

        ArrayList<User> users = new ArrayList<User>();
        FileInputStream fis = new FileInputStream("Users.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user =null;
        boolean isExist = true;
        while(isExist){
            if(fis.available() != 0){
                user = (User) ois.readObject();
                users.add(user);
                user.print();
            }
            else{
                isExist =false;
            }
        }
        return users;
    }

    }



