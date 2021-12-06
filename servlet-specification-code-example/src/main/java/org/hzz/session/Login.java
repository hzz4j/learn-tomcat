package org.hzz.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        if(password != null && !password.equals("Root.123456")){
            writer.println("password error");
            writer.flush();
            writer.close();
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        writer.println("<br>Welcome "+username);
        writer.print("<br>User Total: " + OnlineUserCount.getTotalUser());
        writer.print("<br>User Current: " + OnlineUserCount.getOnlineUser());
        writer.print("<br><a href='logout'>Logout</a>");
        writer.flush();
        writer.close();
    }
}
