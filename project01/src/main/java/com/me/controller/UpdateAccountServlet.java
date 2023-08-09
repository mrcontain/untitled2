package com.me.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.me.pojo.User;
import com.me.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {

    private UserService userService=new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String bufferStr;
        while ((bufferStr=reader.readLine())!=null) {
            stringBuilder.append(bufferStr);
        }
        reader.close();
        JSONObject jsonObject = JSON.parseObject(stringBuilder.toString());
        String account = jsonObject.getString("account");
        String password = jsonObject.getString("password");
        String identity = jsonObject.getString("identity");
        System.out.println(account);
        User user = new User(account, password, identity);
        userService.updateAccount(user);
    }
}
