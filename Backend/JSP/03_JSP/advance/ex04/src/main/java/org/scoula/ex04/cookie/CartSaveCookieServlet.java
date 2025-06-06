package org.scoula.ex04.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String product = request.getParameter("product");
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies == null || cookies.length == 0) {
            cookie = new Cookie("product", product);
        } else {
            cookie = new Cookie("product" + (cookies.length+1), product);
        }
        response.addCookie(cookie);
        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href=\"cookie_product.jsp\">상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a>");
        out.print("</body></html>");
    }
}
