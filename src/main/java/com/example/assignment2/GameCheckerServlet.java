package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "GameCheckerServlet", value = "/GameCheckerServlet")
public class GameCheckerServlet extends CommonServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession s = request.getSession();
        int score = (int)s.getAttribute("score");
        String flags[] = (String[]) s.getAttribute("flags");
        String capital1 = request.getParameter("capital1");
        String capital2 = request.getParameter("capital2");
        String capital3 = request.getParameter("capital3");

        System.out.println(flags[0] + " " + capital1);
        System.out.println(flags[1] + " " + capital2);
        System.out.println(flags[2] + " " + capital3);



        for(int i = 0; i < 3; i ++){


        }


        s.setAttribute("score", score);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
