<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./../common/common.jsp"%>
<script type="text/javascript" src="resources/script/update.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<style type="text/css">
.err {
	font-size: 9pt;
	color: red;
	font-weight: bold;
}

#signPage {
	
}

#sign {
	width: 450px;
	height: 400px;
	margin: 30px auto;
}
</style>

<script src="resources/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var isCheck = false;
				var isChange = false;

				$('#idcheck').click(
						function() {

							isChange = false;
							$.ajax({
								url : "idCheck.member",
								type : "POST",
								data : {
									"userId" : $('input[name="id"]').val()
								},
								success : function(data) {
									if (data == 0
											&& $.trim($('input[name="id"]')
													.val()) != '') {
										alert("사용가능한 아이디 입니다.");
										isCheck = true;
									} else {
										alert("사용불가능한 아이디 입니다.");
										isCheck = false;
									}
								},
								error : function() {
									alert("에러");
								}
							});
						});
				$('#sub').click(function() {
					if (isCheck == false || isChange == true) {
						alert("중복체크는 필수입니다.");
						return false;
					} else if (use == "impossible") {
						alert("이미 사용중인 아이디입니다.");
						return false;
					}

				});//click
			});
</script>

<%
String[] tel1 = { "02", "064", "010" };
request.setAttribute("tel1", tel1);
%>
<div id="sign">
	<h3 style="color: #0080FF; font-weight: bold;" align="center">회원
		수정 화면</h3>

	<form:form commandName="member" method="post"
		action="memberUpdate.admin">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<input type="hidden" name="num" value="${member.num}">

		<fieldset>
			<div class="form-group">
				<label for="id" class="form-label mt-4">아이디</label> <input
					type="text" class="form-control" name="id" placeholder="아이디 입력"
					value="${member.id }">
				<form:errors cssClass="err" path="id" />
				<br> <input type="button" value="중복체크" class="btn btn-primary"
					id="idcheck">
			</div>
			<div class="form-group">
				<label for="password" class="form-label mt-4">비밀번호</label> <input
					type="text" class="form-control" name="password"
					placeholder="비밀번호 입력" value="${member.password }">
				<form:errors cssClass="err" path="password" />
			</div>
			<div class="form-group">
				<label for="name" class="form-label mt-4">이름</label> <input
					type="text" class="form-control" name="name" placeholder="이름 입력"
					value="${member.name }">
				<form:errors cssClass="err" path="name" />
			</div>

			<div class="form-group">
				<label for="name" class="form-label mt-4">전화번호</label>
						<input type="text" class="form-control" name="tel" placeholder="전화번호 입력" value="${member.tel}">
						<form:errors cssClass="err" path="tel" />
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
			<br> <br>
			<div align="center">
				<input type="submit" class="btn btn-primary" value="수정하기"> <input
					type="button" class="btn btn-primary" onclick="history.go(-1);"
					value="취소">
			</div>
		</fieldset>
	</form:form>
</div>

