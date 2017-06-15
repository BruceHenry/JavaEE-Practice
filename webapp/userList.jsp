<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Welcome ${sessionScope.USER_IN_SESSION.name}</p>
	<table>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Operation</th>
		</tr>

		<c:forEach items="${sessionScope.list}" var="result">
			<tr>
				<td>${result.name}</td>
				<td>${result.age}</td>
				<td><a href='${pageContext.request.contextPath}/user?cmd=delete&name=${result.name}'>Delete</a>\
				<a href='${pageContext.request.contextPath}/user?cmd=edit&name=${result.name}&age=${result.age}'>Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<form action="${pageContext.request.contextPath}/user?cmd=add" method="POST">
		<input type="text" name="name" required>
		<input type="text" name="age" required>
		<input type="text" name="password" required>
        <input type="submit" value="ADD">
	</form>

</body>
</html>