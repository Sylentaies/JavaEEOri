<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page1</title>
</head>
<body>
<h1>This is Page #1.</h1>
<%
	session.setAttribute("session", "Session Value");
%>
<form action="page2.jsp">
	<input type = "text" name = "message"/>
	<input type = "submit" name = "Submit"/>
</form>

</body>
</html>