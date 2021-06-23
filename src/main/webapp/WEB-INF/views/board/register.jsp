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

<title>글쓰기 페이지 </title>
</head>
<body>
	<bd:navbar></bd:navbar>
	<div class="container">
		
		<h1>글 쓰기</h1>
	
		<div class="row">
			<div class="col-12">
				<form action="${appRoot }/board/register" method="post">
					<div class="form-group">
						<label for="input1">제목</label>
						<input id="input1" class="form-control" name="title">
					</div>
					<div class="form-group">
						<label for="textarea1">내용</label>
						<textarea id="textarea1" class="form-control" name="content"></textarea>
					</div>
					<div class="form-group">
						<label for="input2">작성자</label>
						<input id="input2" class="form-control" name="writer">
					</div>				
					<input class="btn btn-primary" type="submit" value="작성" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>