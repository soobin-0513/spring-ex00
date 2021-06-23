<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>글목록 페이지 </title>
</head>
<body>
	<bd:navbar></bd:navbar>
	<div class="container">

		<h1>글 목록 </h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>제목 </th>
					<th>작성자 </th>
					<th>작성일 </th>
					<th>수정일  </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var ="board">
					<tr>
						<td>${board.bno }</td>
						<td>
							<a href="${appRoot }/board/get?bno=${board.bno}">
							${board.title }
							</a>
						</td>
						<td>${board.writer }</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/>
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${not empty result }" >
		<script>
		$(document).ready(function() {
			
			if (history.state == null) {
				$("#board-modal1").modal('show');
				history.replaceState({}, null);
			}
			 else {
					
					console.log("너 전에 왔었어!!!!");
				}
		});
		</script>
		
		<div id="board-modal1" class="modal" tabindex="-1">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">${messageTitle } </h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>${messageBody } </p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	
	</c:if>
</body>
</html>