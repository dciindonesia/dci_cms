<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html>
<head>
	<style type="text/css">
		button {
		    background:none!important;
		    border:none; 
		    padding:0!important;
		    /*border is optional*/
		    /* border-bottom:1px solid #444; */ 
		    color:#23ADEF;
		    
		}
		
		.jumbotron p {
    		font-size: 14px;
    	}
	</style>
</head>
<body style="background-color:#FFF">
	<div class="container" style="margin-top:40px;">
		<div class="jumbotron" style="height: 400px; width:90%; background-color:#FFF;">
			<div class="row">
			<div class="col-lg-6" style="padding-top:5%;">
			<form id="form1" action="forget" method="POST">
				
				<p style="font-size:2em;color:#1072BB;">Having trouble signing in?</p>
				<br>
				<p style="font-size:14px;">Please simply enter your registered email address, we will assist you to reset your password</p>
				
				<label for="sendPass" class="sr-only">username</label>
			    <input name="sendPass" class="input-text-cust form-control" 
			                        	placeholder="Type your username.."  />
			    
				<c:if test="${not empty errorMsg}">
					<br>
					<p class="label label-danger">
						${errorMsg}
					</p>
					<br>
				</c:if>
			    <br>
			    
						<button type="submit" style="font-size:20px;" class="pull-right">Proceed</button>
				
				</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>