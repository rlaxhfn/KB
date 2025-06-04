package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;
    public void init(ServletConfig config) throws ServletException {
        sc=config.getServletContext();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        sc.setAttribute("scopeName", "applicationScope 값"); // application scope

        HttpSession session=req.getSession(); // session scope
        session.setAttribute("scopeName", "sessionScope 값");

        req.setAttribute("scopeName", "requestScope 값"); // request scope
        Member member=new Member("홍길동", "hong");
        req.setAttribute("member", member);

        req.getRequestDispatcher("scope.jsp").forward(req, res);
    }
}
