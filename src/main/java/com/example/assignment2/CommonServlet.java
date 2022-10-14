package com.example.assignment2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "CommonServlet", value = "/CommonServlet")
public class CommonServlet extends HttpServlet {

    HashMap<String, String> stateCapitals = new HashMap<String, String>();

    protected void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        stateCapitals.put("Italy", "Rome");
        stateCapitals.put("Germnany", "Berlin");
        stateCapitals.put("Belgium", "Bruxelles");
        stateCapitals.put("Romania", "Budapest");
        stateCapitals.put("Portugal", "Lisbona");
        stateCapitals.put("France", "Paris");

        HttpSession session = request.getSession();
        session.setAttribute("stateCapitals", stateCapitals);

        if (request.getSession().getAttribute("CURRENT_USER") == null) {
            request.setAttribute("err", "You haven't logged in to the system");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
