<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="bd" tagdir="/WEB-INF/tags/board" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>회원가입 페이지 </title>
</head>
<body>
<bd:navbar></bd:navbar>
	<div class="container">
		<c:if test="${not empty param.error }">
			<div id="alert1" class="alert alert-danger" role="alert">
				회원 가입에 실패하였습니다.
			</div>
		</c:if>
			<h1>회원 가입</h1>
			<div class="row">
				<div class="col-12">
					<form method="post" action="${appRoot }/member/signup">
						<div class="form-group">
							<label for="signup-input1">아이디</label>
							<input type="text" class="form-control" id="signup-input1" name="userid" >
						</div>
						<div class="form-group">
							<label for="signup-input2">패스워드</label>
							<input type="password" class="form-control" id="signup-input2" name="userpw">
						</div>
						<div class="form-group">
							<label for="signup-input3">이름</label>
							<input type="text" class="form-control" id="signup-input3" name="userName">
						</div>
						<button type="submit" class="btn btn-success" id="signup-btn1">회원 가입</button>
					</form>
				</div>	
		</div>
	</div>
</body>
</html>