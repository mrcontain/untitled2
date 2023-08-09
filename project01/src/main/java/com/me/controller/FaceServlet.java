package com.me.controller;


import com.me.pojo.UserWithFace;
import com.me.service.FaceService;
import com.me.utils.Base64TransWithImg;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/FaceServlet")
@MultipartConfig
public class FaceServlet extends HttpServlet {
    private FaceService userService=new FaceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part image = req.getPart("image");
        String filename = image.getSubmittedFileName();
        InputStream input = image.getInputStream();
        OutputStream output = new FileOutputStream(new File("C:\\ccc\\" + filename));
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        output.close();
        input.close();
        String s = Base64TransWithImg.convertImageToBase64Str("C:\\ccc\\image0.png");
        UserWithFace withFace = userService.findWithFace(s);
        if (withFace!=null){
            resp.getWriter().write("http://localhost:8080/pro1/html/operate.html?username="+withFace.getName());
        }else {
            resp.getWriter().write("http://localhost:8080/pro1/html/login.html");

        }
    }
}
