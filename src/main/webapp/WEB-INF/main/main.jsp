<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../display/top.jsp" %>
<%@ include file="../common/common.jsp" %>
<link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />

    <!-- Demo styles -->
    <style>
      html,
      body {
        position: relative;
        height: 80%;
      }
      .swiper {
        width: 70%;
        height: 100%;
      }

      .swiper-slide {
        text-align: center;
        background: black;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
   .poster_img{
	width: 200px;
	height: 300px;
	margin: auto;
   }
      .icon_img{
   	width: 50px;
   	height: 50px;
   }
    </style>

	<div class="container">
	<div class="mt-4">
	    <h5>오늘의 추천작</h5>
	     <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <c:forEach var="video" items="${vlists}">
       	 	<div class="swiper-slide"><a href="detailMain.wa?num=${video.num}">
       	 	<img src="resources/images/poster/${video.image}"></a></div>
        </c:forEach>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </div>
    </div>
    <!-- Swiper -->
    <div style="margin-top: 100px">
   <h5>핫한 프로그램</h5>
   <div align="center">
					<c:forEach var="hvideo" items="${hlists}">
						<div style="display: inline-block;">
				<figure>
							<a href="detailEnter.category?num=${hvideo.num}"><img src="resources/images/poster/${hvideo.image}"
								class="poster_img" /></a>
				</figure>
				<h4>
					<span class="icon all ir_pm"> <c:if
							test="${hvideo.grade eq '18' }">
							<img src="resources/images/icon/18.svg" class="icon_img">
						</c:if> <c:if test="${hvideo.grade eq '15' }">
							<img src="resources/images/icon/15.svg" class="icon_img">
						</c:if> <c:if test="${hvideo.grade eq '12' }">
							<img src="resources/images/icon/12.svg" class="icon_img">
						</c:if> <c:if test="${hvideo.grade eq 'all' }">
							<img src="resources/images/icon/all.svg" class="icon_img">
						</c:if>
					</span> <strong><a href="detailEnter.category?num=${hvideo.num}">${hvideo.title }</a></strong>
				</h4>
				</div>
					</c:forEach>
					</div>
	</div>
    <div style="margin-top: 100px">
   <h5>많은 유저들이 찜한 컨텐츠</h5>
   <div align="center">
   		<c:forEach var="jvideo" items="${jlists}">
						<div style="display: inline-block;">
				<figure>
							<a href="detailEnter.category?num=${jvideo.num}"><img src="resources/images/poster/${jvideo.image}"
								class="poster_img" /></a>
				</figure>
				<h4>
					<span class="icon all ir_pm"> <c:if
							test="${jvideo.grade eq '18' }">
							<img src="resources/images/icon/18.svg" class="icon_img">
						</c:if> <c:if test="${jvideo.grade eq '15' }">
							<img src="resources/images/icon/15.svg" class="icon_img">
						</c:if> <c:if test="${jvideo.grade eq '12' }">
							<img src="resources/images/icon/12.svg" class="icon_img">
						</c:if> <c:if test="${jvideo.grade eq 'all' }">
							<img src="resources/images/icon/all.svg" class="icon_img">
						</c:if>
					</span> <strong><a href="detailEnter.category?num=${jvideo.num}">${jvideo.title }</a></strong>
				</h4>
				</div>
					</c:forEach>
					</div>
	</div>
	</div>
        <!-- Swiper JS -->
     <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
         <!-- Initialize Swiper -->
      <script>
      var swiper = new Swiper(".mySwiper", {
        slidesPerView: 3,
        spaceBetween: 30,
        slidesPerGroup: 3,
        loop: true,
        loopFillGroupWithBlank: true,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
<%@include file="../display/bottom.jsp" %>