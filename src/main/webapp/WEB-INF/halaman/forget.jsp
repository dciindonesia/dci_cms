<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html>
<head>
<title>Forget Password</title>
<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/signin.css">
</head>
<body>
	<div class="container">
	<form action="forget" class="form-signin" method="POST" style="padding-top:40px;">
		<h2 class="form-signin-heading">Change Password</h2>
		<label for="sendPass" class="sr-only">username</label>
	    <input name="sendPass" class="input-text-cust form-control" 
	                        	placeholder="Type your username.."  />
	    <br>

	    <button type="submit" class="btn btn-primary btn-lg btn-block">SEND PASSWORD RECOVERY</button>
	</form>
	</div>
</body>
</html>