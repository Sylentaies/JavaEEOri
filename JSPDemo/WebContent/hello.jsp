
<!DOCTYPE html >
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
<%-- <%@include file="page1.jsp" %> --%>
<h2>This is a JSP Demo</h2>
<form action = "HelloServlet" method = "post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type= "text" name="name"></td>
		
		</tr>
		<tr>
			<td>Age:</td>
			<td><input type = "text" name = "age"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input class = "round" type = "reset" value = "Clear"/>
				<input class = "round" type = "submit" value = "Submit"/>
			</td>
		</tr>	
	</table>
</form>
</body>
</html>