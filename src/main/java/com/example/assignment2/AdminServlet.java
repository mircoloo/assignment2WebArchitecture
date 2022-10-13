package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends CommonServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("CURRENT_USER"));
        if(!Objects.equals(request.getSession().getAttribute("CURRENT_USER"), "admin")){
            System.out.println("You are not the admin");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            System.out.println("You're the admin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
