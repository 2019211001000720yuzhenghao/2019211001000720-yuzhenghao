package com.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value = "YuZhengHao"),
                @WebInitParam(name="studentId",value = "2019211001000720"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        String id = config.getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("Name:" + name);
        writer.println("studentId:" + id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
