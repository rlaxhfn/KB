<%@ page import="java.util.Calendar"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%String nickname = request.getParameter("nickname");
Calendar calendar = Calendar.getInstance();
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);
%>
안녕하세요. 당신의 닉네임은 <%=nickname%>입니다.<br>
현재 시간은 <%=hour%>시 <%=minute%>분 <%=second%>초입니다.