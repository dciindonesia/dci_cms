<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
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
				                <a href="#"><img src="<c:url value="/resources/img/DCI_logo_small.png" />" alt="logo" /></a>
				            </div>
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
            			</div>
            		</div>
            	</div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> Last access : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>   