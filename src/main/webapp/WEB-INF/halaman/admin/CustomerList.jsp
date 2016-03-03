<%@include file="/WEB-INF/includes/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div id="portfolio" style="padding:20px 0px;">
	<c:forEach items="${companyList}" var="company">
	<div class="row">
		<div class="col-lg-4 portfolio-item">
        	<strong><c:out value="${company.companyName}" /></strong>
        	<img src="<c:url value='${company.companyLogo}' />" class="user-image img-responsive"/>
        </div>
                
        <div class="about-custom col-lg-8">
	        <p><strong><c:out value="${company.companyDesc}" /></strong></p>
	        <a class="btn btn-primary" href="custCommon?companyId=${company.companyId}" type="submit">More about <i class="glyphicon glyphicon-chevron-right"></i><i class="glyphicon glyphicon-chevron-right"></i></a>
        </div>
    </div>
	</c:forEach>
	</div>
</body>
</html>