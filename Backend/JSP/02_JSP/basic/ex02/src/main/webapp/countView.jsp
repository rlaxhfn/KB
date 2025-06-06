<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count View</title>
</head>
<body>
<h1>방문자 수 조회 화면</h1>
<%int count=(Integer)application.getAttribute("countValue");%>
현재까지 총 방문자 수: <%=count%>
</body>
</html>
