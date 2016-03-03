<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html>
<head>
<style type="text/css">

.hoverCustom {
position: absolute;
	width: 100%;
	height: 100%;
	opacity: 0;
	background: rgba(0, 0, 0, .5);
	-webkit-transition: all ease .5s;
	-moz-transition: all ease .5s;
	transition: all ease .5s;
	z-index: 2;
}

.hoverCustom:hover {
	opacity:1;
}
</style>
</head>
<body>
<form:form action="custCommon" method="POST" commandName="companyDto" enctype="multipart/form-data">
<section id="portfolio" style="padding:20px 0px;">
<div class="portfolio-item">
	<form:hidden path="companyId" name="companyId" class="hidden" />
	<div>
		<div class='hoverCustom' style='width:300px;height:250px;'>
	       	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:270px;">
                	<a href="editCP"><i style='color:#FFFFFF;' class="glyphicon glyphicon-pencil" aria-hidden="true"></i></a>
            </p>
        </div>   
        <img src="<c:out value="${companyDto.companyLogo}" />" style='width:300px;height:250px;'class="img-responsive" alt="">
    </div>
       
     
     <br>
     
     <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
            	<span><form:input path="companyName" name="companyName" class="input-text-cust form-control" 
     placeholder="Company Name" /></span>
            </p>
        </div>
     </a>
     
     <br>
     
     <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
            	<span>Cloud & IT Size: 50-200 Followers: 23</span>
            </p>
        </div>
     </a>
     
     <br>
     
     <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
            	<span>Headquarter: Indonesia</span>
            </p>
        </div>
     </a>
     
     <br>
     
      <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
            	<span>Post an update</span>
            </p>
        </div>
     </a>
     <br>
     
     <c:forEach items="${companyDto.contactList}" varStatus="loop">
     	<input id="hiddenContact" class="hidden" name="contactId" type="hidden" value="${contactId}" />
     	${contactList.contactFoto}
		<img src='<c:url value="${contactList.contactFoto}" />' style='width:300px;height:250px;'class="img-responsive" alt="">
     	<br>
     </c:forEach>	
     
      <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
        		<h4>ABOUT</h4>
            	<span><form:input path="companyDesc" name="companyDesc" class="input-text-cust form-control" 
     placeholder="companyDesc" /></span>
            </p>
        </div>
     </a>

	<br>
     
      <a class="portfolio-link" data-toggle="modal" href='#'>
     	<div class='caption'>
        	<div class="caption-custom">
            	<p style="position:relative; top:5px;font-size:20px;color:#FFF;left:220px;">
                	<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </p>
            </div>
        </div>
        <div>
        	<p style='width:300px;height:250px;'class="muted" alt="">
        		<h4>SERVICES</h4>
            	<span><form:input path="companyDesc" name="companyDesc" class="input-text-cust form-control" 
     placeholder="companyDesc" /></span>
            </p>
        </div>
     </a>

	
     
    
         
</div>
</section>
</form:form>
</body>
</html>