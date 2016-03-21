<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		
		.panel-primary {
		    border-color: 1px solid rgba(0, 0, 0, 0.2); /* #337ab7; */
		}
		
		.panel-body {
		    padding: 0;
		}
		
		ul
		{
		    list-style-type: none;
		}
		
		p {
			font-size:18px;
		}
		
		.hoverCustomLogo {
			position: absolute;
			width: 100px;
			height: 100px;
			opacity: 0;
			background: rgba(0, 0, 0, .5);
			-webkit-transition: all ease .5s;
			-moz-transition: all ease .5s;
			transition: all ease .5s;
			z-index: 2;
		}
		
		.hoverCustomLogo:hover {
			opacity:1;
		}
	</style>
</head>
<body style="background-color:#FFF">
<div class="container" style="margin-top:40px;">

	<div class="panel panel-primary" style="height: 510px; width:95%; background-color:#FFF;">
	
	<div class="panel-heading">
    	<p style="font-size:16px;"class="panel-title"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Settings</p>
    </div>
    
    <div class="panel-body">
    	<div class="row">
			<div class="col-lg-3">        
		    	<ul>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:50px;"><a href="#"><i class="glyphicon glyphicon-cog" ></i>&nbsp;&nbsp;General</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingCP"><i class="glyphicon glyphicon-user" ></i>&nbsp;&nbsp;Account</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingPrivacy"><i class="glyphicon glyphicon-alert" ></i>&nbsp;&nbsp;Privacy</a></li>
		    	</ul>      
		    </div>
		    
		    
		    
		    
		    <div class="col-lg-6 col-lg-3-offset" style="padding-top:10%;color:#1F8CD2;">
		    <form action="setting" method="POST" commandName="users">
		    	<input type="hidden" name="userId" value="${users.userId }" class="hidden">
		    	<div class="input-group">
					  <span class="input-group-addon" id="basic-addon1" style="background-color:#FFF">
					  	<i style="font-size:22px;color:#1F8CD2;" class="glyphicon glyphicon-user" ></i>
					  </span>
					  <input type="text" name="name" value="${users.name }"class="form-control" placeholder="Username" aria-describedby="basic-addon1">
				</div>
				<br>
				<div class="input-group">
					  <span class="input-group-addon" id="basic-addon2" style="background-color:#FFF">
					  	<i style="font-size:22px;color:#1F8CD2;" class="glyphicon glyphicon-envelope" ></i>
					  </span>
					  <input type="text" name="email" value="${users.email }"class="form-control" placeholder="Email" aria-describedby="basic-addon2" disabled="true">
				</div>
				<br>
		    	<div class="input-group">
					  <span class="input-group-addon" id="basic-addon3" style="background-color:#FFF">
					  	<i style="font-size:22px;color:#1F8CD2;" class="glyphicon glyphicon-phone-alt" ></i>
					  </span>
					  <input type="text" value="08111111111" class="form-control" placeholder="Phone" aria-describedby="basic-addon3">
				</div>
		    	<br>
			<div>
		    	<div class='hoverCustomLogo' style='width:240px;height:30px;'>
						<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:215px;">
							<a href="#" data-toggle="modal" data-target="#modalPassword"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
				</div>
				<p style="padding-left:12px;"><i style="font-size:22px;" class="glyphicon glyphicon-lock" ></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change password</p>
			</div>
		   
		        
			<form:form cssClass="form-horizontal blogForm" >
			<!-- Modal -->
			<div class="modal fade" id="modalPassword" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Change Password</h4>
			      </div>
			      <div class="modal-body" style="height:195px;">
					<div class="form-group">
						
						<div class="col-sm-10">
							<input type="text" class="input-text-cust form-control" placeholder="old password" />
							<hr>
							<input type="text" class="input-text-cust form-control" placeholder="new password" />
							<br>
							<input type="text" class="input-text-cust form-control" placeholder="confirm new password" />
						</div>
					</div>
			
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <input type="submit" class="btn btn-primary" value="Save" />
			      </div>
			    </div>
			  </div>
			</div>
			</form:form>
			
			
			
			
			
			<br><br><br><br><br>
			<a href="recent" class="pull-right" style="padding-right:110px;font-size:20px;">Confirm Changes</a>	
			
			</form>
			</div>
			
		</div>
    </div>
	
	</div>
	
</div>			
</body>
</html>