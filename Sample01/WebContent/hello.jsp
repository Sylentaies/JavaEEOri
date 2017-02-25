<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
	$(document).ready(function() {
		$("#loginForm").on("submit", validateForm);
		$("#j_name").on("blur", function() {
			$("#userExist").hide();
			$.ajax({
				url: "validation",
				type: "get",
				dataType: "html",
				data: {name: $("#j_name").val()},
				async: false,
				success: function(response) {
					var result = response.toString().trim();
					if (result=="true") {
						$("#userExist").show();
					}
				},
				error: function(msg) {
					alert(msg);
				}
			});
			//alert("Ajax Finished!");
		});
	/* 	var remoteName = $("#remoteName").text();
		var remoteAge = $("#remoteAge").text();
		if (remoteName!= null &&remoteAge!= null){
			$("#j_name").val(remoteName);
			$("#j_age").val(remoteAge);
			$("#loginForm").submit();
		} */
		
		var remoteName = "<c:out value='${param.name}'/>";
		var remoteAge = "<c:out value='${param.age}'/>";
		$("#j_name").val(remoteName);
		$("#j_age").val(remoteAge);
		$("#loginForm").submit();
	});
	function validateForm() {
		$("#nameAndAgeReq").hide();
		$("#nameReq").hide();
		$("#ageReq").hide();
		$("#ageIllegal").hide();
		var name = $("#j_name").val();
		var age = $("#j_age").val();
		if (name.length==0 && age.length==0) {
			$("#nameAndAgeReq").show();
			return false;
		} else if (name.length==0) {
			$("#nameReq").show();
			return false;
		} else if (age.length==0) {
			$("#ageReq").show();
			return false;
		} else if (!($.isNumeric(age) && Math.floor(age)==age)) {
			$("#ageIllegal").show();
			return false;
		} 
		return true;
	}
</script>
<style>
	.alert {
		color: red;
		background: #fdf1e5;
		font-size: 10px;
		line-height: 16px;
		width: 200px;
		margin: 10;
		position: relative;
	}
</style>
</head>
<body>
<h2><font color="green">Sample01: JSP + Servlet + JDBC</font></h2>
<!-- Alerts for missing form info  --> 
<div class="alert" style="display:none;" id="nameAndAgeReq">
	<p>Name and Age are required</p>
</div>
<div class="alert" style="display:none;" id="nameReq">
	<p>Name is required</p>
</div>
<div class="alert" style="display:none;" id="ageReq">
	<p>Age is required</p>
</div>
<div class="alert" style="display:none;" id="ageIllegal">
	<p>Age is NOT an integer</p>
</div>
<div class="alert" style="display:none;" id="userExist">
	<p>The user already exists</p>
</div>
<div style="display:none">
	<p id = "remoteName"><%=request.getParameter("name") %></p>
	<p id = "remoteAge"><%=request.getParameter("age") %></p>
</div>

<!-- Form -->
<form action="HelloServlet" method="post" id="loginForm">
	<table>
		<tr>
			<td>Name: </td>
			<td><input type="text" name="name" id="j_name"/></td>
		</tr>
		<tr>
			<td>Age: </td>
			<td><input type="text" name="age" id="j_age"/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="reset" value="Clear"/>
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</form>
<p id="dummy" style="display:none;"></p>
</body>
</html>