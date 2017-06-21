<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>
<body>
	<span style="color: red;">${errorMSG}</span>
	<form action="${PageContext.request.contextPath }/upload3" method="post"
		enctype="multipart/form-data">
		<input type="text" name="username" required /><br> <input
			type="file" name="IMG" required /><br> <input type="submit" />
	</form>

</body>
</html>