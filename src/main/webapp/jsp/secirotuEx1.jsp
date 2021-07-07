<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<!--spring security test -->
		<div>
			<sec:authorize access="isAuthenticated()">
				<%-- 로그인 되어있을 때 principal =>> CustomUser --%>
				<sec:authentication property="principal" var="pinfo" />
				<br>
				${pinfo.member.userid } <br>
				${pinfo.member.userpw } <br>
				${pinfo.member.userName } <br>
			</sec:authorize>

			<sec:authorize access="!isAuthenticated()">
				<%-- 로그아웃 되어있을 때 principal =>> String --%>
			<sec:authentication property="principal" var="pinfo" />
				<br>
			${pinfo } 
			</sec:authorize>
		</div>
	</div>
</body>
</html>