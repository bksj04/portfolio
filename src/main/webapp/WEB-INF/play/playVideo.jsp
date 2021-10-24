<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../display/top.jsp"%>
  <style>
      video { max-width: 80%; display: block; margin: 20px auto; max-height: 80%; }
      video[poster]{ 
    height:600px;
    width:600px;
    }
    </style>
   <video controls poster="resources/images/poster/${vbean.image}">
      <source src="resources/videos/Dog.mp4" type="video/mp4">
    </video>
    
    <%@include file="../display/bottom.jsp"%>