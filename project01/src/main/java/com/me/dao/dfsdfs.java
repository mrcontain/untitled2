package com.me.dao;

import com.me.pojo.Filter;

import java.sql.SQLException;
import java.util.List;

public class dfsdfs {
    public static void main(String[] args) throws SQLException {
        TeacherDao teacherDao = new TeacherDao();
        FilterDao filterDao = new FilterDao();
        List<Filter> filters = filterDao.queryMulti("select dsg_sno22 \"text\",dsg_sno22 \"value\" from dingsg_student22", Filter.class);
        System.out.println(filters);
//        int execute = qr.execute(connection,"create table testtable(id1 int)");
    }
}
