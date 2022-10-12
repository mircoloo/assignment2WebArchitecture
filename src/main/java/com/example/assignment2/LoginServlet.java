package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    boolean isAuth;
    Integer score;
    HttpSession s;

    public void init() {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileInputStream fi = new FileInputStream(new File("Users.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        User pr1 = null;
        try {
            pr1 = (User) oi.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pr1.toString());

        oi.close();
        fi.close();

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        s = request.getSession();

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        s.setAttribute("playerName", userName);
        s.setAttribute("score", 0);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
