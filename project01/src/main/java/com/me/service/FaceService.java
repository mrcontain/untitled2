package com.me.service;

import com.me.dao.UserDAO;
import com.me.dao.UserWithFaceDao;
import com.me.pojo.UserWithFace;

import java.util.List;

public class FaceService {
    public String add(UserWithFace user) {
        if (user == null)
            return null;
        UserWithFaceDao userWithFaceDao = new UserWithFaceDao();
        int update = userWithFaceDao.update("INSERT INTO userfacetable(`name`,`password`,`face`) VALUES(?,?,?)",
                user.getName(), user.getPassword(), user.getFace());
        if (update != 0) {
            return "success";
        } else {
            return "no";
        }
    }

    public String find(String account){
        UserDAO userDAO = new UserDAO();
        Object o = userDAO.queryScalar("select name from userfacetable where name = ?", account);
        if (o!=null){
            return "exist";
        }else{
            return "no";
        }
    }
    public String find(UserWithFace user){
        UserWithFaceDao userWithFaceDao = new UserWithFaceDao();
        System.out.println(user);
        Object o = userWithFaceDao.queryScalar("select name from userfacetable where name = ?", user.getName());
        if (o!=null){
            UserWithFace userWithFace = userWithFaceDao.querySingle("select name,password from userfacetable where name = ? and password = ?", UserWithFace.class, user.getName(), user.getPassword());
            if (userWithFace==null){
                return "passwordNo";
            }else {
                return "success";
            }
        }else{
            return "accountNo";
        }
    }

    public UserWithFace findWithFace(String faceWithBase64){
        UserWithFaceDao userWithFaceDao = new UserWithFaceDao();
        List<UserWithFace> userWithFaces = userWithFaceDao.queryMulti("select * from userfacetable", UserWithFace.class);
        for (UserWithFace userWithFace : userWithFaces) {
            if (true)//根据具体的识别精度要求进行改写
                return userWithFace;
        }
        return null;
    }
    public List<UserWithFace> findMulti(int pageNo){
        UserWithFaceDao userDao = new UserWithFaceDao();
        List<UserWithFace> users = userDao.queryMulti("select * from userfacetable limit ?,?", UserWithFace.class, (pageNo - 1) * 11, 11);
        return users;
    }

    public boolean delWithId(Integer id){
        UserWithFaceDao userDao = new UserWithFaceDao();
        int update = userDao.update("delete from userfacetable where id = ?", id);
        return true;
    }
}
