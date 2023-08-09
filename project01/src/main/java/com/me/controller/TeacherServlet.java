package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.me.pojo.*;
import com.me.service.AdminService;
import com.me.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    private com.me.service.AdminService AdminService=new AdminService();
    private TeacherService teacherService = new TeacherService();

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
                String tno = req.getParameter("tno");
                teacher teacher = AdminService.queryTecher(tno);
                s = JSON.toJSONString(teacher);
                break;
            }
            case "teachercourse":{
                String tno = req.getParameter("tno");
                List<TeacherCourse> teacherCourses = teacherService.queryscores(tno);
                s = JSON.toJSONString(teacherCourses);
                break;
            }

            case "avgscore":{
                String tno = req.getParameter("tno");
                List<AvgScore> avgScores = teacherService.queryAvgScore(tno);
                s = JSON.toJSONString(avgScores);
                break;
            }

            case "passpeople":{
                String cno = req.getParameter("cno");
                Integer passpeople = teacherService.passpeople(cno);
                Integer people = teacherService.people(cno);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("passpeople",passpeople);
                jsonObject.put("people",people);
                s = jsonObject.toJSONString();
                break;
            }

            case "grade":{
                String tno = req.getParameter("tno");
                List<TeacherGrade> teacherGrades = teacherService.queryGrade(tno);
                s = JSON.toJSONString(teacherGrades);
                break;
            }

            case "filter":{
                String tno = req.getParameter("tno");
                List<Filter> filters = teacherService.queryFilter(tno);
                s = JSON.toJSONString(filters);
                break;
            }

            case "add":{
                String score = req.getParameter("score");
                String cno = req.getParameter("cno");
                String sno = req.getParameter("sno");
                String tname = req.getParameter("tname");
                double v = Double.parseDouble(score);
                s = teacherService.add(v, sno, cno,tname);
                break;
            }

            case "update":{
                String score = req.getParameter("score");
                String cno = req.getParameter("cno");
                String sno = req.getParameter("sno");
                double v = Double.parseDouble(score);
                s = teacherService.updateTeacherGrade(v, sno, cno);
                break;
            }

            case "del":{
                String cno = req.getParameter("cno");
                String sno = req.getParameter("sno");
                teacherService.del(sno, cno);
                String tno = req.getParameter("tno");
                List<TeacherGrade> teacherGrades = teacherService.queryGrade(tno);
                s = JSON.toJSONString(teacherGrades);
                break;
            }
            default:
        }

        resp.getWriter().write(s);
    }
}
