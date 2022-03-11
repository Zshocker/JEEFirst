package com.example.demo1.Controller;

import com.example.demo1.Model.bo.User;
import com.example.demo1.Model.dao.DAOLivre;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShowPanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= User.VerifieAuthed(request,response);
        if (user != null) {
            request.setAttribute("userName",user.get_name());
            request.setAttribute("comment",request.getParameter("comment"));
            request.getRequestDispatcher( "/Resources/JSP/ShowPanier.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= User.VerifieAuthed(req,resp);
        if (user != null)
        {
            String[] values=req.getParameterValues("livres[]");
            for (String id : values)
            {
                user.getPanier().AddLivre(DAOLivre.getInstance().findByid(Integer.parseInt(id)));
            }
            req.getRequestDispatcher( "/Resources/JSP/ShowPanier.jsp").forward(req,resp);
        }
    }
}
