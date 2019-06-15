<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="resources/css/tasks.css" rel="stylesheet">
</head>
<body>
	<h2>Login Task</h2>
	<form action="getlogin" method="post">
		<h3>Login: </h3> <input type="text" name="login" />
		<br/>
		<h3>Password: </h3><input type="password" name="senha"/>
		<br/><br/>
		<input type="submit" value="Login Tasks">
	</form>
</body>
</html>