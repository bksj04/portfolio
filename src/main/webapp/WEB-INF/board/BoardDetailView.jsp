<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<%@ include file="../display/top.jsp"%> 
<style>
#boardDetailView{
	margin: auto;
width:600px;
}
#reply{
margin: auto;
width:600px;
}
</style>
	<div id="boardDetailView">
    <table class="table">
    <tr>
    <td align="center"><h4>${bb.subject }</h4></td>
    </tr>
    <tr height="50">
    <td align="right"><b>작성자 :</b> ${bb.writer } <b>조회수 :</b> ${bb.readcount } 
    <b>등록일 :</b> <fmt:parseDate value="${bb.reg_date }" var="noticePostDate" pattern="yyyy-MM-dd" /> <fmt:formatDate value="${noticePostDate}" pattern="yyyy-MM-dd" var="reg_date" /> ${reg_date }</td>
    </tr>
    <tr>
    <td height="300">${bb.content }</td>
    </tr>
    </table>
    <br>
    <div align="right">
    <input type="button" value="글목록" class="btn btn-primary" onclick="location.href='list.board'">
    </div>
    <br><br>
    </div>
    <div id="reply">
    <c:if test="${replyType == 'write' }">
    	<form method="post" action="replyWrite.board">
	<input type="hidden" name="bnum" value="${bb.num}">
			<p>
			<textarea rows="3" cols="70" name="content" class="form-control col-sm-5"></textarea>
			</p>
			<p align="right">
			<input type="submit" class="btn btn-primary" value="댓글입력">
			</p>
	</form>
	</c:if>
    <c:if test="${replyType == 'update' }">
    	<form method="post" action="replyUpdate.board">
	<input type="hidden" name="bnum" value="${bb.num}">
	<input type="hidden" name="rnum" value="${rb.rnum}">
			<p>
			<textarea rows="3" cols="70" name="content" class="form-control col-sm-5">${rb.content }</textarea>
			</p>
			<p align="right">
			<input type="submit" class="btn btn-primary" value="댓글수정">
			</p>
	</form>
	</c:if>
	<c:forEach items="${reply}" var="reply">
	<table class="table table-hover">
	<tr>
	<td>
		<font size="3">ID : ${reply.writer} / <fmt:parseDate value="${reply.reg_date}" var="noticePostDate"
						pattern="yyyy-MM-dd HH:mm" /> <fmt:formatDate
						value="${noticePostDate}" pattern="yyyy-MM-dd HH:mm"
						var="reg_date" /> ${reg_date }</font>
	</td>
	<td style="text-align: right">
		<c:if test="${reply.writer == loginInfo.id || 'admin' == loginInfo.id}">
		<a href="replyUpdate.board?bnum=${reply.bnum }&rnum=${reply.rnum }&replyType=update">[수정]</a> <a href="replyDelete.board?bnum=${reply.bnum }&rnum=${reply.rnum }">[삭제]</a>
		</c:if>
	</td>
	</tr>
	<tr>
	<td colspan="2">
	${reply.content }
	</td>
	</tr>
	</table>	
</c:forEach>
<p align="center">
<c:forEach var="i" begin="1" end="${count%3 == 0 ? count/3 : count/3+1 }">

<a href="detailView.board?replyPageNumber=${i }&num=${bb.num}">${i }</a>

</c:forEach>
</p>
</div>
    <%@ include file="../display/bottom.jsp"%>