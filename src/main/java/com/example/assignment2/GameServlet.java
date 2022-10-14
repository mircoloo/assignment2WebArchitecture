package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Array;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends CommonServlet {


    String[] nations = {"Belgium", "France", "Germany", "Italy", "Portugal", "Romania"};


    public String[] generateRandomFlags(){
        String[] flags = new String[3];
        for(int i = 0; i < 3; i++){
            flags[i] =  nations[ (int)(Math.random() * (5 - 0 + 1))];
        }
        return flags;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        String[] flags = generateRandomFlags();
        s.setAttribute("flags", flags);

        if(s.getAttribute("score") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        request.getRequestDispatcher("game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
