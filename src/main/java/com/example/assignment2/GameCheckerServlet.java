package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GameCheckerServlet", value = "/GameCheckerServlet")
public class GameCheckerServlet extends CommonServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("capital1"));
        System.out.println(request.getParameter("capital2"));
        System.out.println(request.getParameter("capital3"));
        request.getSession().setAttribute("score", 5);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
