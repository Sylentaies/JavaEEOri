<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
	$(document).ready(function(){
		$("#btn").click(function(){
			$.ajax({
				url: "message.html",
				type: "get",
				datatype: "html",
				success: function(response){
					$("#para").html(response);
				}
			});
		});
	});
</script>
</head>
<body>
<h1>This is a main page</h1>
<br />
<p id = "para">No message</p>
<br />
<button id ="btn">Get Message</button>
</body>
</html>