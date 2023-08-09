package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.me.pojo.Area;
import com.me.pojo.Student;
import com.me.pojo.teacher;
import com.me.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OperatorServlet")
public class OperatorServlet extends HttpServlet {
    private AdminService AdminService=new AdminService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("access-control-allow-credentials", "true");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String no = req.getParameter("No");
        String keyWord = req.getParameter("keyWord");
        String type = req.getParameter("type");
        String s="";
        switch (type){
            case "teacher":{
                int i = Integer.parseInt(no);
                List<teacher> teachers = AdminService.queryTechers(i,keyWord);
                s = JSON.toJSONString(teachers);
                break;
            }
            case "student":{
                int i = Integer.parseInt(no);
                List<Student> students = AdminService.queryStudents(i,keyWord);
                s = JSON.toJSONString(students);
                break;
            }

            case "area":{
                int i = Integer.parseInt(no);
                List<Area> students = AdminService.findAreas(i,keyWord);
                s = JSON.toJSONString(students);
                break;
            }
            default:
        }

        resp.getWriter().write(s);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
