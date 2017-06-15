<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>name</th>
			<th>price</th>
			<th>num</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${sessionScope.CART_IN_SESSION.items}" var="item"
			varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.num}</td>
				<td><a href="/cart?cmd=delete&id=${item.id}">delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">Total
				Price: ${sessionScope.CART_IN_SESSION.totalPrice}</td>
		</tr>
	</table>
<a href="/cart/product_list.jsp">Continue shopping-></a>
</body>
</html>