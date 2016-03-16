<%@include file="/WEB-INF/includes/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		a {
			text-decoration: none;
		}
	</style>
</head>
<body>
<div id="portfolioCustom" style="padding:20px 0px;">
	<div class="row" style="font-size:12px;color:#3779BC;">
		<div class="col-lg-2 portfolio-item">
			51 Results
			</div>
			<div class="col-lg-2 portfolio-item"> 
			<div class="dropdown">		
			
			Sort by: <a href="#" style="background-color:#E3E3E3" id="menu1" data-toggle="dropdown">&nbsp;&nbsp;&nbsp;&nbsp;....&nbsp;&nbsp;&nbsp;&nbsp;</a>
			
			  <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" style="z-index:2">
			    <li role="presentation"><a style="font-size:10px;" role="menuitem" href="#">Industry</a></li>
			    <li role="presentation" class="divider"></li>
			    <li role="presentation"><a style="font-size:10px;" role="menuitem" href="#">A to Z</a></li>
			    <li role="presentation"><a style="font-size:10px;" role="menuitem" href="#">Z to A</a></li>
			  </ul>
			  </div>
			</div>
			<div class="col-lg-2 portfolio-item">
			
			<a href="customerList">Clear all</a>
			</div>
			
			<div class="col-lg-8-offset portfolio-item"></div>
			
	</div><br><br><br>
	
	<c:forEach items="${companyList}" var="company">
	<div class="row" style="background-color: white !important; ">
	
		<div class="col-lg-3 portfolio-item">
        	<a href="custCommon?companyId=${company.companyId}" type="submit"><img src="<c:url value='${company.companyLogo}' />" class="user-image img-responsive" style="height:150px; width:150px;padding-top:20px;"/></a>
        </div>
                
        <div class="about-custom col-lg-9">
	        <div class="row">
	        	<div class="about-custom col-lg-3">
        			<h2><a href="custCommon?companyId=${company.companyId}" type="submit"><strong><c:out value="${company.companyName}" /></strong></a></h2>
	        	</div>
	        	<div class="about-custom col-lg-1">
	        		<p style="font-size:37px;">|</p>
	        	</div>
	        	<div class="about-custom col-lg-8" style="top:17px; line-height:14px;">
	        		<div style="font-size:10px;">${company.industry.industryName }</div>
	        		<p style="font-size:10px;color:#4CBFF7;">Size:<c:out value="${company.companySize}" /></p>
	        	</div>
	        </div>
	        <p style="font-size:11px;"><c:out value="${company.companyDesc}" /></p>
        </div>
        
    </div>
    <br><br><br>
	</c:forEach>

</div>
</body>
</html>