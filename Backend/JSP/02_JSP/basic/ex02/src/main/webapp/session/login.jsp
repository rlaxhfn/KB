<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>로그인 정보 세션 저장</h1>
<% String id=request.getParameter("userid");
if(id==null){response.sendRedirect("loginForm.html");}
else {String pw=request.getParameter("password");
session.setAttribute("userid",id);
session.setAttribute("password",pw);
out.print("안녕하세요. "+id+"<br>");
out.print("<a href=\"loginInfo.jsp\">정보 보기</a>");} %>
</body>
