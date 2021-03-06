<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Template &middot; Bootstrap &middot; Sign In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	   <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" media="screen" />
     <link href="<c:url value="/resources/bootstrap/css/customcss.css" />" rel="stylesheet" media="screen" />
       <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-1.11.3.min.js" />"></script> 
       <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
       
    <!--  <link href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.min.css" />" rel="stylesheet" media="screen" /> -->
	   <title><tiles:insertAttribute name="title" ignore="true" /></title>
    
</head>
<body>

<div id="wrap">
  <div id="containers">      
    
      <div class="row">
          <tiles:insertAttribute name="body" />
      </div><!--/row-->
    
  </div> <!-- containers -->   
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
