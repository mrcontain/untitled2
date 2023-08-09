package com.me.controller;

import com.me.utils.Base64TransWithImg;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/save")
@MultipartConfig
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part image = request.getPart("image");
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
        assert s != null;
        response.getWriter().write(s);
    }
}