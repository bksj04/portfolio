<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../display/top.jsp" %>

<style>
#findId {
	width: 400px;
	height: 400px;
	margin: 30px auto;
		background-color: #252525;
		padding: 50px;
}
</style>
<script src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/script/findid.js"></script>
<div id="findId">
<form action="findid.member" method="post">
	<h6 align="center">아이디 찾기 수단을 하나 선택해주세요</h6>
	<div class="row mt-4">
	      <div class="form-check col">
          <input type="radio" class="form-check-input" name="findIdWay" value="tel" checked>휴대폰 번호
      </div>
	      <div class="form-check col">
          <input type="radio" class="form-check-input" name="findIdWay" value="email">이메일 주소
      </div>
      </div>
      <div id="form-input">
	</div>
	<div align="center">
	<input type="submit" class="btn btn-primary form-control mt-4" value="확인">
	</div>
</form>
</div>
<%@ include file = "../display/bottom.jsp"%>