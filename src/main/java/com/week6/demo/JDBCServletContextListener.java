package com.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import  javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    //like a main() method for  this web app
    //called when tomcat start
        ServletContext context = sce.getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitiaLized()-- >+con");//when?
           // System.out.println("init()-->"+con);
            context.setAttribute("con",con); //name = value
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //end point of web app
        //this method called when tomcat stop
        System.out.println("i am in contextDestroyed()");  //when this linr print

        sce.getServletContext().removeAttribute("con");
    }
}
