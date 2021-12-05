package org.hzz.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/request/attributes")
public class Attributes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("developer.name","静默");
        Enumeration<String> attributeNames = req.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String name = attributeNames.nextElement();
            System.out.println(name + " = " + req.getAttribute(name));
        }
    }
}
