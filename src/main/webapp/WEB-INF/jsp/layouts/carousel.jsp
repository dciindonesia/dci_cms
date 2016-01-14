<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<style type="text/css">
  .carousel-caption {
    background: none repeat scroll 0 0 rgba(0, 85, 204, 0.75); /*#0055CC;*/
  }
</style>
<!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <c:url var="imageUrl1" value="/resources/bootstrap/img/slide-01.jpg" />
          <img src="${imageUrl1}" alt="sriboga1">
          <div class="container">
            <div class="carousel-caption">
              <h1>Diversifikasi</h1>
              <p class="lead">Ragam Produk Tepung Terigu Unggulan</p>
             
            </div>
          </div>
        </div>
        <div class="item">
          <c:url var="imageUrl2" value="/resources/bootstrap/img/slide-02.jpg" />
          <img src="${imageUrl2}" alt="sriboga2">
          <div class="container">
            <div class="carousel-caption">
              <h1>High Technology</h1>
              <p class="lead">Teknologi Sriboga Bantu Anda Meraih Untung.</p>
              
            </div>
          </div>
        </div>
        <div class="item">
          <c:url var="imageUrl3" value="/resources/bootstrap/img/slide-03.jpg" />
          <img src="${imageUrl3}" alt="sriboga3">
          <div class="container">
            <div class="carousel-caption">
              <h1>Certified</h1>
              <p class="lead">Bahan Baku Kunci Jaminan Mutu.</p>
              
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->