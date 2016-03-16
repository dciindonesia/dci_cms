<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<style>
	.navbar-inverse {
		background-color: #fff;
	}
	
	.navbar {
	    font-weight: normal;
    }
	
	.li-cust {
		padding-top: 14px;
	}
	
	.navbar-inverse .navbar-nav > li
	> a:focus, .navbar-inverse .navbar-nav > li 
	> a:hover {
		
		color: #4271B7;
	}
	
	.navbar-inverse .navbar-nav > .open > a, .navbar-inverse .navbar-nav > .open > a:focus, .navbar-inverse .navbar-nav > .open > a:hover {
    background-color: #fff;
    }
	
	.navbar-inverse .navbar-nav > li > a {
		color: #fff;
	}
	
	.navbar-nav > li > a {
    	padding-bottom: 19px;
    }
    
    .dropdown-menu {
    	background-color: #5073DA;
    }
    
    .dropdown-menu > li > a {
    	color: #fff;
    }
		
    .form-control::-moz-placeholder {
		color : #fff;
	}
    .head-group {
        padding-top: 21px;
    }
    
    .input-group-addon {
    background-color: #ccc;
    }
    
    .btn-cust {
    	padding-right: 10px;
    	height: 40px;
    }
    
    .btn-search {
		    background:none!important;
		    border:none; 
		    padding:0!important;
		    /*border is optional*/
		    /* border-bottom:1px solid #444; */ 
		    color:#23ADEF;
		    
		    
		}
</style>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0px; background-color: #FFF;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                	 
           </div>
           <div id="timer-wrap" style="margin-top: 5px;">
				    <div id="timer" class="text-center">
				    	<div class="row">
				            <div class="col-xs-3">
				                <a href="recent"><img src="<c:url value="/resources/img/DCI_logo_small.png" />" alt="logo" /></a>
				            </div>
				            
	<div class="col-md-5 head-group">
	<form action="customerSearch" method="POST" role="form" style="width:90%;padding-left:9%">
		<div class="form-group">
	  		<div class="input-group">
	  		
	  			<input type="text" class="form-control" id="findInput" name="searchInput" 
	  				style="background-color:#CCC;color:#fff;" placeholder="Find a company" aria-describedby="start-date">
	        	<span class="input-group-addon" id="start-date">
	        		<button class="btn-search" type="submit">
	        			<span class="glyphicon glyphicon-search" style="color:#FFF;"></span>
	        		</button>
	        	</span>
	    		
	    	</div>
		</div>
	</form>
	</div>
			                    <div class="col-md-4"> 
			                    <ul class="nav navbar-nav navbar-right"> 
			                    <li class="dropdown">
			            			<a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="<c:url value="/resources/img/user.png" />" alt="user" /> <b class="caret"></b></a>
						            <ul class="dropdown-menu" aria-labelledby="drop1">
						              <li><a href="main/list"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;${username}</a></li>
						              <li class="divider" role="separator"></li>
						              <li><a href="setting"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;&nbsp;SETTINGS</a></li>
						              <li class="divider" role="separator"></li>
						              <li><a href="settingTmp"><span class="glyphicon glyphicon-refresh" aria-hidden="true">&nbsp;CONNECTIONS</a></li>
						              <li class="divider" role="separator"></li>
						              <li><a href="#"><span class="glyphicon glyphicon-comment" aria-hidden="true">&nbsp;PING</a></li>
						              <li class="divider" role="separator"></li>
						              <li><a href="<c:url value="/j_spring_security_logout" />" ><span class="glyphicon glyphicon-log-out" aria-hidden="true">&nbsp;LOGOUT</a></li>
						            </ul>
					          	</li>
			                    <li class="li-cust">
			                    <a class="btn btn-info btn-sm btn-cust" role="button" href="#">Ping Someone</a>
			                    </li>
			                    </ul>
			                	</div>
            			</div>
            		</div>
            	</div>
        </nav>   