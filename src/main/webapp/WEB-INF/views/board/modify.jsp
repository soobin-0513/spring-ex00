<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board"%>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		var modifyUrl = "${appRoot }/board/modify";
		var removeUrl = "${appRoot }/board/remove";
		$("#board-removebtn").click(function() {
			if (confirm("삭제 하시겠습니까?")) {
				$("#modify-form").attr("action", removeUrl);
				$("#modify-form").submit();
			}
		});
	});
</script>
</head>
<body>
	<bd:navbar></bd:navbar>
	<div class="container">
		<h1>글 수정/삭제 </h1>
	
		<div class="row">
			<div class="col-12">
				<form  id="modify-form"action="${appRoot }/board/modify" method="post">
					<input hidden name="bno" value="${board.bno }" />
					<div class="form-group">
						<label for="input1">제목</label>
						<input id="input1" value="${board.title }" class="form-control" name="title">
					</div>
					<div class="form-group">
						<label for="textarea1">내용</label>
						<textarea id="textarea1" class="form-control" 
						name="content"><c:out value="${board.content }" /></textarea>
					</div>
					<div class="form-group">
						<label for="input2">작성자</label>
						<input readonly="readonly" value="${board.writer }" id="input2" class="form-control" name="writer">
					</div>				
					<input class="btn btn-warning" type="submit" value="수정" />
					<input id="board-removebtn" class="btn btn-danger" type="button" value="삭제" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>