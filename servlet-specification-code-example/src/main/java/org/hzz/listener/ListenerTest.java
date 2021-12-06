package org.hzz.listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/listener/dog")
public class ListenerTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dog dog = (Dog)getServletContext().getAttribute("dog");
        req.getSession().setAttribute("dog",dog);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("test context attributes set by listener<br>");
        writer.println("<br>");
        writer.println("Dog's breed is "+dog.getBreed());
    }
}
