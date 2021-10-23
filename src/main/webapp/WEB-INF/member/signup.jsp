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
#signup {
	width: 450px;
	height: 1150px;
	margin: 30px auto;
		background-color: #252525;
		padding: 50px;
}
</style>
<script src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/script/signup.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<div id="signup">
	<form:form commandName="memberBean" name="loginform"
		action="sign.member" method="post">
		<div class="form-group">
			<label for="id" class="form-label">아이디</label> <input type="text"
				class="form-control" name="id" value="${mb.id }">
			<form:errors cssClass="err" path="id" />
			<br> <input type="button" value="중복체크" class="btn btn-primary"
				id="idcheck"> <input type="hidden" name="chk" value="0">
		</div>

		<div class="form-group mt-4">
			<label for="password" class="form-label">비밀번호</label> <input
				type="password" class="form-control" name="password" id="pw1"
				oninput="pwCheck(pw1.value)" value="${mb.password }">
			<form:errors cssClass="err" path="password" />
		</div>

		<div class="form-group mt-4">
			<label for="password" class="form-label">비밀번호 확인</label> <input
				type="password" class="form-control" id="repw1" value="${mb.password }">
			<p id="pwCheckF" style="color: #FF6600; margin: 0;"></p>
			<p id="pwCheckFF" style="color: #FF6600; margin: 0;"></p>
		</div>

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
		<div class="form-check mt-4">
			<input class="form-check-input" type="checkbox" value="true" name="agree">
			<label class="form-check-label" for="flexCheckDefault">개인정보 이용 동의</label>
			<br>
				<form:errors cssClass="err" path="agree" />
		</div>
		<input type="submit" id="sub"
			class="btn btn-primary form-control mt-4" value="가입완료">
	</form:form>
</div>
<%@include file="../display/bottom.jsp"%>