<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../admin/display/top.jsp" %>
<%@include file="./../common/common.jsp"%>
<style>
.err{
		font-size: 13pt;
		color: red;
		font-weight: bold;
		}
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
<script src="resources/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	alert("1")
}
</script>

<div class="row" id="container">
	<div class="col-lg-2">
		<%@include file="../admin/display/left.jsp" %>
	</div>
	<div id="videoList" class="col-lg-10" align="center">
		
		<div>
			<h2 style="color:#0080FF; font-weight: bold;">영상 게시물 추가창</h2>	
			<div>
				<form:form commandName ="categoryBean" action="adminInsertVideo.category" method="post" enctype="multipart/form-data">
					<fieldset>
			<div class="form-group">
			<label for="title" class="form-label mt-4">제목</label>
				<input type="text" class="form-control" name="title" placeholder="제목 입력" >
				<form:errors cssClass="err" path="title" />			
			</div>
		<div class="form-group">
				<label for="category" class="form-label mt-4">카테고리</label>
				<input type="radio" name="category" value="movie">영화
				<input type="radio" name="category" value="drama">드라마
				<input type="radio" name="category" value="enter">예능
				<input type="radio" name="category" value="ani">만화
				<form:errors cssClass="err" path="category" />
			</div>
			<div class="form-group">
				<label for="name" class="form-label mt-4">시청 연령 제한</label>
				<select name="grade">
					<option value="">선택
					<option value="18">18
					<option value="15">15
					<option value="12">12
					<option value="all">all
				</select>
				<form:errors cssClass="err" path="grade" />
			</div>
			<div>
				<input type="file" name="file" id=file>
				
			</div>
		</fieldset>
		<br><br>
			<div align="center">
			<input type="submit" id="sub" class="btn btn-primary" value="다음">
			<input type="button" class="btn btn-primary" onclick="history.go(-1);" value="취소">
			</div>
				</form:form>
			</div>
		</div>
	</div>
</div>