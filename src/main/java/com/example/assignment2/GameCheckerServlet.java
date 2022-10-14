package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "GameCheckerServlet", value = "/GameCheckerServlet")
public class GameCheckerServlet extends CommonServlet {

    public boolean isValid(String capital, String state){
        HashMap<String, String> stateCapitals = new HashMap<String, String>();
        //HttpSession s = request.getSession();
        //HashMap<String, String> stateCapitals =  (HashMap<String, String>) .getAttribute("stateCapitals");


        stateCapitals.put("Italy", "Rome");
        stateCapitals.put("Germany", "Berlin");
        stateCapitals.put("Belgium", "Bruxelles");
        stateCapitals.put("Romania", "Bucarest");
        stateCapitals.put("Portugal", "Lisbona");
        stateCapitals.put("France", "Paris");
        return Objects.equals(capital, stateCapitals.get(state));
    }


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

        System.out.println(isValid(capital1, flags[0]));
        System.out.println(isValid(capital2, flags[1]));
        System.out.println(isValid(capital3, flags[2]));

        if(isValid(capital1, flags[0]) && isValid(capital2, flags[1]) && isValid(capital3, flags[2])){
            score += 3;
        }else{
            score-=1;
        }
        s.setAttribute("score", score);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
