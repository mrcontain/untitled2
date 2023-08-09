package com.me.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CheckedCodeServlet")
public class CheckedCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String rand = (String)session.getAttribute("rand");
        String checkedCode = request.getParameter("checkedCode");
        System.out.println(checkedCode);
        System.out.println(rand);
        if (rand.equalsIgnoreCase(checkedCode))
            response.getWriter().write("same");
    }
}
