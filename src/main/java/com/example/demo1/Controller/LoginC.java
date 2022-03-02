package com.example.demo1.Controller;

import com.example.demo1.Model.bo.User;
import com.example.demo1.Model.dao.DAOUser;
import javax.annotation.security.DeclareRoles;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        String pass=User.HashPass(request.getParameter("pass"),"MD5");
        User user= DAOUser.getDAOUser().Authenticate(log,pass);
        if(user!=null)
        {
            HttpSession session=request.getSession(true);
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath() +"/User/Comment");

        }
        else out.println("<h2>Wrong<h2>");
    }
}
