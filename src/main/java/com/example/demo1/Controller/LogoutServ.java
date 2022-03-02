package com.example.demo1.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(false);
        if(session!=null)session.invalidate();
        response.sendRedirect(request.getContextPath() + "/Login");
    }


}
