<style type="text/css">
        html,
body {
  height: 100%;
}
.carousel {
  width: 90%;
  background-color: #000;
  height: 100%;
  margin-left:75px;
  margin-right:75px;
  
}

.carousel-fade .carousel-inner .next,
.carousel-fade .carousel-inner .prev,
.carousel-fade .carousel-inner .active.left,
.carousel-fade .carousel-inner .active.right {
  left: 0;
  -webkit-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
}
.carousel,
.carousel-inner,
.carousel-inner .item {
  height: 100%;
}

.slide-content {
  color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  min-height: 100%;
}
.slide-content video {
  position: absolute;
  top: 50%;
  left: 50%;
  min-width: 100%;
  min-height: 100%;
  width: auto;
  height: auto;
  z-index: 0;
  -webkit-transform: translateX(-50%) translateY(-50%);
  transform: translateX(-50%) translateY(-50%);
  -webkit-transition: 1s opacity;
  transition: 1s opacity;
}
.slide-content video::-webkit-media-controls-start-playback-button {
  display: none !important;
  -webkit-appearance: none;
}
.door {
  font-family: Revista-Black;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  height: 100%;
  width: 100%;
  z-index: 1;
}
.door .title {
  font-size: 14rem;
  text-transform: uppercase;
  letter-spacing: 0.3rem;
  line-height: 13rem;
}
.door .description {
  border-top: 1px solid #fff;
  margin-top: 15px;
  font-size: 4rem;
}
@media screen and (max-width: 640px) {
    .door .description {
  font-size: 2rem;
}
.door .title {
  font-size: 4rem;
  text-transform: uppercase;
  letter-spacing: 0.3rem;
  line-height: 5rem;
}

}
    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="carousel" class="carousel slide" data-ride="carousel" data-interval="10000">
  <ol class="carousel-indicators">
      <li data-target="#carousel" data-slide-to="0" class="active"></li>
      <li data-target="#carousel" data-slide-to="1"></li>
      <li data-target="#carousel" data-slide-to="2"></li>
	  
  </ol>
  
  <!-- Carousel items -->
  <div class="carousel-inner">
    <div class="item active">
      <div class="slide-content">
        <video  webkit-playsinline id="bgvid" autoplay loop >
           <source src="resources/images/1.mp4" type="video/mp4" >
        </video>
       </div>
    </div>
	
    <div class="item">
      <div class="slide-content">
        <video  webkit-playsinline id="bgvid" autoplay  loop >
          <source src="resources/images/2.mp4" type="video/mp4">
        </video>
      </div>
    </div>
    <div class="item">
      <div class="slide-content">
        <video webkit-playsinline id="bgvid" autoplay loop >
          <source src="resources/images/3.mp4" type="video/mp4">
        </video>
      </div>
    </div>
   </div>
  
  <a class="carousel-control left" href="#carousel" data-slide="prev">
   <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  
  <a class="carousel-control right" href="#carousel" data-slide="next">
   <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
  
</div>

<script type="text/javascript">
// If not iPhone, play first video and setup event handlers for  carousel rotations
// iPhone will not play videos inline, and will take control of the browser
if(!/iPhone/i.test(navigator.userAgent)) {
    $('.active > div > video').get(0).play();

    $('#carousel').bind('slide.bs.carousel', function(e) {
      $(e.relatedTarget).find('video').get(0).play();
    });

    $('#carousel').bind('slid.bs.carousel', function(e) {
      $('video').not('.active > div > video').each(function() {
        $(this).get(0).pause();
      });
    });
  }
</script>
</body>
</html>
