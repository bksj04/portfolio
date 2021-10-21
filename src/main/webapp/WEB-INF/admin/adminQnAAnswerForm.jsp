<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <style>

#writeForm {
	width: 600px;
}
</style>

<form method="post" action="qnaAnswer.admin">
<input type="hidden" name="ref" value="${ref}">
	<div class="container" id="writeForm">
		<div class="input-group">
			<span class="input-group-text">제목</span> <input type="text"
				class="form-control" name="subject">
		</div>
		<br>
		<div class="input-group">
			<span class="input-group-text">내용</span>
			<textarea class="form-control" rows="15" cols="50" name="content"></textarea>
		</div>
		<br>
		<div>
			<button type="submit" class="btn btn-primary justify-content-end">완료</button>
		</div>
	</div>
</form>
    