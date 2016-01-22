<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<style>
	.user-image {
		height: 150px;
		width: 250px;
	}
</style>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
    	<ul class="nav navbar-nav">
			<li class="active"><a href="#">INDUSTRIES</a></li>
			<li>
	        	<a href="../main/customer"><img src="<c:url value="/resources/img/1.png" />" class="user-image img-responsive"/></a>
			</li>
	        <li>
	        	<a class="active-menu" href="../main/customer"><img src="<c:url value="/resources/img/2.png" />" class="user-image img-responsive"/></a>
	        </li>
	        <li>
	        	<a href="../main/customer"><img src="<c:url value="/resources/img/3.png" />" class="user-image img-responsive"/></a>
	        </li>
	        <li>
	        	<a href="../main/customer"><img src="<c:url value="/resources/img/4.png" />" class="user-image img-responsive"/></a>
	        </li>	
        </ul>               
	</div>
</nav>