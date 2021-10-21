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
<div id="alrim">
<div id="title" align="center">알림함</div>
<div class="container row" style="float: none; margin:100 auto;">
<div class="col-md-3" style="float: none; margin:0 auto;">
<table class="table table-hover" style="text-align: center">
	
		<tr>
	<th>NO</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	</tr>
	
	<c:if test="${empty lists}">
		<tr align="center">
			 <td colspan="4">
			쪽지가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="cqb" items="${lists}" varStatus="status">
	<tr>
	<td>${TotalCount - status.index }</td>
	<td><a href="messageDetailView.wa?num=${cqb.num}">${cqb.subject}</a></td>
	<td>${cqb.writer }</td>
	<td><fmt:parseDate value="${cqb.reg_date }" var="noticePostDate"
				pattern="yyyy-MM-dd" /> <fmt:formatDate value="${noticePostDate}"
				pattern="yyyy-MM-dd" var="reg_date" /> ${reg_date}</td>
	</tr>
	</c:forEach>
</table>
</div>
</div>
</div>