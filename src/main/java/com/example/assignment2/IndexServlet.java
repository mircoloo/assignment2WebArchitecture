package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "")
public class IndexServlet extends HttpServlet {

    boolean isAuth;
    HttpSession session;
    Integer score;


    public void init(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();

        synchronized(session) {
            if (session.getAttribute("isAuth") == null || false) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }



            //User is auth
            score = (Integer) session.getAttribute("score");
            if (score == null) {
                score = 0;
            }
            session.setAttribute("score", score);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
