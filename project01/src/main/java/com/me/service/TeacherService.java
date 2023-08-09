package com.me.service;

import com.me.dao.AvgScoreDao;
import com.me.dao.FilterDao;
import com.me.dao.TeacherCourseDao;
import com.me.dao.TeacherGradeDao;
import com.me.pojo.*;

import java.util.List;

public class TeacherService {
    private TeacherCourseDao teacherCourseDao=new TeacherCourseDao();
    private AvgScoreDao avgScoreDao=new AvgScoreDao();

    private TeacherGradeDao teacherGradeDao=new TeacherGradeDao();

    private FilterDao filterDao=new FilterDao();
    public List<TeacherCourse> queryscores(String tno) {
        List<TeacherCourse> teacherCourses = teacherCourseDao.queryMulti("select * from teacher_courseview where dsg_tno22=?", TeacherCourse.class,tno);
        return teacherCourses;
    }

    public List<AvgScore> queryAvgScore(String tno){
        List<AvgScore> avgScores = avgScoreDao.queryMulti("select * from avgscore_view where dsg_cno22 in (select dsg_cno22 from dingsg_tea_cour22 where dsg_tno22=?)", AvgScore.class,tno);
        return avgScores;
    }

    public Integer passpeople(String cno){
        Object o = teacherCourseDao.queryScalar("select count(*) from dingsg_reports22 where dsg_score22>=60 group by dsg_cno22 having dsg_cno22=?", cno);
        return Integer.parseInt(o.toString());
    }

    public Integer people(String cno){
        Object o = teacherCourseDao.queryScalar("select count(*) from dingsg_reports22 group by dsg_cno22 having dsg_cno22=?", cno);
        return Integer.parseInt(o.toString());
    }

    public List<TeacherGrade> queryGrade(String tno){
        List<TeacherGrade> teacherGrades = teacherGradeDao.queryMulti("select * from tea_coursereportsview where dsg_tno22 =?", TeacherGrade.class, tno);
        return teacherGrades;
    }

    public List<Filter> queryFilter(String tno){
        List<Filter> filters = filterDao.queryMulti("select DISTINCT dsg_cname22 \"text\",dsg_cname22 \"value\" from tea_coursereportsview where dsg_tno22=?", Filter.class, tno);
        return filters;
    }

    public String updateTeacherGrade(Double score,String sno,String cno){
        int update = teacherGradeDao.update("update dingsg_reports22 set dsg_score22=? where dsg_sno22=? and dsg_cno22=?", score,sno,cno);
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public String add(Double score,String sno,String cno,String tname){
        int update = teacherGradeDao.update("insert into dingsg_reports22 values(?,?,?,?,?)", cno,sno,score,"2018",tname);
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public String del(String sno,String cno){
        int update = teacherGradeDao.update("delete from dingsg_reports22 where dsg_sno22=? and dsg_cno22=?", sno,cno);
        if (update>=0)
            return "success";
        else
            return "failed";
    }
}
