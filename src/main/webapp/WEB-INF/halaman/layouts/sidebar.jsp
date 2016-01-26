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
			<li class="active" style="width:250px;text-align:center;font-size:16px;"><a href="#"><strong>INDUSTRIES</strong></a></li>
			<li>
				<div>
		        	<a href="customer"><img src="<c:url value="/resources/img/1.png" />" class="user-image img-responsive"/></a>
		        	<p class="sidebar-floating-text">BANKING & FINANCE</p>
	        	</div>
			</li>
	        <li>
	        	<div>
	        	<a class="active-menu" href="customer"><img src="<c:url value="/resources/img/2.png" />" class="user-image img-responsive"/></a>
	        	<p class="sidebar-floating-text">E-COMMERCE</p>
	        	</div>
	        </li>
	        <li>
	        	<div>
	        	<a href="customer"><img src="<c:url value="/resources/img/3.png" />" class="user-image img-responsive"/></a>
	        	<p class="sidebar-floating-text">CONTENT & DIGITAL MEDIA</p>
	        	</div>
	        </li>
	        <li>
	        	<div>
	        	<a href="customer"><img src="<c:url value="/resources/img/4.png" />" class="user-image img-responsive"/></a>
	        	<p class="sidebar-floating-text">CLOUD & IT</p>
	        	</div>
	        </li>	
        </ul>               
	</div>
</nav>