package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.me.pojo.Student;
import com.me.pojo.teacher;
import com.me.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/OperatorFordelServlet")
public class OperatorFordelServlet extends HttpServlet {
    private AdminService userService=new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("access-control-allow-credentials", "true");
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
        String type = jsonObject.getString("type");
        if ("teacher".equals(type)) {
            Integer no = jsonObject.getInteger("No");
            String tno = jsonObject.getString("tno");
            String keyWord = jsonObject.getString("keyWord");
            userService.delWithTno(tno);
            List<teacher> multi = userService.queryTechers(no,keyWord);
            String s = JSON.toJSONString(multi);
            resp.getWriter().write(s);
        }else {
            Integer no = jsonObject.getInteger("No");
            String sno = jsonObject.getString("sno");
            String keyWord = jsonObject.getString("keyWord");
            userService.delWithSno(sno);
            List<Student> multi = userService.queryStudents(no,keyWord);
            String s = JSON.toJSONString(multi);
            resp.getWriter().write(s);
        }
    }
}
