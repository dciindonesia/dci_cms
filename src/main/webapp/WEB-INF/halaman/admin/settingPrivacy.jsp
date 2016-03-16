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
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:50px;"><a href="setting"><i class="glyphicon glyphicon-cog" ></i>&nbsp;&nbsp;General</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingCP"><i class="glyphicon glyphicon-user" ></i>&nbsp;&nbsp;Account</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="#"><i class="glyphicon glyphicon-alert" ></i>&nbsp;&nbsp;Privacy</a></li>
		    	</ul>      
		    </div>
		    
		    
		    
		    
		    <div class="col-sm-8" style="padding-top:10%;color:#1F8CD2;">
		    	<div>
			    	<div class='hoverCustomLogo' style='width:110px;height:30px;left:256px'>
							<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:89px;">
								<a href="#" data-toggle="modal" data-target="#modalAccount"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
							</p>
					</div>
					<p>Who can ping! me? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="#">Everyone</a></span></p>					
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
						<label class="col-sm-2 control-label">Full Name</label>
						<div class="col-sm-10">
							tytruythggfbf
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
			    	<div class='hoverCustomLogo' style='width:110px;height:30px;left:256px'>
							<p style="position:relative; top:4px;font-size:20px;color:#FFF;left:89px;">
								<a href="#" data-toggle="modal" data-target="#modalPing"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
							</p>
					</div>
					<p>Who can see my updates &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="#">Followers</a></span></p>
				</div>
		   
		        
			<form:form cssClass="form-horizontal blogForm" >
			<!-- Modal -->
			<div class="modal fade" id="modalPing" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Account Name</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Full Name</label>
						<div class="col-sm-10">
							tytruythggfbf
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