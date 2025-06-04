package org.scoula.ex04;

import java.io.*;
import java.text.spi.BreakIteratorProvider;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("username", "홍길동");
        req.setAttribute("useraddress", "서울");

        req.getRequestDispatcher("response.jsp").forward(req, res);
    }
}