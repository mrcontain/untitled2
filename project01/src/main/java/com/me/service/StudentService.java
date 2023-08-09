package com.me.service;

import com.me.dao.ClassOfCourseDao;
import com.me.dao.CourseDao;
import com.me.dao.ReportsDao;
import com.me.pojo.Course;
import com.me.pojo.CoursesOfClass;
import com.me.pojo.Reports;

import java.util.List;

public class StudentService {
    private ReportsDao reportsDao=new ReportsDao();
    private ClassOfCourseDao classOfCourseDao=new ClassOfCourseDao();

    private CourseDao courseDao=new CourseDao();
    public List<Reports> queryscores(int i, String keyWord,String sno) {
        List<Reports> reports = reportsDao.queryMulti("select * from stu_reportsview where dsg_sno22=? and (dsg_cname22 like ?" +
                " or dsg_ccredit22 like ? or dsg_cdate22 like ?) limit ?,?", Reports.class, sno,"%" + keyWord + "%", "%" + keyWord + "%", "%" + keyWord + "%", (i - 1) * 10, 10);
        return reports;
    }

    public List<CoursesOfClass> queryCourses(){
        List<CoursesOfClass> coursesOfClasses = classOfCourseDao.queryMulti("select * from class_courseview", CoursesOfClass.class);
        return coursesOfClasses;
    }

    public List<Course> queryCourse(String sno){
        List<Course> courses = courseDao.queryMulti("select * from course_creditview where dsg_sno22=?", Course.class,sno);
        return courses;
    }

    public Double sumCredit(String sno){
        Object o = courseDao.queryScalar("select sum(dsg_ccredit22) from course_creditview where dsg_sno22=? group by dsg_sno22", sno);
        return (Double)o;
    }
}
