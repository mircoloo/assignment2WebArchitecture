package com.example.assignment2;

import javax.servlet.ServletContext;
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
    //ServletContext scx = getServletContext();
    ObjectOutputStream o;
    String filePathName = "Users.txt";

    public void init() {

    }

    public void addUser(String username, String password) {


        try {
            f = new FileOutputStream(new File(filePathName));
            o = new ObjectOutputStream(f);
            //Add user
            User user1 = new User(username, password);
            o.writeObject(user1);

            //Close stream
            o.close();
            f.close();
        } catch (IOException e) {
            System.out.println("File not found");

        }
    }

    public void getUser() {

        try {
            FileInputStream fi = new FileInputStream(new File(filePathName));
            ObjectInputStream oi = new ObjectInputStream(fi);

            User pr1 = (User) oi.readObject();
            System.out.println(pr1.toString());

            oi.close();
            fi.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}

