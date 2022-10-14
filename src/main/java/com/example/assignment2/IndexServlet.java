package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "IndexServlet", value = "")
public class IndexServlet extends CommonServlet{

    boolean isAuth;
    HttpSession session;
    Integer score;
    String playerName;
    FileWriterReader fwr = new FileWriterReader("Users.txt");


    public void init(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileWriterReader fwr = new FileWriterReader("Users.txt");



        session = request.getSession();
        if(session.getAttribute("CURRENT_USER") == null){
            request.setAttribute("err", "You haven't logged in to the system");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            if(Objects.equals(session.getAttribute("CURRENT_USER"), "admin"))
            {
                request.getRequestDispatcher("adminPage.jsp").forward(request, response);
            }else{

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }










    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
