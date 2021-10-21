<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#my {
	width: 70%;
	margin: auto;
}

table {
	height: 20%;
	font-style: white;
}
</style>
<%@ include file="../common/common.jsp"%>
<%@include file="../display/top.jsp"%>
<div id="my">
<div>
			<h5>${loginInfo.name } 님</h5>
			<hr>
			<h5>구매한 컨텐츠</h5>
	<table style="text-align: center; margin: 5px; width:100%;">
		<tr align=center>
		<c:if test="${cb == null}">
			<td>
			현재 구매한 이용권이 없습니다
			</td>
			</c:if>
			<c:if test="${cb != null}">
			<td>
			<font color="white">${cb.name} 이용권을 이용 중입니다.</font>
			</td>
			</c:if>
		</tr>
		<tr>
			<c:if test="${cb != null}">
			<td align=center>
				<font color="white">${cb.content} </font>
			</td>
			</c:if>
		</tr>
	</table>
	</div>
	<hr>
	<div align="left">
		<h5>시청 내역</h5>
		<div>
			<table>
					<c:if test="${empty wblists }">
					<tr align="center">
						<td align="center">시청내역이 없습니다.</td>
					</tr>
					</c:if>
					<tr>
					<c:forEach var="watch" items="${wblists}">
						<td><c:if test="${watch.video_category == 'main' }">
								<a
									href="detail${fn:toUpperCase(fn:substring(watch.video_category, 0, 1))}${fn:toLowerCase(fn:substring(watch.video_category, 1,fn:length(watch.video_category)))}.wa?num=${watch.video_num}"><img
									src="resources/images/poster/${watch.video_image}" width="200"
									height="200"></a>
							</c:if> <c:if test="${watch.video_category != 'main' }">
								<a
									href="detail${fn:toUpperCase(fn:substring(watch.video_category, 0, 1))}${fn:toLowerCase(fn:substring(watch.video_category, 1,fn:length(watch.video_category)))}.category?num=${watch.video_num}"><img
									src="resources/images/poster/${watch.video_image}" width="200"
									height="200"></a>
							</c:if></td>
					</c:forEach>
				</tr>

				<c:choose>
				<c:when test="${empty wblists }">
						
				</c:when>
				<c:otherwise>
									<div align="right">
					<br>					
					<a href="deletewatch.member"><button class="btn btn-primary">시청기록 지우기</button></a>
									</div>
				</c:otherwise>					
				</c:choose>

			</table>
		</div>
	</div>
	<hr>
	<div align="left">
		<h5>찜한 컨텐츠</h5>
		<table>
			<tr>
				<c:if test="${empty cblists}">
					<td align="center">찜한 컨텐츠가 없습니다.</td>
				</c:if>
				<c:forEach var="jjim" items="${cblists}">
					<td><c:if test="${jjim.video_category == 'main' }">
							<a href="detail${fn:toUpperCase(fn:substring(jjim.video_category, 0, 1))}${fn:toLowerCase(fn:substring(jjim.video_category, 1,fn:length(jjim.video_category)))}.wa?num=${jjim.video_num}"><img
								src="resources/images/poster/${jjim.video_image}" width="200"
								height="200"></a>
						</c:if> <c:if test="${jjim.video_category != 'main' }">
							<a
								href="detail${fn:toUpperCase(fn:substring(jjim.video_category, 0, 1))}${fn:toLowerCase(fn:substring(jjim.video_category, 1,fn:length(jjim.video_category)))}.category?num=${jjim.video_num}"><img
								src="resources/images/poster/${jjim.video_image}" width="200"
								height="200"></a>
						</c:if></td>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>
<%@include file="../display/bottom.jsp"%>