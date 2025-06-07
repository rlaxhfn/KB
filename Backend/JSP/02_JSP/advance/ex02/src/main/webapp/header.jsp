<%@ page import="java.util.Calendar"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% Calendar calendar = Calendar.getInstance();
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);
%>
현재 시간은 <%=hour%>시 <%=minute%>분 <%=second%>초입니다.