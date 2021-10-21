<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateOrder.jsp<br><br>

<%@include file="../admin/display/top.jsp" %>
<%@include file="./../common/common.jsp"%>

<style>
#container{

height: 600px;

}
#memberList{
text-align: center;
height: 100%;
border: 1px solid black;
padding: 100px;
}
table{
margin: auto;
text-align: center;
width: 100%;
height: 100%;

}
tr{
	text-align: right;
	width: 30%;
}
td{
	text-align: center;
	width: 70%;
}
</style>

<div class="row" id="container">
	<div class="col-lg-2">
		<%@include file="../admin/display/left.jsp" %>
	</div>
	<div id="videoUpdate" class="col-lg-10" align="center">
		
		<div >
			<h2 style="color:#0080FF; font-weight: bold;">회원 이용권 수정창</h2>	
			<div>
				<form action="updateOrderCommodity.voucher" method="post" >
					<input type="hidden" name="pageNumber" value="${pageNumber}" >
					<input type="hidden" name="num" value="${mb.num}">
					<fieldset>
			<div class="form-group">
				<label for="name" class="form-label mt-4">회원 이름</label>
				<input type="text" readonly name="name" value="${mb.name}">
			</div>
			<div class="form-group" >
				<label for="commodity" class="form-label mt-4">상품번호</label><br>
				
				<input type="radio" name="commodity" value=1  <c:if test="${ob.cnum eq 1 }">checked</c:if>>
				1:Basic 동시시청 1회선,HD화질,모바일+PC 7900원<BR>
				
				<input type="radio" name="commodity" value=2 <c:if test="${ob.cnum eq 2 }">checked</c:if>>
				2:Standard 동시시청 2회선,FHD화질,전체 디바이스 10900원<BR>
				
				<input type="radio" name="commodity" value=3  <c:if test="${ob.cnum eq 3 }">checked</c:if>>
				3:Premium 동시시청 4회선,최고화질,전체 디바이스 13900원<BR>
				
				<input type="radio" name="commodity" value=4  <c:if test="${ob.cnum eq 4 }">checked</c:if>>
				4:Basic X FLO 무제한 동시시청 1회선,HD화질,모바일+PC 13750원<BR>
				
				<input type="radio" name="commodity" value=5  <c:if test="${ob.cnum eq 5 }">checked</c:if>>
				5:Standard X Bugs 듣기 동시시청 1회선,HD화질,모바일+PC 13750원<BR>
				
				<input type="radio" name="commodity" value=6  <c:if test="${ob.cnum eq 6 }">checked</c:if>>
				6:Premium X KB 나라사랑카드 동시시청 1회선,HD화질,모바일+PC 7900원<BR>
					
			</div>
		</fieldset>
		<br><br>
			<div align="center">
			<input type="submit" class="btn btn-primary" value="수정">
			<input type="button" class="btn btn-primary" onclick="history.go(-1);" value="취소">
			</div>
				</form>
			</div>
		</div>
	</div>
</div>