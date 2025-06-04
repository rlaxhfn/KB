<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirect</title>
</head>
<body>
username 값: <%=request.getAttribute("username")%><br>
useraddress 값: <%=request.getAttribute("useraddress")%><br>
<%--setRedirect를 사용했기 때문에. 새 요청에는 username과 useraddress가 존재 X--%>
</body>
</html>
