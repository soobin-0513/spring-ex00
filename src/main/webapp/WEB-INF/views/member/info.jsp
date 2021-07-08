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

<script type="text/javascript">

	$(function(){
		$("#member-info-remove-btn1").click(function(){
			
			var ans = confirm("회원을 탈퇴하시겠습니까 ? ");
			
			if(ans){
				$("#member-info-form1")
				.attr("action","${appRoot}/member/remove")
				.submit();
			}
		})
	})
</script>
<title>회원정보 페이지 </title>
</head>
<body>
<bd:navbar></bd:navbar>
<div class="container">
	<c:if test="${param.status == 'success' }">
		<div id="alert1" class="alert alert-primary" role="alert">
			회원 정보를 수정하였습니다.
		</div>
	</c:if>
	
	<c:if test="${param.status == 'error' }">
		<div id="alert1" class="alert alert-danger" role="alert">
			회원 정보 수정을 할 수 없습니다.
		</div>
	</c:if>

	<h1>회원 정보</h1>
	<div class="row">
		<div class="col-12">
			<form id="member-info-form1" method="post" action="${appRoot }/member/modify">
				<div class="form-group">
					<label for="member-info-input1">아이디</label>
					<input readonly value="${member.userid }" type="text" class="form-control" id="member-info-input1" name="userid" >
				</div>
				<div class="form-group">
					<label for="signup-input2">패스워드</label>
					<input type="password" class="form-control" id="member-info-input2" name="userpw">
				</div>
				<div class="form-group">
					<label for="member-info-input3">이름</label>
					<input value="${member.userName }" type="text" class="form-control" id="member-info-input3" name="userName">
				</div>
				<button type="submit" class="btn btn-secondary" id="member-info-modify-btn1">정보 수정</button>
				<button type="button" class="btn btn-danger" id="member-info-remove-btn1">회원 탈퇴</button>
			</form>
		</div>	
	</div>
</div>
</body>
</html>