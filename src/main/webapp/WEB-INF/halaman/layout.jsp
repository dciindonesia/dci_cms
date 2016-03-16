<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="./resources/bootstrap/css/customcss.css" rel="stylesheet">
    
    <script type="text/javascript" src="./resources/bootstrap/js/jquery-1.11.3.min.js" ></script> 
    <script type="text/javascript" src="./resources/bootstrap/js/bootstrap.min.js"></script>       
    <script type="text/javascript" src="./resources/bootstrap/js/custom.js"></script>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link href="./resources/bootstrap/css/freelancer.css" rel="stylesheet" >
</head>
<body>

<div id="wrap">
	<div class="container">
    	<tiles:insertAttribute name="body" />
    </div>
</div> <!-- wrap -->

<div id="footer">
  <div class="container">
    <tiles:insertAttribute name="footer" />
  </div>
</div>


  <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
  <!--  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script> 
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.0.2/bootstrap.min.js"></script> -->

  
</body>
</html>
