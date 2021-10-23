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
<div id="findId">
<form action="findid.member" method="post">
	<h6 align="center">아이디 찾기</h6>
      <div id="form-input">
      <input type="text" class="form-control mt-4" name="name" placeholder="이름">
	<input type="text" class="form-control mt-4" name="email" placeholder="이메일">
	</div>
	<div align="center">
	<input type="submit" class="btn btn-primary form-control mt-4" value="확인">
	</div>
</form>
</div>
<%@ include file = "../display/bottom.jsp"%>