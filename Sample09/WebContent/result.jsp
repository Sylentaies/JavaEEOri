<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h1><font color="blue"><s:property value="message"/></font></h1>
	<table border="1" width="200">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<s:iterator value="users" var="user">
			<tr>
				<td><s:property value="#user.name"/></td>
				<td><s:property value="#user.age"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>