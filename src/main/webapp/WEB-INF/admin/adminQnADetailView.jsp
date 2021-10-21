<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<style>
table {
	width: 100%;
	border: 1px solid #444444;
		border-width: 2px;
}

th, td {
	border: 1px solid #444444;
		border-width: 2px;
}

th {
	text-align: center;
	width: 60px;
}
</style>

<table>
	<tr>
		<th>제목</th>
		<td>${cqb.subject }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${cqb.writer }</td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><fmt:parseDate value="${cqb.reg_date }" var="noticePostDate"
				pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate value="${noticePostDate}"
				pattern="yyyy-MM-dd HH:mm" var="reg_date" /> ${reg_date }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td height="400">${cqb.content }</td>
	</tr>
</table>
<br>
<div align="right">
	<input type="button" class="btn btn-primary" value="답변쓰기"
		onclick="location.href='qnaAnswer.admin?ref=${cqb.ref}'">
		&nbsp;&nbsp;
		<input type="button" class="btn btn-primary" value="목록"
		onclick="location.href='qnaList.admin'" style="float: right;">
</div>
