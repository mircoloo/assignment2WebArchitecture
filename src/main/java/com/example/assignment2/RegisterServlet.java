package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    HttpSession s;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        s = request.getSession();
        FileWriterReader fwr = new FileWriterReader("Users.txt");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        fwr.addUser(userName, password);

        s.setAttribute("CURRENT_USER", userName);
        s.setAttribute("score", 0);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
