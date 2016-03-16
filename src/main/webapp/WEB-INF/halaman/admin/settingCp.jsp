<%@include file="/WEB-INF/includes/taglibs.jsp" %>

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
		
		.modal-content {
		    background-color: rgba(18, 92, 173, .5);
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
	<script type="text/javascript" src="./resources/bootstrap/js/bootstrap-filestyle.min.js" ></script>
</head>
<body style="background-color:#FFF">
<div class="container" style="margin-top:40px;">

	<div class="panel panel-primary" style="height: 450px; width:95%; background-color:#FFF;">
	
	<div class="panel-heading">
    	<p style="font-size:16px;"class="panel-title"><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;Settings</p>
    </div>
    
    <div class="panel-body">
    	<div class="row">
			<div class="col-lg-4">        
		    	<ul>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:50px;"><a href="setting"><i class="glyphicon glyphicon-cog" ></i>&nbsp;&nbsp;General</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="#"><i class="glyphicon glyphicon-user" ></i>&nbsp;&nbsp;Account</a></li>
		    		<li style="color:#1F8CD2;font-size:16px; padding-top:20px;"><a href="settingPrivacy"><i class="glyphicon glyphicon-alert" ></i>&nbsp;&nbsp;Privacy</a></li>
		    	</ul>      
		    </div>
		    
		    
		    
		    
		    <div class="col-lg-5 col-lg-4-offset" style="padding-top:10%;color:#FFFFFF;">
		    	
			<div class="row">
			<c:forEach items="${contactDtoList}" varStatus="loop">
				<div class="col-lg-4">
					<div>
					<div class='hoverCustomLogo' style='width:120px;height:120px;'>
						<p style="position:relative; top:10px;font-size:20px;color:#FFF;left:100px;">
							<a href="#" data-toggle="modal" data-target="#myModal${loop.index+1}"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
					</div>
					<img src="<c:out value="${contactDtoList[loop.index].contactFoto}" />" style='width:120px;height:120px;border: 1px solid #ddd;'class="img-responsive" alt="">
					</div>
			<form action="editContact" method="POST" commandName="contactPersonDto" enctype="multipart/form-data">		
					<!-- Modal -->
			<div class="modal fade" id="myModal${loop.index+1}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Contact Person Image</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<div class="col-lg-4">
							<input type="hidden" name="contactId" value="${contactDtoList[loop.index].contactId}" />
							<img id="imgResult" src="<c:out value="${contactDtoList[loop.index].contactFoto}" />" style='width:120px;height:120px;border: 1px solid #ddd;'class="img-responsive" alt="">
							
							<input type="file" name="contactImg" class="filestyle imgInp" data-classButton="btn btn-primary" data-input="false" data-classIcon="glyphicon glyphicon-pencil" data-buttonText="">
						</div>
						<div class="col-lg-8">
							<p><input type="text" class="form-control" name="contactName" value="<c:out value="${contactDtoList[loop.index].contactName}"></c:out>" /></p>
							<p><input type="text" class="form-control" name="contactEmail" value="<c:out value="${contactDtoList[loop.index].contactEmail}"></c:out>" /></p>
						</div>
					</div>
					<br><br><br><br><br><br><br><br>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <input type="submit" class="btn btn-primary" value="Save" />
			      </div>
			    </div>
			  </div>
			</div>
			</form>		
					
				</div>
		    </c:forEach>
		    <div class="col-lg-4">
			<a href="#" data-toggle="modal" data-target="#modalAdd">
			<img src="resources/img/addUser.png" style='width:120px;height:120px;border: 1px solid #ddd;'class="img-responsive" alt="">
			</a>
			
			<form action="newContact" method="POST" commandName="contactPersonDto" enctype="multipart/form-data">
			<!-- Modal -->
			<div class="modal fade" id="modalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Image</h4>
			      </div>
			      
			      
			      <div class="modal-body">
					<div class="form-group">
						<div class="col-lg-4">
							<img id="imgNewResult" src='<c:out value="${newContact.contactFoto}" />' style='width:120px;height:120px;border: 1px solid #ddd;'class="img-responsive" alt="">
							<input type="file" name="contactImg" class="filestyle imgNewInp" data-classButton="btn btn-primary" data-input="false" data-classIcon="glyphicon glyphicon-pencil" data-buttonText="">
						</div>
						<div class="col-lg-8">
							<p><input type="text" class="form-control" name="contactName" placeholder="insert contact name..." value="${newContact.contactName}"/></p>
							<p><input type="text" class="form-control" name="contactEmail" placeholder="insert contact email..." value="${newContact.contactEmail}"/></p>
						</div>
					</div>
					<br><br><br><br><br><br><br><br>	
				
			
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <input type="submit" class="btn btn-primary" value="Save" />
			      </div>
			    </div>
			  </div>
			</div>
			</form>		
					
				</div>
		    </div>
			
			<br><br><br><br><br>
			<a href="recent" class="pull-right" style="padding-right:110px;font-size:20px;">Confirm Changes</a>	
			
			</div>
		</div>
    </div>
	
	</div>
	
</div>	
<script type="text/javascript">
$(document).ready(function(){
	$('.imgNewInp').on('change', function() {
		readPath(this);
	});
});
function readPath(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$('#imgNewResult').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

</script>		
</body>
</html>