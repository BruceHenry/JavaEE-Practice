<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/cart?cmd=save" method="post">
		<select name="name">
			<option>laptop</option>
			<option>keyboard</option>
			<option>mouse</option>
		</select>
		Quantity:<input type="number" name="num" min="1" required><br />
		<input type="submit" value="Buy">
	</form>

</body>
</html>