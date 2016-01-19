<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<style>
	.navbar-inverse {
		background-color: #fff;
	}
	
	.li-cust {
		padding-top: 14px;
	}
	
	.navbar-inverse .navbar-nav > li
	> a:focus, .navbar-inverse .navbar-nav > li 
	> a:hover {
		
		color: blue;
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
    .btn-cust {
    	padding-right: 10px;
    	height: 40px;
    }
</style>
<div class="navbar navbar-inverse navbar-fixed-top headCustom">
    <div id="timer-wrap" style="margin-top: 5px;">
    <div id="timer" class="text-center">
    <div class="row">
            <div class="col-xs-3">
                <a href="#"><img src="<c:url value="/resources/img/DCI_logo_small.png" />" alt="logo" /></a>
            </div>
            
                <form action="../main/customer" class="form-inline"> 
                <div class="col-md-5 head-group">                  
                    <div class="form-group">
                        <input type="text" class="form-control" id="findInput" placeholder="Find a company" style="width:300px;background-color:#CCC;color:#fff;">
                    </div>
                    </div>
                    <div class="col-md-4"> 
                    <ul class="nav navbar-nav navbar-right"> 
                    <li class="dropdown">
            			<a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="<c:url value="/resources/img/user.png" />" alt="user" /> <b class="caret"></b></a>
			            <ul class="dropdown-menu" aria-labelledby="drop1">
			              <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;NEW GUY</a></li>
			              <li class="divider" role="separator"></li>
			              <li><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;&nbsp;SETTINGS</a></li>
			              <li class="divider" role="separator"></li>
			              <li><a href="#"><span class="glyphicon glyphicon-refresh" aria-hidden="true">&nbsp;CONNECTIONS</a></li>
			              <li class="divider" role="separator"></li>
			              <li><a href="#"><span class="glyphicon glyphicon-comment" aria-hidden="true">&nbsp;PING</a></li>
			              <li class="divider" role="separator"></li>
			              <li><a href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true">&nbsp;LOGOUT</a></li>
			            </ul>
		          	</li>
                    <li class="li-cust">
                    <a class="btn btn-info btn-sm btn-cust" role="button" href="#">Ping Someone</a>
                    </li>
                    </ul>
                	</div>
                </form>
            </div><!--/.navbar-collapse -->
        
    </div>
    </div>
</div>