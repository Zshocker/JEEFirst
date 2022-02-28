package com.example.demo1.Controller;

import com.example.demo1.Model.bo.User;
import com.example.demo1.Model.dao.DAOUser;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class LoginC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Resources/JSP/LoginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String log=request.getParameter("login");
        String pass=request.getParameter("pass");
        User user= DAOUser.getDAOUser().Authenticate(log,User.HashPass(pass,"MD5"));
        if(user!=null)out.println("<h2>Hello "+user.get_name()+"</h2>");
        else out.println("<h2>Wrong<h2>");
    }
}
