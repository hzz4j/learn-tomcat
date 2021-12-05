package org.hzz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/request/path")
public class path extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String requestURI = contextPath + servletPath + pathInfo;
        System.out.println("contextPath = " + contextPath);
        System.out.println("servletPath = " + servletPath);
        System.out.println("pathInfo = " + pathInfo);
        System.out.println("requestURI = " + requestURI);
    }
}
