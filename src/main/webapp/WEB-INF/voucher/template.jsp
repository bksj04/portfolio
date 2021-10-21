<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
#tap{
	background-color: gray;
}
</style>
<%
	String contentPage=request.getParameter("contentPage");
%>

<%@include file="../display/top.jsp" %>

<form style="text-align: center;">
	<br><br>
	<div id=tap>
	<h4>이용권</h4><br>
	<h6>LIVE,VOD는 물론 이제 영화까지 MoviePark 이용권으로 더 넓은 콘텐츠 세상으로의 항해,MoviePark와 함께하세요!</h6>
	</div>
	<br>
	<hr color=gray>
	
	<div >
		<div valign="bottom">
			<div><a href="pay.voucher">MoviePark이용권</a>/<a href="coin.voucher">쿠폰</a></div>
		</div>
		
		<div>
			<div >
					<jsp:include page="<%=contentPage %>"/>
			</div>
		</div>
	</div>
</form>

<%@include file="../display/bottom.jsp" %>