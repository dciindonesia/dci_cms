<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
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
  
  
  
    <form:form action="custCommon" method="POST" commandName="companyDto" enctype="multipart/form-data">
    <div id="portfolio">
      <div class="portfolio-item" class="container" style="padding: 110px 10px 10px;">
      	<form:hidden path="companyId" name="companyId" class="hidden" />
        <div class="row" style="background-color: white !important; ">
          <div class="col-md-2" style="padding:20px 40px;">
          	<div>
				<div class='hoverCustomLogo' style='width:110px;height:120px;'>
			       	<p style="position:relative; top:10px;font-size:20px;color:#FFF;left:90px;">
		                	<a href="#" data-toggle="modal" data-target="#myModal2"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
		            </p>
		        </div>
		    <img src="<c:out value="${companyDto.companyImage}" />" style='width:120px;height:120px;'class="img-responsive" alt="">
            </div>
          </div>
          <div class="col-md-8">
            <h2 class="text-info"><c:out value="${companyDto.companyName}" /></h2>
            <p class="text-info">Cloud &amp; IT | Size: <c:out value="${companyDto.companySize}" /> |&nbsp;Followers: <c:out value="${companyDto.companyFollower}" /></p>
            <p class="text-info">Headquarter: <c:out value="${companyDto.companyHQ}" /></p>
          </div>
          <div class="col-md-2">
            <br>
            <br>
            <br>
            <br>
            <br>
            <h2 class="text-info text-right">Follow</h2>
          </div>
        </div>
      </div>
    </div>
    <div class="container" style="padding: 0px 0px 0px;">
      <div class="row">
        <div class="col-md-2" style="padding:">
          <p style="background-color: blue;color: white;" class="well well"><a href="#">Ping! me</a></p>
            <br>
            <br>
            <br>
            <br>
          
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
          <h3 class="text-info">About</h3>
          <c:out value="${companyDto.companyDesc}" />
        </div>
      </div>
    </div>
    <div class="container" style="padding: 10px 10px;">
      <div class="row" style="background-color: white !important; ">
        <div class="col-md-12">
          <h3 class="text-info">Services</h3>
          <p>Secure your business operation in the most reliable data center with global
            operating standard. DCI colocation helps you safeguard your mission-critical
            data with operational excellence, standard compliance and physical security.
            We offer the most aggressive SLA of 99.999% uptime availability or equal
            to not more than 5 minutes downtime tolerance/year in our fault-tolerance
            data center.</p>
        </div>
      </div>
    </div>
  
</form:form>

<form:form action="editCP" method="POST" commandName="companyDtos" enctype="multipart/form-data">
<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">New blog</h4>
      </div>
      <div class="modal-body">
		<form:hidden path="companyId" name="companyId"/>
		<div class="form-group">
			<label for="companyLogo" class="col-sm-2 control-label">Logo</label>
			<div class="col-sm-10">
				<form:input path="companyLogo" name="companyLogo" type="file" cssClass="form-control" />
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
</body></html>