package com.me.service;

import com.me.dao.UserDAO;
import com.me.pojo.User;

import java.util.List;

public class UserService {
    public String add(User user){
        if (user==null)
            return null;
        UserDAO userDAO = new UserDAO();
        int update = userDAO.update("INSERT INTO dingsg_account22(dsg_account22,dsg_password22,dsg_identity) VALUES(?,?)",user.getDsg_account22(), user.getDsg_password22());
        if (update!=0){
            return "success";
        }else {
            return "no";
        }
    }

    public String updateAccount(User user){
        if (user==null)
            return null;
        UserDAO userDAO = new UserDAO();
        int update = userDAO.update("UPDATE dingsg_account22 SET dsg_password22=? where dsg_account22=? and dsg_identity=?", user.getDsg_password22(),user.getDsg_account22(),user.getDsg_identity());
        System.out.println(user);
        if (update!=0){
            return "success";
        }else {
            return "no";
        }
    }

    public String find(String account){
        UserDAO userDAO = new UserDAO();
        Object o = userDAO.queryScalar("select dsg_account22 from dingsg_account22 where dsg_account22 = ?", account);
        if (o!=null){
            return "exist";
        }else{
            return "no";
        }
    }
    public String find(User user){
        UserDAO userDAO = new UserDAO();
        System.out.println(user);
        User user1 = userDAO.querySingle("select * from dingsg_account22 where dsg_account22 = ? and dsg_password22 = ? and dsg_identity = ?", User.class, user.getDsg_account22(), user.getDsg_password22(), user.getDsg_identity());
        System.out.println(user1);
        if (user1 == null) {
            return "failed";
        } else if ("tea".equals(user.getDsg_identity())){
            return "teacher";
        } else if ("super".equals(user.getDsg_identity())) {
         return "super";
        }else
            return "student";
    }

    public List<User> findMulti(int pageNo){
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.queryMulti("select * from dingsg_account22 limit ?,?", User.class, (pageNo - 1) * 2, 2);
        return users;
    }

    public boolean delWithId(String id){
        UserDAO userDAO = new UserDAO();
        int update = userDAO.update("delete from dingsg_account22 where dsg_account22 = ?", id);
        return true;
    }
}
