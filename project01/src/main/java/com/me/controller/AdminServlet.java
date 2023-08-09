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

@WebServlet("/AdServlet")
public class AdminServlet extends HttpServlet {

    private AdminService adminService=new AdminService();
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
        System.out.println(jsonObject);
        Integer flag = (Integer)jsonObject.remove("flag");
        String type = (String)jsonObject.remove("type");
        if ("teacher".equals(type)) {
            teacher teacher = jsonObject.toJavaObject(teacher.class);
            if (flag==1){
                String add = adminService.add(teacher);
                resp.getWriter().write(add);
            }else{
                String s = adminService.updateTeacherWithTno(teacher);
                resp.getWriter().write(s);

            }
        }else{
            Student student = jsonObject.toJavaObject(Student.class);
            if (flag==1){
                String add = adminService.add(student);
                resp.getWriter().write(add);
            }else{
                String s = adminService.updateStudentWithSno(student);
                resp.getWriter().write(s);

            }
        }

    }
}
