package org.hzz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet... ...");
        //
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }
        // ?world=jingmo&world=hzz
        String[] worlds = req.getParameterValues("world");
        System.out.println(Arrays.toString(worlds));

        resp.getWriter().println("Back,hello.");
        resp.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============POST METHOD==================");
        String[] as = req.getParameterValues("a");
        // read body data
        String collect = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(collect);
        System.out.println(Arrays.toString(as));
    }
}
