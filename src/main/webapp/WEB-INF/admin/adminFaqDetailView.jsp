<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
table {
	width: 100%;
}

th, td {
	border: 1px solid #444444;
}

th {
	text-align: center;
	width: 50px;
}
</style>
<table>
	<tr>
		<th>구분</th>
		<td>${cfb.division }</td>

	</tr>
	<tr>
		<th>제목</th>
		<td>${cfb.subject }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td height="400">${cfb.content }</td>
	</tr>
</table>
<br>
<input type="button" class="btn btn-primary" value="목록"
		onclick="location.href='faqList.admin'" style="float: right;">