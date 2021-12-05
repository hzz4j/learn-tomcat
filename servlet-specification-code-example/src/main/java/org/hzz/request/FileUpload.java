package org.hzz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

// 用于getPart中part使用的
@MultipartConfig(location = "D:\\Github\\learn-tomcat\\catalina-home\\webapps\\servlet-specification\\uploads")
public class FileUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============FileUpload===================");
        Collection<Part> parts = req.getParts();
        for (Part part: parts){
            part.write(part.getSubmittedFileName());
        }
    }
}
