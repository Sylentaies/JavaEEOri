
<!DOCTYPE html >
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Demo</title>
<style>
	h2 {
		color: green;
		text-shadow : 5px 5px 5px #00FF0A;
	}
	.round{
		border-radius : 10px;
	}
</style>
</head>
<body>
<h2>This is a JSP Demo</h2>

<html:form action="/hello">
	<table>
	     <tr>
			<td><bean:message key="user.name"/>:</td>
			<td><html:text property="name" value=""/></td>
    	 </tr>
	     <tr>
			<td><bean:message key="user.age"/>:</td>
			<td><html:text property="age" value=""/></td>
	     </tr>
	     <tr>
			<td></td>
			<td> 
				<html:reset value="Clear"/>
				<html:submit value="Submit"/>
			</td>
	     </tr>
	</table>
</html:form>


</body>
</html>