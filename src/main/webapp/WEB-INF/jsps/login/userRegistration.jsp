<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<h2>User Registration page</h2>
	<%-- ${msg} --%>
<form action="saveReg" method="post">
<pre>
First name:<input type="text" name="firstName"/>
last name:<input type="text" name="lastName"/>
Email:<input type="text" name="email"/>
password:<input type="password" name="password"/>
<!-- confirm password:<input type="text" name="confirmPassword"/> -->
<input type="submit" value="Register"/>
</pre>
</form>
</body>
</html>