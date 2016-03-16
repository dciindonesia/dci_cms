<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html>
<head>
<title>Main Page</title>
<style>
    
    /* GLOBAL STYLES
-------------------------------------------------- */
    /* Padding below the footer and lighter body text */

	.form-control::-moz-placeholder {
		color : #fff;
	}
	
	.form-custom {
		padding-top:40px;
	}


    /* CUSTOMIZE THE NAVBAR
    -------------------------------------------------- */

    /* Special class on .container surrounding .navbar, used for positioning it into place. */
    .navbar-wrapper {
        position: absolute;
        top: 0;
        right: 0;
        left: 0;
        z-index: 20;
    }
    
    .forget-pass {
    	/*color: #4370BD;*/
    	text-shadow: 2px 2px 3px rgba(207, 150, 150, 0.3);
    	padding-right: 120px;
    }

    /* Flip around the padding for proper display in narrow viewports */
    .navbar-wrapper > .container {
        padding-right: 0;
        padding-left: 0;
    }
    .navbar-wrapper .navbar {
        padding-right: 15px;
        padding-left: 15px;
    }
    .navbar-wrapper .navbar .container {
        width: auto;
    }


    /* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */

    /* Carousel base class */
    .carousel {
        height: 350px;
        /*margin-bottom: 60px;*/
    }
    /* Since positioning the image, we need to help out the caption */
    .carousel-caption {
        z-index: 10;
    }

    /* Declare heights because of positioning of img element */
    .carousel .item {
        height: 400px;
        background-color: #777;
    }
    .carousel-inner > .item > img {
        position: absolute;
        top: 0;
        left: 0;
        min-width: 100%;
        height: 400px;
    }


    /* MARKETING CONTENT
    -------------------------------------------------- */

    /* Center align the text within the three columns below the carousel */
    .marketing .col-lg-4 {
        margin-bottom: 20px;
        text-align: center;
    }
    .marketing h2 {
        font-weight: normal;
    }
    .marketing .col-lg-4 p {
        margin-right: 10px;
        margin-left: 10px;
    }


    /* Featurettes
    ------------------------- */

    .featurette-divider {
        margin: 80px 0; /* Space out the Bootstrap <hr> more */
    }

    /* Thin out the marketing headings */
    .featurette-heading {
        font-weight: 300;
        line-height: 1;
        letter-spacing: -1px;
    }
    
    .carousel-control.left, .carousel-control.right{ 
        background: none !important; 
    }
    
    .errorblock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 1px solid #a94442;
		width: 575px;
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		border-radius: 4px;
		position: fixed;
		top: 1px;
		left: 555px;
		transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	}


    /* RESPONSIVE CSS
    -------------------------------------------------- */

    @media (min-width: 768px) {
        /* Navbar positioning foo */
        .navbar-wrapper {
            margin-top: 20px;
        }
        .navbar-wrapper .container {
            padding-right: 15px;
            padding-left: 15px;
        }
        .navbar-wrapper .navbar {
            padding-right: 0;
            padding-left: 0;
        }

        /* The navbar becomes detached from the top, so we round the corners */
        .navbar-wrapper .navbar {
            border-radius: 4px;
        }

        /* Bump up size of carousel content */
        .carousel-caption p {
            margin-bottom: 20px;
            font-size: 21px;
            line-height: 1.4;
        }

        .featurette-heading {
            font-size: 50px;
        }
    }

    @media (min-width: 992px) {
        .featurette-heading {
            margin-top: 120px;
        }
    }
</style>
</head>
<body>
<div id="timer-wrap" style="margin-top: 10px;"><!-- `class="row"` removed -->
    <div id="timer" class="text-center">
        <div class="row">
            <div class="col-xs-4">
                <a href="#"><img src="<c:url value="/resources/img/DCI_logo.png" />" alt="logo" /></a>
            </div>
            <div class="form-custom">
            <div class="col-md-1">&nbsp;
            </div>
            <!--  <div class="col-md-7 headernya"> -->
            	
                <form class="form-inline" name='f' action="<c:url value='j_spring_security_check' />"
					method='POST' action="recent">
					
                    <div class="form-group col-md-3">
                    <input type='username' id='userInputId' name='j_username' value='' class="input-text-cust form-control" 
                    	placeholder="USERNAME" style="width:100%; background-color:#CCC; color:#fff;" required autofocus>
                    <br>
                    <c:if test="${not empty error}">
						<span class="label label-danger">
							The login information you entered was incorrect
						</span>
					</c:if>
                    </div>
                    
                    <div class="form-group col-md-3">
                        <input type='password' id='passwordInputId' name='j_password' class="input-text-cust form-control" 
                        	placeholder="PASSWORD" style="width:100%; background-color:#CCC; color:#fff;"  required>           
                    </div>
                    <div class="col-md-1">
                    <button type="submit" style="background-color:#fff; border: none; color:#6FA8DC;padding-left: 4px;font-size: 30px;">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </button>
                    </div>
                	<a href="forget" class="pull-right forget-pass">Forget Password?</a><span class="clearfix"></span>
                	
                </form>
                </div>
            <!-- </div> /.col-md-7 -->
        </div>
    </div>
</div>
<div class="page-header" style="margin-top:0px;"></div>	
<!-- BODY -->        
<!--  <div class="container" > -->
    <div class="row" style="padding-top:40px;margin-bottom:-100px;">
        <div class="col-lg-6">
        <!-- Carousel ================================================== -->
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators" style="bottom: 121px;left: 50px;">
                <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#6FA8DC;"></li>
                <li data-target="#myCarousel" data-slide-to="1" style="background-color:#6FA8DC;"></li>
                <li data-target="#myCarousel" data-slide-to="2" style="background-color:#6FA8DC;"></li>
                <li data-target="#myCarousel" data-slide-to="3" style="background-color:#6FA8DC;"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active" style="background-color: #fff;">
                    
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">WHAT IS DCI MARKETPLACE?</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">A platform that allows DCI customers to create limitless connections in order to explore each other services that helps expanding their businesses functions.</p>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">DCI Marketplace enables mutual beneficial relationships between its customers within DCI data center ecosystems to reach their full potential</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">HOW TO JOIN</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">BUYER BENEFITS</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">SELLER BENEFITS</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.carousel -->
    </div>
    <div class="col-lg-6">
    
        	<img src="<c:url value="/resources/img/hand.png" />" alt="hand" class="visible-lg" style="position:relative; top:70px; left:232px;width:400px;height:350px;z-index:-1"/>
        	<a href="form" style="position:absolute; top:290px; left:232px;color:#1072BB;width:500px; font-size:2.5em;">JOIN NOW</a>
     		<a href="form" style="position:absolute; top:330px; left:232px;color:#5ACBFC; font-size:1.5em;">find out more</a>  	
   </div>
		
	
</div><!-- ./container -->
<!--  </div> --> <!-- ./page-header -->
</body>
</html>