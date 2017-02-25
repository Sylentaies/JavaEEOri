
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
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
		<th>Name</th>
		<th>Age</th>
	</tr>
	<%-- 
	<%
		for (User user:userInfo.getUsers()){
			out.println("<tr>");
			out.println("<td>" + user.getName()+ "</td>");
			out.println("<td>" + user.getAge()+ "</td>");
			out.println("</tr>");
		}
	%>
	--%>
	
	<c:forEach var="user" items="${userInfo.users}">
		<tr>
			<td>${user.name}</td>
			<td>${user.age}</td>
		</tr>
	</c:forEach>	
</table>




<%-- <h1 style = "color:Yellow"><%=request.getAttribute("msg") %></h1> --%>




</body>
</html>