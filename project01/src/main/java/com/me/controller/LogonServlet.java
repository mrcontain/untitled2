package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.me.dao.UserDAO;
import com.me.pojo.User;
import com.me.pojo.UserWithFace;
import com.me.service.FaceService;
import com.me.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logonServlet")
public class LogonServlet extends HttpServlet {
    private FaceService userService=new FaceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String bufferStr;
        while ((bufferStr=reader.readLine())!=null) {
            stringBuilder.append(bufferStr);
        }
        reader.close();
        UserWithFace userWithFace = JSON.parseObject(stringBuilder.toString(), UserWithFace.class);
        String add = userService.add(userWithFace);
        resp.getWriter().write(add);
    }
}
