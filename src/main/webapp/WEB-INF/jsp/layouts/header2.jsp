<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<style type="text/css">

  .navbar .brand {
    color: #FFFFFF;
  }

  .navbar .nav > li > a {
    color: #ffffff;
  }

  .navbar .nav .active > a, .navbar .nav .active > a:hover {
   /*background-color: #ffe9a4;*/
   height: 22px;
  }

  .navbar-inner {

    color: #ffffff;
    min-height: 40px;
    padding-right: 20px;
    padding-left: 20px;
    background-color: #0074cc;
    background-image: -moz-linear-gradient(top, #0088cc, #0055cc);
    background-image: -ms-linear-gradient(top, #0088cc, #0055cc);
    background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0055cc));
    background-image: -webkit-linear-gradient(top, #0088cc, #0055cc);
    background-image: -o-linear-gradient(top, #0088cc, #0055cc);
    background-image: linear-gradient(top, #0088cc, #0055cc);
    background-repeat: repeat-x;
    -webkit-border-radius: 4px;
       -moz-border-radius: 4px;
            border-radius: 4px;
    filter: progid:dximagetransform.microsoft.gradient(startColorstr='#333333', endColorstr='#222222', GradientType=0);
    -webkit-box-shadow: 0 1px 3px rgba(0, 85, 204, 0.25), inset 0 -1px 0 rgba(0, 85, 204, 0.1);
       -moz-box-shadow: 0 1px 3px rgba(0, 85, 204, 0.25), inset 0 -1px 0 rgba(0, 85, 204, 0.1);
            box-shadow: 0 1px 3px rgba(0, 85, 204, 0.25), inset 0 -1px 0 rgba(0, 85, 204, 0.1);
  }

</style>

        <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
        <div class="container">
          
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="brand" href="/www.sriboga-flourmill.com">
            
          <img class="img-circle" src="<c:url value="/resources/img/dci_logo.jpeg" />" alt="PT.DCI Indonesia" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PT.DCI Indonesia
            </a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
            <div class="navbar-text pull-right">
              <c:if test="${!empty username}">
              Logged in as : <a href="#" class="navbar-link">${username}</a> <!-- ${userDetails.username} -->
              </c:if>
            </div>  

              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="../main/defaults">About</a></li>
                <li><a href="../main/common">Contact Us</a></li>
                <!-- Read about Bootstrap dropdowns at http://twitter.github.com/bootstrap/javascript.html#dropdowns -->
                <li><a href="../main/customer">Customer</a></li>
                <c:if test="${!empty username}">
                <li>
                  <c:url value="/j_spring_security_logout" var="logoutUrl" />
                  <a href="${logoutUrl}">Log Out</a>
                </li>
                </c:if>
              </ul>
              
            <!-- </div> --> <!-- /.navbar-text pull-right -->
            </div><!--/.nav-collapse -->
          
          </div> <!-- /.container -->
        </div><!-- /.navbar-inner -->
        </div><!-- /.navbar-inverse -->