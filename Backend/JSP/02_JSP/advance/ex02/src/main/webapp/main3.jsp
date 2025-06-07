<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main_action</title>
</head>
<body>
<h1>include 액션 태그 실습</h1>
다음 줄에 삽입됩니다.<br>
<jsp:include page="header2.jsp" flush="true">
<jsp:param name="nickname" value="홍길동"/>
</jsp:include>
</body>
</html>
