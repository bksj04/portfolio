<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
	function selectCard(){
		document.getElementById("img").src="resources/images/icon/card.jpg"
	}
	
	function selectCash(){
		document.getElementById("img").src="resources/images/icon/cash.jpg"
	}
</script>
<style>
#img {
	width: 150px;
	height: 150px;
}

div {
	text-align: center;
	background-color: #ddd;
}
</style>
<%
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 1);
	Date nowTime = new Date();
	Date nextTiem = new Date();
	
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<div>
	<form action="order.voucher?cnum=${cb.num }&mnum=${loginInfo.num}"
		method="post">
		<div id="top">
			<h2>MoviePark 이용권구매</h2>
		</div>
		<div id="bottom">
			<div id="b_title">결제 내용</div>
			<div id="b_name">${cb.name }</div>
			<div id="b_content">${cb.content }</div>
			<div id="b_date">
				이용기간 :
				<%=sf.format(nowTime) %>~<%=sf.format(cal.getTime())%>
			</div>
			<div id="b_price">금액(매월) : ${cb.price }원</div>

			<c:if test="${cpb != null }">
				<div id="b_price">
					쿠폰<fmt:formatNumber value="${cpb.cp_discount}" type="percent"/>할인 적용
					<fmt:formatNumber type="number" pattern="###,###,###,###,###,###"
						value="${cb.price - cb.price * cpb.cp_discount}" />원
				</div>
			</c:if>
		</div>
		<div id="payment">
			결제수단 선택 : <input type="radio" name="payment" value="card"
				onclick="selectCard()" checked="checked">카드 <input
				type="radio" name="payment" value="cash" onclick="selectCash()">현금
		</div>
		<div id="paymentimg">
			<img id="img" src="resources/images/icon/card.jpg">
		</div>
		<div>
			<input type="submit" value="결제"> <input type="reset"
				value="취소">
		</div>
	</form>
</div>
