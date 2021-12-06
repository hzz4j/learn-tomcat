package org.hzz.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;

@WebServlet("/servletContext/fileDown/*")
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // pathInfo 是 /bookCode.jar
        String filename = req.getPathInfo().substring(1);
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType(filename);

        // We want the browser to recognize that this is a JAR, not HTML, so we set the
        //content type to “application/java-archive”.
        resp.setContentType(mimeType);

        // This just says, “give me an input stream for the resource named tomcat-i18n-zh-CN.jar”.
        InputStream resourceAsStream = servletContext.getResourceAsStream("/"+filename);

        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream outputStream = resp.getOutputStream();
        while((read = resourceAsStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }
}
