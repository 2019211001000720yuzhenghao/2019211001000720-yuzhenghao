package com.YuZhenghao.controller;

import com.YuZhenghao.dao.UserDao;
import com.YuZhenghao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String id = request.getParameter("id");
        String Username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        String birthDate=request.getParameter("birthDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = sdf.parse(birthDate);


        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(Username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthDate(date);

        UserDao userDao = new UserDao();


            userDao.updateUser(con,user);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
