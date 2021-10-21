<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@include file="../display/top.jsp" %>
		<center>
		<h2>프리미엄 콘텐츠 포털, MoviePark!</h2>
		<br><br>
		<h5>국내외 프리미엄 채널과 VOD를 무제한으로 즐길 수 있어요.</h5>
		<br><br>
		<img src="resources/images/company.png" width="50%">
		
		<h5>찾아 오시는 길</h5>		
		<div id="map" style="width:50%; height: 50vh;"></div>
		  <script style="border: 1px;" async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAT9q9I6wcgboacD5csbFla9ztEq5hbU5Q&callback=initMap&region=kr"></script>
		  <script>
		    function initMap() {
		      var seoul = { lat: 37.556390 ,lng: 126.945199 };
		      var map = new google.maps.Map(
		        document.getElementById('map'), {
		          zoom: 20,
		          center: seoul
		        });
		      new google.maps.Marker({
		    	    position: seoul,
		    	    map: map,
		    	    label: "MoviePark 위치"
		    	  });
		    }
		  </script>
		</center>
		
	    <%@include file="../display/bottom.jsp" %>