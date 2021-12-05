package org.hzz;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@MultipartConfig
public class FileUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============FileUpload===================");
        Collection<Part> parts = req.getParts();
        for (Part part: parts){
            System.out.println(part.getSubmittedFileName());
            File file = new File("./"+part.getSubmittedFileName());
            InputStream is = part.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(file);
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = is.read(bytes)) != -1){
                outputStream.write(bytes,0,read);
            }
            System.out.println("===============next part====================");
        }
    }
}
