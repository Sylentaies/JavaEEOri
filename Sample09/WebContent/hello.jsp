<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
	<h2><font color="blue">Sample09: JSP + Struts2 MVC ~ Spring3 ~ Hibernate3.5</font></h2>
	<s:form action="hello" theme="simple">
		<table>
			<tr>
				<td>Name: </td>
				<td><s:textfield name="name" label="Name"/></td>
			</tr>
			<tr>
				<td>Age: </td>
				<td><s:textfield name="age" label="Age"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<s:reset value="Clear"/>
					<s:submit value="Submit"/>
				</td>
			</tr>
		</table>		
	</s:form>
</body>
</html>