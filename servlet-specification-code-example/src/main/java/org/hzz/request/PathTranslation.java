package org.hzz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request/pathTranslated")
public class PathTranslation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String realPath = req.getServletContext().getRealPath("");
        String pathTranslated = req.getPathTranslated();
        // pathTranslated = null
        System.out.println("pathTranslated = " + pathTranslated);
        // realPath = D:\Github\learn-tomcat\catalina-home\webapps\servlet-specification\
        System.out.println("realPath = " + realPath);
        // requestURI = /servlet_specification/request/pathTranslated
        System.out.println("requestURI = " + requestURI);
    }
}
