package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.me.pojo.Course;
import com.me.pojo.CoursesOfClass;
import com.me.pojo.Reports;
import com.me.pojo.Student;
import com.me.service.AdminService;
import com.me.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private AdminService AdminService=new AdminService();
    private StudentService studentService=new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String no = req.getParameter("No");
        String keyWord = req.getParameter("keyWord");
        String type = req.getParameter("type");
        String s="";
        switch (type){
            case "singleInformation":{
                String sno = req.getParameter("sno");
                Student student = AdminService.queryStudent(sno);
                s = JSON.toJSONString(student);
                break;
            }
            case "score":{
                int i = Integer.parseInt(no);
                String sno = req.getParameter("sno");
                System.out.println(keyWord);
                List<Reports> scoress = studentService.queryscores(i,keyWord,sno);
                s = JSON.toJSONString(scoress);
                break;
            }

            case "classcourse":{
                List<CoursesOfClass> coursesOfClasses = studentService.queryCourses();
                s = JSON.toJSONString(coursesOfClasses);
                break;
            }

            case "course":{
                String sno = req.getParameter("sno");
                List<Course> courses = studentService.queryCourse(sno);
                s = JSON.toJSONString(courses);
                break;
            }

            case "credit":{
                String sno = req.getParameter("sno");
                Double aDouble = studentService.sumCredit(sno);
                s = aDouble.toString();
            }
            default:
        }

        resp.getWriter().write(s);
    }
}
