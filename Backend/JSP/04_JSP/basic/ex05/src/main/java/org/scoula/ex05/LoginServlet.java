package org.scoula.ex05;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        req.setAttribute("userid", userid);
        req.setAttribute("password", password);
        req.getRequestDispatcher("login.jsp").forward(req, res);
    }
}