package com.me.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCookieUtils {

    public static boolean isExist(HttpServletRequest req,String account){
        if (req==null)
            return false;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            if (value.equals(account)){
                return true;
            }
        }
        return false;
    }
}
