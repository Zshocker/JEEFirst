package com.example.demo1.Controller;

import com.example.demo1.Model.bo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShoppingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= User.VerifieAuthed(request,response);
        if (user != null) {
            request.setAttribute("userName",user.get_name());
            request.getRequestDispatcher( "/Resources/JSP/ShoppingPage.jsp").forward(request,response);
        }

    }


}
