<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/common.jsp"%>
<%@include file="../display/top.jsp"%>
   <div class="container">
    <div class="row">
    <form action="QnA.cs" method="post">
   <div class="form-group col-sm-4" style="float: none; margin:0 auto;">
   		<div class="p-3">
  <label class="col-form-label" for="QnA">제목</label>
  <input type="text" class="form-control" placeholder="제목 입력" name="subject">
   		</div>
   		<div class="p-3">
      <label for="QnA" class="form-label">내용</label>
      <textarea class="form-control" name="content" rows="3" placeholder="내용 입력"></textarea>
    	</div>
    	<div class="p-3">
    	<div align="right">
    	<input type="submit" class="btn btn-primary" value="문의하기">
    	</div>
    	</div>
    </div>
    </form>
    </div>
    </div>
    
    <%@include file="../display/bottom.jsp"%>