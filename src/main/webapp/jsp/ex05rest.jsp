<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#test1").click(function() {
			$.ajax({
				url: '${appRoot}/rest05/sub01',
				type: 'post',
				data: '{"id":"korea", "age":30}',
				contentType: 'application/json',
				success: function(data) {
					console.log(data);
				},
				error: function() {
					console.log("fail");
				}
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<button id="test1">BUTTON</button>
	</div>
</body>
</html>