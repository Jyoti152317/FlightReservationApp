<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>User Login Page</h2>
	<form action="userLogin" method="post">
		<pre>
user name:<input type="text" name="email" />
password:<input type="password" name="password" />
<input type="submit" value="Login" />
</pre>
	</form>
	${msg}
</body>
</html>