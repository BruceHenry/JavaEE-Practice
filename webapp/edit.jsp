<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user?cmd=update" method="POST">
		<input type="text" name="name" value="${sessionScope.name}" required>
		<input type="text" name="age" value="${sessionScope.age}" required>
		<input type="submit" value="Update">
	</form>

</body>
</html>