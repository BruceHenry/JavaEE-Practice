<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("num", 5);
	%>
	<c:if test="${num==5}" var="a" scope="page">${a}</c:if>
	<br />

	<c:choose>
		<c:when test="${num>5}">大于5</c:when>
		<c:when test="${num<5}">小于5</c:when>
		<c:otherwise>等于5</c:otherwise>
	</c:choose>
	<br />

	<%
		pageContext.setAttribute("a", Arrays.asList("A", "B"));
	%>
	<c:forEach items="${a}" var="e" varStatus="vs">
		${vs.count}:${e}<br />
	</c:forEach>
	<c:forEach begin="1" end="2" var="num">
		${num}<br />
	</c:forEach>
	
	<% pageContext.setAttribute("date", new java.util.Date()); %>
	<h1>${date}</h1>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss"/>
</body>
</html>