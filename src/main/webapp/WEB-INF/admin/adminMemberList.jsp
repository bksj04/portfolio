<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp"%>

<script type="text/javascript">
	function goUpdate(num,pn){
		location.href="memberUpdate.admin?num="+num+"&pageNumber="+pn;
	}
	function goDelete(num,pn){
		 var result = confirm("삭제하시겠습니까 ?");
	        
	        if(result)
	        {
	        	location.href="memberDelete.admin?num="+num+"&pageNumber="+pn;
	        alert("삭제되었습니다")
	        }
	        else
	        {
	        	alert("삭제 취소")
	        }
	}
</script>
<style>

table {
	margin: auto;
	text-align: center;
}
</style>
<div class="row" id="container">
<div id="memberList" class="col-lg-10" align="center">
<h2 style="color: #0080FF; font-weight: bold;">회원 리스트</h2>
<form action="memberList.admin" method="get">
			<select name="whatColumn">
				<option value="">전체 검색</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select> <input type="text" name="keyword"> <input type="submit" class="btn btn-primary"
				value="검색">		
				<div align="right">
</div>
				
		</form>
<table border="1" align="center" width="600" class="table">
	<thead class="table-light">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>가입일자</th>
			<th>수정</th>
			<th>삭제</th>

		</tr>
	</thead>
	<tbody>
		<c:if test="${empty lists }">
			<tr>
				<td colspan="8">데이터가 존재하지 않습니다</td>
			</tr>
		</c:if>
		<c:forEach var="member" items="${lists }">

			<tr>
				<td>${member.num }</td>
				<td><a
					href="memberDetailView.admin?num=${member.num }&pageNumber=${pageInfo.pageNumber}">${member.id }</a></td>
				<td>${member.password }</td>
				<td>${member.name }</td>
				<td>${member.tel}</td>
				<td><fmt:parseDate value="${member.regdate }"
						var="noticePostDate" pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate
						value="${noticePostDate}" pattern="yyyy-MM-dd HH:mm" var="regdate" />
					${regdate }</td>	
				<td><input type="button" class="btn btn-primary" value="수정"
					onClick="goUpdate(${member.num },${pageInfo.pageNumber})"></td>
				<td><input type="button" class="btn btn-primary" value="삭제"
					onClick="goDelete(${member.num },${pageInfo.pageNumber})"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
${pageInfo.pagingHtml }
</div>
</div>