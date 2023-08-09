package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.me.pojo.User;
import com.me.service.UserService;
import com.me.utils.TestCookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/TestAccountForLoginServlet")
public class TestAccountForLoginServlet extends HttpServlet {
    private UserService userService=new UserService();
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
        User user = JSON.parseObject(stringBuilder.toString(), User.class);
        String s = userService.find(user);
        System.out.println(s);
        resp.getWriter().write(s);
        if (!("failed".equals(s))&& !(TestCookieUtils.isExist(req,user.getDsg_account22())&&TestCookieUtils.isExist(req,user.getDsg_password22())&&TestCookieUtils.isExist(req,user.getDsg_identity()))){
            Cookie username = new Cookie("account", user.getDsg_account22());
            Cookie password = new Cookie("password", user.getDsg_password22());
            Cookie identity = new Cookie("identity", user.getDsg_identity());
            resp.addCookie(username);
            resp.addCookie(password);
            resp.addCookie(identity);
        }
    }
}
