package com.me.controller;

import com.me.service.FaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckAccountServlet")
public class CheckAccountServlet extends HttpServlet {
    private FaceService userService=new FaceService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String s = userService.find(account);
        resp.getWriter().write(s);
    }
}
