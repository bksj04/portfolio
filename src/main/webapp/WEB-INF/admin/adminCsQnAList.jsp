<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>

<style>
table {
	margin: auto;
	text-align: center;
}
</style>
<h2 style="color: #0080FF; font-weight: bold;">QnA 리스트</h2>
<br>
<table border="1" align="center" width="600" class="table">
	<thead class="table-light">
		<tr>
			<th scope="col">No</th>
			<th scope="col">Type</th>
			<th scope="col" width="300">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">등록일</th>
			<th scope="col">삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cqb" items="${lists }" varStatus="status">
			<tr>
				<td>${totalCount - ((pageInfo.pageNumber - 1) * 10) - status.index}</td>
				<td>
				<c:if test="${cqb.re_level == 0}">
				질문
				</c:if>
				<c:if test="${cqb.re_level == 1}">
				<img src="resources/images/re.gif">답변
				</c:if>
				</td>
				<td width="300"><a
					href="qnaDetailView.admin?num=${cqb.num }">${cqb.subject }</a></td>
					<td>${cqb.writer }</td>
				<td><fmt:parseDate value="${cqb.reg_date }"
						var="noticePostDate" pattern="yyyy-MM-dd" /> <fmt:formatDate
						value="${noticePostDate}" pattern="yyyy-MM-dd" var="reg_date" />
					${reg_date}</td>
				<td><a href="qnaDelete.admin?num=${cqb.num }">삭제</a></td>

			</tr>
		</c:forEach>
	</tbody>
</table>

<form action="qnaList.admin" method="get">
	<div class="row justify-content-center">
		<div class="col-sm-2">
			<select name="whatColumn" class="form-select">
				<option value="all">전체 검색</option>
				<option value="writer"
					<c:if test="${pageInfo.whatColumn == 'writer'}">
		selected
		</c:if>>작성자</option>
				<option value="subject"
					<c:if test="${pageInfo.whatColumn == 'subject'}">
		selected
		</c:if>>제목</option>
			</select>
		</div>
		<c:if test="${pageInfo.keyword == 'null'}">
			<div class="col-sm-2">
				<input type="text" class="form-control" name="keyword" value="">
			</div>
		</c:if>
		<c:if test="${pageInfo.keyword != 'null'}">
			<div class="col-sm-2">
				<input type="text" class="form-control" name="keyword"
					value="${pageInfo.keyword}">
			</div>
		</c:if>
		<div class="col-sm-1">
			<input type="submit" class="btn btn-primary justify-content-end"
				value="검색">
		</div>
	</div>
</form>

${pageInfo.pagingHtml}
