<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
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
