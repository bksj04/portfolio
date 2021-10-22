<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../display/top.jsp"%>
<style>
#loginPage{
}
#login {
	width: 400px;
	height: 400px;
	margin: 30px auto;
	background-color: #252525;
		padding: 50px;
}
</style>
<div id="login">
	<h2 align=center>Login</h2>
	<form name="loginform" action="login.member" method="post">
			<div class="form-group">
				<input type="text" class="form-control" name="id" placeholder="아이디">
				</div>
							<div class="form-group mt-4">
				<input type="password" class="form-control " name="password" placeholder="비밀번호">
				</div>
							<div class="form-group mt-4">
				<input type="submit" class="btn btn-primary form-control" value="로그인">
			</div>
	</form>
				<div align="center" class="form-group mt-4">
<a href="findid.member">아이디찾기</a> | <a href="findpw.member">비밀번호 찾기</a> | <a href="sign.member">회원가입</a>
</div>
</div>
<%@include file="../display/bottom.jsp"%>

