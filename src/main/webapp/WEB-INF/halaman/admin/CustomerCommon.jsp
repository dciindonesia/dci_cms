<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="./resources/bootstrap/js/bootstrap-filestyle.min.js" ></script>
	<style type="text/css">
		body {
			background-color: #f5f5f5;
		  }
	                                      
	      ul li{
	          display:inline-block;
	          margin-right:20px;
	      }
	      ul ul{
	          padding-left: 0;
	      }
	      ul ul li{
	          display:block;
	          margin:0;
	      }
	      
	      
	      
	     .well {
	     	background-image: linear-gradient(to bottom, #23ADEF 0px, #23ADEF 100%);
	     	height : 125px;
	     } 
	     
	     .well > a {
	     	color : #FFFFFF;
	     }
	     a {
		    text-decoration: none !important;
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

<body>
<input id="hiddenContact" class="hidden" name="contactId" type="hidden" value="${companyDto.companyId}" />
<div>
	<div class="container" style="padding: 110px 10px 10px;">
    	<div class="row" style="background-color: white !important; ">
        	<div class="col-md-2" style="padding:20px 40px;">
				<div>
					<div class='hoverCustomLogo' style='width:120px;height:120px;'>
						<p style="position:relative; top:10px;font-size:20px;color:#FFF;left:100px;">
							<a href="#" data-toggle="modal" data-target="#myModal"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
						</p>
					</div>
					<img src="<c:out value="${companyDto.companyImage}" />" style='width:120px;height:120px;'class="img-responsive" alt="">
				</div>
		   </div> 
		        
			<form:form commandName="companyDto" cssClass="form-horizontal blogForm" enctype="multipart/form-data">
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Image</h4>
			      </div>
			      <div class="modal-body">
					<div class="form-group">
						<label for="companyLogo" class="col-sm-2 control-label">Image</label>
						<div class="col-sm-10">
							<form:input path="companyLogo" type="file" name="logoImg" class="form-control" />
							<form:errors path="companyLogo" />
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
			
			
		<div class="col-md-8">
			<div>
				<div class='hoverCustomLogo' style='width:400px;height:40px;'>
					<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:370px;">
						<a href="#" data-toggle="modal" data-target="#myModal2"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
					</p>
				</div>
				<h2 class="text-info"><c:out value="${companyDto.companyName}" /></h2>
			</div>
			
						<form:form commandName="companyDto" cssClass="form-horizontal blogForm" >
						<!-- Modal -->
						<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						        <h4 class="modal-title" id="myModalLabel">Edit Company Name</h4>
						      </div>
						      <div class="modal-body">
						      
								<div class="form-group">
									<label for="companyName" class="col-sm-2 control-label">Name:</label>
									<div class="col-sm-10">
										<form:input path="companyName" cssClass="form-control" />
										<form:errors path="companyName" />
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
				<div class='hoverCustomLogo' style='width:265px;height:20px;'>
					<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:250px;">
						<a href="#" data-toggle="modal" data-target="#myModalSize"><i style='color:#FFFFFF;font-size:10px;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
					</p>
				</div>
				<p class="text-info">${companyDto.industry} | Size: ${companyDto.companySize} |&nbsp;Followers: ${companyDto.companyFollower}</p>
			</div>
			
			<form:form commandName="companyDto" cssClass="form-horizontal blogForm">
			<!-- Modal -->
			<div class="modal fade" id="myModalSize" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Size</h4>
			      </div>
			      <div class="modal-body">
			      
			      <div class="form-group">
						<label for="companySize" class="col-sm-2 control-label">Industry</label>
						<div class="col-sm-10">
						    <form:select path="industry" name="industry" class="input-text-cust form-control" 
						                        	placeholder="Industry">
								<form:option value="">${companyDto.industry}</form:option>
								<form:options items="${industryList}" itemValue="industryId" itemLabel="industryName" />
							</form:select>	                  
						    <form:errors path="industry" class="label label-danger" />
						</div>
					</div>
			      
					<div class="form-group">
						<label for="companySize" class="col-sm-2 control-label">Size</label>
						<div class="col-sm-10">
							<form:input path="companySize" cssClass="form-control" />
							<form:errors path="companySize" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="companyFollower" class="col-sm-2 control-label">Follower</label>
						<div class="col-sm-10">
							<form:input path="companyFollower" cssClass="form-control" />
							<form:errors path="companyFollower" />
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
				<div class='hoverCustomLogo' style='width:265px;height:20px;'>
					<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:250px;">
						<a href="#" data-toggle="modal" data-target="#myModalHQ"><i style='color:#FFFFFF;font-size:10px;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
					</p>
				</div>
				<p class="text-info">Headquarter: ${companyDto.companyHQ}</p>
			</div>
			
			<form:form commandName="companyDto" cssClass="form-horizontal blogForm">
			<!-- Modal -->
			<div class="modal fade" id="myModalHQ" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Headquarter</h4>
			      </div>
			      <div class="modal-body">
			      
					<div class="form-group">
						<label for="companyHQ" class="col-sm-2 control-label">Headquarter</label>
						<div class="col-sm-10">
							<form:input path="companyHQ" cssClass="form-control" />
							<form:errors path="companyHQ" />
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


			</div>
		<div class="col-md-2">
            <br>
            <br>
            <br>
            <br>
            <br>
            <h2 class="text-info text-right"><a href="#" data-toggle="modal" data-target="#myModalFollow">Follow</a></h2>
            <div class="modal fade" id="myModalFollow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Follower Confirmation</h4>
			      </div>
			      <div class="modal-body">
			      
					<div class="form-group">
						<p class="col-sm-12 control-label"><h2>Congratulations. <br>You have followed this company.</h2></p>
					</div>
					
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <input type="submit" class="btn btn-primary" value="Save" />
			      </div>
			    </div>
			  </div>
			</div>
          </div>
        </div>
      </div>
    </div>

	<div class="container" style="padding: 0px 0px 0px;">
      <div class="row">
        <div class="col-md-2" style="padding:">
          <a href="#" data-toggle="modal" data-target="#modalPost" style="height:120px; width:200px;" class="btn btn-info btn-sm">Post an update</a>
            <!-- Modal -->
			<div class="modal fade" id="modalPost" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Post update</h4>
			      </div>
			      <div class="modal-body">
			      
					<div class="form-group">
						<textarea name="postNews" placeholder="start writing..." style="width:500px; height:300px;" class="col-sm-2 control-label"></textarea>
						
					</div>
					
			      </div>
			      <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			      <div class="modal-footer">
			        <input type="file" class="filestyle" data-classButton="btn btn-primary" data-input="false" data-classIcon="glyphicon glyphicon-pencil" data-buttonText="">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			        <input type="submit" class="btn btn-primary" value="Post" />
			      </div>
			    </div>
			  </div>
			</div>
        </div>
        <div class="col-md-10">
        <ul>
            
        <c:forEach items="${companyDto.contactList}" var="loop">
        <li>
        	<input id="hiddenContact" class="hidden" name="contactId" type="hidden" value="${loop.contactId}" />
            <a href="#" data-toggle="modal" data-target="#myModal">
            	<img class="img-responsive" src="<c:url value="${loop.contactFoto}" />" style="height:120px; width: 130px;">
			</a>
        </li>
     	</c:forEach>
        </ul>

          <!-- Modal -->
          <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-body">
                  <p>Irvin Goffar</p>
                  <p>Technical Consultant</p>
                  <p class="text-primary">
                    <a href="#">Ping!</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container" style="padding: 0px 10px;">
      <div class="row" style="background-color: white !important; ">
        <div class="col-md-12">
          
          
          
          <div>
				<div class='hoverCustomLogo' style='width: 900px; height:35px;'>
					<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:870px;">
						<a href="#" data-toggle="modal" data-target="#myModalDesc"><i style="color:#FFFFFF;" class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
					</p>
				</div>
				<h3 class="text-info">About</h3>
			</div>
			<p class="text-info"><c:out value="${companyDto.companyDesc}" /></p>
			<form:form commandName="companyDto" cssClass="form-horizontal blogForm">
			<!-- Modal -->
			<div class="modal fade" id="myModalDesc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Description</h4>
			      </div>
			      <div class="modal-body">
			      
					<div class="form-group">
						<label for="companyDesc" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-10">
							<form:textarea path="companyDesc" cssClass="form-control" />
							<form:errors path="companyDesc" />
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
          
          
        </div>
      </div>
    </div>
    <div class="container" style="padding: 10px 10px;">
      <div class="row" style="background-color: white !important; ">
        <div class="col-md-12">
          
          <div>
				<div class='hoverCustomLogo' style='width: 900px; height:35px;'>
					<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:870px;">
						<a href="#" data-toggle="modal" data-target="#myModalService"><i style="color:#FFFFFF;" class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
					</p>
				</div>
				<h3 class="text-info">Services</h3>
			</div>
		<p class="text-info"><c:out value="${companyDto.companyService}" /></p>
			<form:form commandName="companyDto" cssClass="form-horizontal blogForm">
			<!-- Modal -->
			<div class="modal fade" id="myModalService" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			        <h4 class="modal-title" id="myModalLabel">Edit Company Service</h4>
			      </div>
			      <div class="modal-body">
			      
					<div class="form-group">
						<label for="companyService" class="col-sm-2 control-label">Services</label>
						<div class="col-sm-10">
							<form:textarea path="companyService" cssClass="form-control" />
							<form:errors path="companyService" />
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
         
        </div>
      </div>
    </div>

</body>
</html>