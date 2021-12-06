package org.hzz.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 <listener>
     <listener-class>
        org.hzz.listener.MyServletContextListener
     </listener-class>
 </listener>
 */
@WebListener // 让容器发现这个listener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("code to initialize the database connection");
        System.out.println("and store it as a context attribute");

        ServletContext servletContext = sce.getServletContext();
        String breed = servletContext.getInitParameter("breed");
        Dog dog = new Dog(breed);
        servletContext.setAttribute("dog",dog);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("code to close the database connection");
    }
}
