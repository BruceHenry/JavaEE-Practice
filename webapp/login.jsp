<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//session.invalidate();
	%>
	<p style="color: red;">${requestScope.errorMsg}</p>
	<form action="${PageContext.request.contextPath }/login" method="post">
		<input type="hidden" name="token" value="${token}"/> <input
			type="text" name="name" required placeholder="username" /><br /> <input
			type="text" name="password" required placeholder="password" /><br />
		<input type="text" name="randomcode" size="5" maxlength="5" required />
		<img id="randomcodeIMG" src="/randomcode" title="Another One"
			onclick="change();" style="cursor: pointer;" /><br /> <input
			type="submit" value="Login" />
	</form>

	<script type="text/javascript">
		function change() {
			var img = document.getElementById("randomcodeIMG");
			img.src = "/randomcode?" + new Date().getTime();
		}
	</script>

</body>
</html>