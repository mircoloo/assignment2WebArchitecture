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
    String playerName;
    FileWriterReader fwr = new FileWriterReader();


    public void init(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        System.out.println("Nome sessione:" + session.getAttribute("playerName"));
        if(session.getAttribute("playerName") == null){
            response.sendRedirect("login.jsp");
        }else{
            System.out.println("index page");
            fwr.getUser();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
