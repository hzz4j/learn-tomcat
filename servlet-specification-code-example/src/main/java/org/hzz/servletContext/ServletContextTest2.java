package org.hzz.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servletContext/test2")
public class ServletContextTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            System.out.println(name + " = " + servletContext.getAttribute(name));
        }
    }
}
