<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
<%@ include file="./../common/common.jsp" %>
<style>
	#title{
		background-color: blue;
		color: white;
	}
</style>
<div id="title"align="center">알림함</div>
<div class="container row" style="float: none; margin:100 auto;">
<div class="col-md-3" style="float: none; margin:0 auto;">
<table class="table">
	<tr>
	<th>제목</th><td>${cqb.subject }</td>
	</tr>
	<tr>
	<th>작성자</th><td>${cqb.writer }</td>
	</tr>
	<tr>
	<th>작성일</th><td><fmt:parseDate value="${cqb.reg_date }" var="noticePostDate"
				pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${noticePostDate}"
				pattern="yyyy-MM-dd HH:mm" var="reg_date" /> ${reg_date }</td>
	</tr>
	<tr>
	<th  height="300">내용</th><td>${cqb.content }</td>
	</tr>
</table>
<div align="right">
<input type="button" class="btn btn-primary" value="목록" onclick="location.href='messageList.wa'">
</div>
</div>
</div>