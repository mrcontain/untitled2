package com.me.service;

import com.me.dao.AreaDao;
import com.me.dao.StudentDao;
import com.me.dao.TeacherDao;
import com.me.pojo.Area;
import com.me.pojo.Student;
import com.me.pojo.teacher;

import java.util.List;

public class AdminService {
    private TeacherDao teacherDao=new TeacherDao();
    private StudentDao studentDao=new StudentDao();
    private  AreaDao areaDao= new AreaDao();
    public List<teacher> queryTechers(int pageNo ,String keyWord){
        List<teacher> teachers = teacherDao.queryMulti("select * from dingsg_teacher22 where dsg_tno22 like ? or dsg_tname22 like ? or dsg_tpos22 like ? or dsg_tsex22 like ? limit ?,?", teacher.class,"%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%", (pageNo - 1) *10, 10);
        return teachers;
    }
    public teacher queryTecher(String tno){
        teacher teacher = teacherDao.querySingle("select * from dingsg_teacher22 where dsg_tno22=?",teacher.class,tno);
        return teacher;
    }

    public String add(teacher teacher){
        int update = teacherDao.update("insert into dingsg_teacher22 values(?,?,?,?,?,?)", teacher.getDsg_tno22(), teacher.getDsg_tname22(), teacher.getDsg_tsex22(), teacher.getDsg_tage22(), teacher.getDsg_tpos22(), teacher.getDsg_tpho22());
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public int delWithTno(String tno){
        return teacherDao.update("delete from dingsg_teacher22 where dsg_tno22=?",tno);
    }

    public String updateTeacherWithTno(teacher teacher){
        int update = teacherDao.update("update dingsg_teacher22 set dsg_tname22=?,dsg_tsex22=?,dsg_tage22=?,dsg_tpos22=?,dsg_tpho22=? where dsg_tno22=?", teacher.getDsg_tname22(), teacher.getDsg_tsex22(), teacher.getDsg_tage22(), teacher.getDsg_tpos22(), teacher.getDsg_tpho22(), teacher.getDsg_tno22());
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public List<Student> queryStudents(int pageNo , String keyWord){
        List<Student> students = studentDao.queryMulti("select * from stu_information_view where dsg_sno22 like ? or dsg_sname22 like ? or dsg_ssex22 like ? or dsg_aname22 like ? or dsg_clname22 like ? limit ?,?", Student.class,"%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%","%"+keyWord+"%",(pageNo - 1) * 10, 10);
        return students;
    }

    public Student queryStudent(String sno){
        Student student = studentDao.querySingle("select * from stu_information_view where dsg_sno22=?", Student.class,sno);
        return student;
    }

    public String add(Student student){
        int update = teacherDao.update("insert into dingsg_student22 values(?,?,?,?,?,?,?)", student.getDsg_sno22(),student.getDsg_sname22(),student.getDsg_ssex22(),student.getDsg_sage22(),getAreaNO(student.getDsg_aname22()),student.getDsg_ssum22(),getClassNo(student.getDsg_clname22()));
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public String getAreaNO(String aname){
        Object o = studentDao.queryScalar("select dsg_ano22 from dingsg_area22 where dsg_aname22=?", aname);
        return (String)o;
    }

    public String getClassNo(String clname){
        Object o = studentDao.queryScalar("select dsg_clno22 from dingsg_class22 where dsg_clname22=?", clname);
        return (String)o;
    }

    public int delWithSno(String sno){
        return studentDao.update("delete from dingsg_student22 where dsg_sno22=?",sno);
    }

    public String updateStudentWithSno(Student student){
        int update = studentDao.update("update dingsg_student22 set dsg_sname22=?,dsg_ssex22=?,dsg_sage22=?,dsg_sareano22=?,dsg_ssum22=?,dsg_clno22=?where dsg_sno22=?",student.getDsg_sname22(),student.getDsg_ssex22(),student.getDsg_sage22(),getAreaNO(student.getDsg_aname22()),student.getDsg_ssum22(),getClassNo(student.getDsg_clname22()),student.getDsg_sno22());
        if (update>=0)
            return "success";
        else
            return "failed";
    }

    public List<Area> findAreas(int pageNo , String keyWord){
        List<Area> areas = areaDao.queryMulti("select * from numberOfareaview where dsg_aname22 like ? limit ?,?", Area.class,"%"+keyWord+"%",(pageNo - 1) * 10, 10);
        return areas;
    }
}
