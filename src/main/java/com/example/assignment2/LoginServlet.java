package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    boolean isAuth;
    Integer score;
    HttpSession s;

    public void init() {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        s = request.getSession();

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if(Objects.equals(userName, "admin") && Objects.equals(password, "nimda")){
            request.getRequestDispatcher("AdminServlet").forward(request,response);
        }else{
            s.setAttribute("playerName", userName);
            s.setAttribute("score", 0);

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }
}
