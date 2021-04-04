package com.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirect-same server-Relative URL
        //1.start without /
        System.out.println("before redirect ");

        response.sendRedirect("/2019211001000720_yuzhenghao_war_exploded/index.jsp"); //url-change to index,jsp
        //http://localhost:8080/2019211001000720_yuzhenghao_war_exploded/index.jsp
        //http://localhost:8080/2019211001000720_yuzhenghao_war_exploded/redirect
        System.out.println("after redirect ");
        //2. start with /

        //response.sendRedirect("/index.jsp");//-??
        // redirect- another server -Absolure URl
        response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request ,response);
    }
}
