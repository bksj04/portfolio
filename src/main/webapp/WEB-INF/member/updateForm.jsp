<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp"%>
<%@include file="../display/top.jsp"%>
<style type="text/css">
.err {
	font-size: 10pt;
	color: red;
	font-weight: bold;
}
#update{
	width: 450px;
	height: 700px;
	margin: 30px auto;
		background-color: #252525;
		padding: 50px;
}
</style>
<script src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/script/update.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<div id="update">
	<form:form commandName="memberBean"
		action="update.member" method="post">
		<input type="hidden" name="num" value="${mb.num }">
		<input type="hidden" name="id" value="${mb.id }">
		<input type="hidden" name="agree" value="true">
		<input type="hidden" name="password" value="${mb.password }">
		<div class="form-group mt-4">
			<label for="name" class="form-label">이름</label> <input type="text"
				class="form-control" name="name" value="${mb.name }">
			<form:errors cssClass="err" path="name" />
		</div>

		<div class="form-group mt-4">
			<label for="tel" class="form-label">전화번호</label> <input type="text"
				class="form-control" name="tel" placeholder="-빼고입력"
				value="${mb.tel }">
				<form:errors cssClass="err" path="tel" />
		</div>
		<div class="form-group mt-4">
			<label for="email" class="form-label">email</label> <input
				type="text" class="form-control" name="email" value="${mb.email }">
				<form:errors cssClass="err" path="email" />
		</div>
		<div class="form-group mt-4">
			<input class="form-control" style="width: 40%; display: inline;"
				placeholder="우편번호" name="addr1" id="addr1" type="text"
				readonly="readonly" value="${mb.addr1 }">
			<button type="button" class="btn btn-default"
				onclick="execPostCode();">
				<i class="fa fa-search"></i> 우편번호 찾기
			</button>
		</div>
		<div class="form-group mt-4">
			<input class="form-control" style="top: 5px;" placeholder="도로명 주소"
				name="addr2" id="addr2" type="text" readonly="readonly" value="${mb.addr2 }" />
				<form:errors cssClass="err" path="addr2" />
		</div>
		<div class="form-group mt-4">
			<input class="form-control" placeholder="상세주소" name="addr3"
				id="addr3" type="text" value="${mb.addr3 }" />
				<form:errors cssClass="err" path="addr3" />
		</div>
		<div class="row">
		<div class="col">
		<input type="submit"
			class="btn btn-primary form-control mt-4" value="수정">
			</div>
			<div class="col">
		<input type="reset"
			class="btn btn-primary form-control mt-4"  value="취소">
			</div>
			</div>
	</form:form>
</div>
<%@include file="../display/bottom.jsp"%>