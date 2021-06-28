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
</head>
<body>
	<div class="container">
		<script type="text/javascript">
		$(function() {
			$("#btn1").click(function() {
				$.ajax({
					url: "${appRoot}/rest07/sub01",
					data: {
						name: "korea",
						age: 33
					},
					success: function(data) {
						console.log(data);
					}
				});
			})
		})
		</script>
		<button id="btn1">BTN1</button>
		
		<script>
		$(function() {
			$("#btn2").click(function() {
				$.ajax({
					url: "${appRoot}/rest07/sub02",
					type: "post",
					data: {
						id: "jeju",
						age: 22
					},
					success: function(data) {
						console.log(data);
					}
				})
			})
		})
		</script>
		<button id="btn2">BTN2</button>
	
		<script>
		$(function() {
			$("#btn3").click(function() {
				$.ajax({
					url: "${appRoot}/rest07/sub03",
					type: "post",
					data: JSON.stringify({
						id: "제주",
						age: 77
					}),
					contentType: "application/json",
					success: function (data) {
						console.log(data);
					}
				})
			})
		});
		</script>
		<button id="btn3">BTN3</button>
		
		<script type="text/javascript">
			$(function(){
				$("#btn4").click(function(){
					$.ajax({
						url: "${appRoot}/rest07/sub04",
						success: function(data){
							console.log(data);
							
							console.log(data.id);
							console.log(data.age);
						}
					})
				})
			});
		</script>
		<button id="btn4">BTN4</button>
	</div>
</body>
</html>