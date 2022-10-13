package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CommonServlet", value = "/CommonServlet")
public class CommonServlet extends HttpServlet {
    protected void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("CURRENT_USER") == null) {
            request.setAttribute("err", "You haven't logged in to the system");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
