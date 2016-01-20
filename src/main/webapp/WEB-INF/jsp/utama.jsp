<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<title>Main Page</title>
<style>
    
    /* GLOBAL STYLES
-------------------------------------------------- */
    /* Padding below the footer and lighter body text */

	.form-control::-moz-placeholder {
		color : #fff;
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
        margin-bottom: 60px;
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
<div id="timer-wrap" style="margin-top: 40px;"><!-- `class="row"` removed -->
    <div id="timer" class="text-center">
        <div class="row">
            <div class="col-xs-5">
                <a href="#"><img src="<c:url value="/resources/img/DCI_logo.png" />" alt="logo" /></a>
            </div>
            <div class="col-md-7 headernya">
                <form action="../main/recent" class="form-inline">
                    <div class="form-group">
                        <input type="username" class="form-control" id="exampleInputEmail3" placeholder="USERNAME" style="width:300px;background-color:#CCC;color:#fff;">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="exampleInputPassword3" placeholder="PASSWORD" style="width:300px;background-color:#CCC;color:#fff;">
                    </div>
                    <button type="submit" class="btn btn-default btn-lg" style="background-color:#fff; border: none; color:#6FA8DC;padding-left: 4px;font-size: 30px;">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </button>
                </form>
            </div><!--/.navbar-collapse -->
        </div>
    </div>
</div>

<!-- BODY -->        
<div class="container-fluid">
    <div class="row">
        <div class="col-md-5" style="padding-top: 80px;padding-left: 83px;">
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
                    <!--<img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">-->
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">WHAT IS DCI MARKETPLACE?</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">A platform that allows DCI customers to create limitless connections in order to explore each other services that helps expanding their businesses functions.</p>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">DCI Marketplace enables mutual beneficial relationships between its customers within DCI data center ecosystems to reach their full potential</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    <!--<img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">-->
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">HOW TO JOIN</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    <!--<img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">-->
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">BUYER BENEFITS</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-color: #fff;">
                    <!--<img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">-->
                    <div class="container">
                        <div style="color:#0D0E0E;font-size:18px; font-family: arial; background-color: #FFF;">
                            <h4 style="color:#597ED2;">SELLER BENEFITS</h4>
                            <p style="white-space:normal !important; font-size:14px; width: 450px;">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                        </div>
                    </div>
                </div>
            </div>
<!--                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>-->
        </div><!-- /.carousel -->
    </div>
    <div class="col-md-7">
        <div class="col-md-1" style="padding-top: 180px;padding-left: 300px;">
            <a class="navbar-brand" href="../main/form"><img src="<c:url value="/resources/img/hand.png" />" alt="No image" style="width:364px;height:292px;"/></a>
        </div>
        <div class="col-md-6" style="padding-top: 333px;">
            <div style="color:#597ED2;font-size:28px; font-family: sans-serif;">JOIN NOW</div>
                <div style="color:#6FA8DC;font-size:16px; padding-left: 3px;">find out more
                </div>
            </div>
        </div>
    </div>
</div>