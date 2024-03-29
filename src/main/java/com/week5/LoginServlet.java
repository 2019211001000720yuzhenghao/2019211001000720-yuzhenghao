package com.week5;

import com.YuZhenghao.dao.UserDao;
import com.YuZhenghao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
//                if(!(request.getParameter("rememberMe") == null || request.getParameter("rememberMe").length() == 0)){
                if(!(request.getParameter("rememberMe") == null || request.getParameter("rememberMe").length() == 0)){
                    String rememberMe = request.getParameter("rememberMe");

                    if(rememberMe!=null && rememberMe.equals("1")){
                        Cookie usernameCookies=new Cookie("cUsername",user.getUsername());
                        Cookie passwordCookies=new Cookie("cPassword",user.getPassword());
                        Cookie rememberMeCookies=new Cookie("cRememberMe",rememberMe);
                        usernameCookies.setMaxAge(5);
                        passwordCookies.setMaxAge(5);
                        rememberMeCookies.setMaxAge(5);
                        response.addCookie(usernameCookies);
                        response.addCookie(passwordCookies);
                        response.addCookie(rememberMeCookies);
                    }
                }

                HttpSession session = request.getSession();

                System.out.println("session id-->"+session.getId());

                session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","username or password Error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>Login</title></head>");
        out.println("<body>");
        /*String sql="select * from Usertable where username=? and password=?";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs= pstmt.executeQuery();
            if(rs.next()){
//                out.println("Login Success!!!");
//                out.println("Welcome,"+username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else {
//                out.println("Login Error!!!");
                request.setAttribute("message","username or password Error");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */
    }

}