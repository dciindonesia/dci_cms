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

	<div class="panel panel-primary" style="height: 450px; width:95%; background-color:#FFF;">
	
	<div class="panel-heading">
    	<p style="font-size:16px;"class="panel-title"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Settings</p>
    </div>
    
    <div class="panel-body">
    	<div class="row">
			<div class="col-sm-4">        
		    	<ul>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:50px;"><a href="#"><i class="glyphicon glyphicon-cog" ></i>&nbsp;&nbsp;General</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingCP"><i class="glyphicon glyphicon-user" ></i>&nbsp;&nbsp;Account</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingPrivacy"><i class="glyphicon glyphicon-alert" ></i>&nbsp;&nbsp;Privacy</a></li>
		    	</ul>      
		    </div>
		    
		    
		    
		    
		    <div class="col-sm-8" style="padding-top:10%;color:#1F8CD2;">
		    	<div>
			    	<div class='hoverCustomLogo' style='width:330px;height:30px;'>
							<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:300px;">
								<a href="#" data-toggle="modal" data-target="#modalAccount"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
							</p>
					</div>
					<p><i style="font-size:22px;" class="glyphicon glyphicon-user" ></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administrator</p>
				</div>
		   
		        
			<form:form cssClass="form-horizontal blogForm" >
			<!-- Modal -->
			<div class="modal fade" id="modalAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Account Name</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Insert Full Name</label>
						<div class="col-sm-10">
							Administrator
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
			
			<div>
		    	<div class='hoverCustomLogo' style='width:330px;height:30px;'>
						<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:300px;">
							<a href="#" data-toggle="modal" data-target="#modalEmail"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
				</div>
				<p><i style="font-size:22px;" class="glyphicon glyphicon-envelope" ></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;admin@dci-indonesia.com</p>
			</div>
		   
		        
			<form:form cssClass="form-horizontal blogForm" >
			<!-- Modal -->
			<div class="modal fade" id="modalEmail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Email Address</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Insert your Email address</label>
						<div class="col-sm-10">
							admin@dci-indonesia.com
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
			
		    
		    
		    <div>
		    	<div class='hoverCustomLogo' style='width:330px;height:30px;'>
						<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:300px;">
							<a href="#" data-toggle="modal" data-target="#modalPhone"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
				</div>
				<p><i style="font-size:22px;" class="glyphicon glyphicon-phone-alt" ></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;08111111111</p>
			</div>
		   
		        
			<form:form cssClass="form-horizontal blogForm" >
			<!-- Modal -->
			<div class="modal fade" id="modalPhone" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Phone Number</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Phone Number</label>
						<div class="col-sm-10">
							08111111111
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
			
			
			<div>
		    	<div class='hoverCustomLogo' style='width:330px;height:30px;'>
						<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:300px;">
							<a href="#" data-toggle="modal" data-target="#modalPassword"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
				</div>
				<p><i style="font-size:22px;" class="glyphicon glyphicon-lock" ></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change password</p>
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
			      <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Insert your new Password</label>
						<div class="col-sm-10">
							Password
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
			</div>
		</div>
    </div>
	
	</div>
	
</div>			
</body>
</html>