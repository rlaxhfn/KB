<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Info</title>
</head>
<body>
<h1>로그인 정보 보기</h1>
<%String id=(String)session.getAttribute("userid");
if(id==null){response.sendRedirect("loginForm.html");}
else{String pw=(String) session.getAttribute("password");
out.print("사용자 아이디 값: "+id+"<br>");
out.print("사용자 비밀번호 값: "+pw+"<br>");
out.print("<a href=\"logout.jsp\">로그아웃</a>");}%>
</body>
</html>
