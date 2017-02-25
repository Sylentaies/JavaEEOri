
<!DOCTYPE html>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body>
<%@page import= "com.mercury.beans.User" %>
<jsp:useBean id = "userInfo" scope = "request" class = "com.mercury.beans.UserInfo"/>
<h1 style = "color:blue"><jsp:getProperty name="userInfo" property="msg"/></h1>
<table style= "width:200px" border="1">
	<tr>
		<th><bean:message key ="user.name"/></th>
		<th><bean:message key ="user.age"/></th>
	</tr>
	<logic:iterate id="user" name="userInfo" property="users" type="com.mercury.beans.User" scope="request">
	        <tr>
	        	<td><bean:write name="user" property="name"/></td>
	        	<td><bean:write name="user" property="age"/></td>
	        </tr>
	</logic:iterate>
	
</table>




<%-- <h1 style = "color:Yellow"><%=request.getAttribute("msg") %></h1> --%>




</body>
</html>