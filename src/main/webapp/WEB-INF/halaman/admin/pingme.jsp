<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<html>
<head>
	<script type="text/javascript" src="./resources/bootstrap/js/bootstrap-filestyle.min.js" ></script>
	<style type="text/css">
		#editor {overflow:scroll; max-height:300px}	
		.panel-primary { border-color: 1px solid rgba(0, 0, 0, 0.2); /* #337ab7; */}
		.panel-body {padding: 0;}
		ul{ list-style-type: none;}
		p {font-size:11px;}
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
		.row-dci{
			padding:10px;
		}
	</style>
	
</head>


<body style="background-color:#FFF">
<div class="container" style="margin-top:40px;">

	<div class="panel panel-primary" style="height: auto; width:95%; background-color:#FFF;">
	
	<div class="panel-heading">
    	<p style="font-size:16px;"class="panel-title"><i class="glyphicon glyphicon-comment"></i>&nbsp;&nbsp;Ping!</p>
    </div>
    
    <div class="panel-body" style="color:#125CAD;padding:10px">
    	<div class="row">
			<div class="col-lg-5" style="padding-left:20px;">   
			     
		   	<div class="row row-dci">		   	
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#E3F0F8;">
		   			
		   			<p class="hostp">I am just wondering if you do a bundling price. How much does it cost?</p>
		   		</div>
		   	</div>
		   	<div class="row row-dci">
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#E3F0F8;">
		   			<p class="hostp">Hi Boss, I woud like to request a smart hands tape backup on weekly basis. I am just wondering if you do a bundling price. How much does it cost?</p>
		   		</div>
		   	</div>
		   	<div class="row row-dci">
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#E3F0F8;">
		   			<p class="hostp">Would you be able to ring me af- ter my meeting at 2?</p>
		   		</div>
		   	</div>
		   	<div class="row row-dci">
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#E3F0F8;">
		   			<p class="hostp">Hi Boss, I woud like to request a smart hands tape backup on weekly basis. I am just wondering if you do a bundling price. How much does it cost?</p>
		   		</div>
		   	</div> 	 
		    
		    </div>
		    
		    <div class="col-lg-6" style="background-color:#E3F0F8;margin-left:20px;">
		    <div class="row row-dci" >
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#CBE2F1;">
		   			<div class="row">
		   			<div class="col-lg-10">
		   			
		   			<p>Hi Boss, I woud like to request a smart hands tape backup on weekly basis.
		   			I am just wondering if you do a bundling price. How much does it cost?</p>
		   			</div>
		   			<div class="col-lg-2">
		   			<p style="position:absolute; top:0px; left:15%;">Friday 19/2</p>
		   			<p style="position:absolute; top:15px; left:15%;">5:16 PM</p>
		   			</div>
		   			</div>
		   		</div>
		   	</div>
		   	<div class="row row-dci" >
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#CBE2F1;">
		   			<div class="row">
		   			<div class="col-lg-10">
		   			
		   			<p>Hi Boss, I woud like to request a smart hands tape backup on weekly basis.
		   			I am just wondering if you do a bundling price. How much does it cost?</p>
		   			</div>
		   			<div class="col-lg-2">
		   			<p style="position:absolute; top:0px; left:15%;">Friday 19/2</p>
		   			<p style="position:absolute; top:15px; left:15%;">5:16 PM</p>
		   			</div>
		   			</div>
		   		</div>
		   	</div>
		   	<div class="row row-dci" >
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#CBE2F1;">
		   			<div class="row">
		   			<div class="col-lg-10">
		   			
		   			<p>Sure. I will send you the data sheet.</p>
		   			</div>
		   			<div class="col-lg-2">
		   			<p style="position:absolute; top:0px; left:15%;">Friday 19/2</p>
		   			<p style="position:absolute; top:15px; left:15%;">5:16 PM</p>
		   			</div>
		   			</div>
		   		</div>
		   	</div>
		   	<div class="row row-dci" >
		   		<div class="col-lg-2" style="padding-top:3px;">
		   			<img src="<c:url value="/resources/img/user.png" />" alt="logo" style="width:50px;height:50px;"/>
		   		</div>
		   		<div class="col-lg-10" style="background-color:#CBE2F1;">
		   			<div class="row">
		   			<div class="col-lg-10">
		   			
		   			<p>Please let me know what you think or you can just ping me for any further question.</p>
		   			</div>
		   			<div class="col-lg-2">
		   			<p style="position:absolute; top:0px; left:15%;">Friday 19/2</p>
		   			<p style="position:absolute; top:15px; left:15%;">5:16 PM</p>
		   			</div>
		   			</div>
		   		</div>
		   	</div>
		   	
		   	<div class="row row-dci" >
		   		
		   		<div class="col-lg-12" style="background-color:#125CAD;">
		   			<textarea name="postNews" placeholder="start writing..." style="width:500px; height:100px;margin:15px 0;background-color:#125CAD;color:#FFFFFF;" class="col-sm-2 control-label"></textarea>
		   			<p><input type="file" class="filestyle" data-classButton="btn btn-primary" data-input="false" data-classIcon="glyphicon glyphicon-pencil" data-buttonText="">
		   			<span><input type="submit" class="btn btn-primary" value="Send" /></span></p>
		   		</div>
		   	</div>
		   	
		   	
			</div>
			
		</div>
    </div>
	
	</div>
	
</div>			
	
</body>
</html>