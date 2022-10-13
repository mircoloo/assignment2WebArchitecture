package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
        session = request.getSession();
        if(session.getAttribute("CURRENT_USER") == null){
            request.setAttribute("err", "You haven't logged in to the system");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
