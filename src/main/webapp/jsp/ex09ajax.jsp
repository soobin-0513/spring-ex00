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
		$(function(){
			$("#btn1").click(function(){
				$.ajax({
					url: "${appRoot}/rest09/sub01",
					type: "post",
					//client -->server 
					data: {
						id : "korea",
						age: 55
					},
					//server->client 
					//위에서 결과응답을받으면 밑에 함수가 실행되며, 그 응답이 data에들어감
					success: function(data){
						console.log("bt1",data);
					},dataType: "json"
				});
			});
		
/* 			
			$("#btn2").click(function() {
				$.post("${appRoot}/rest09/sub01", function(data){
						console.log("btn2",data);
					}, "json");
				}); */
			
				$("#btn2").click(function() {
					$.post({
						
						url: "${appRoot}/rest09/sub01",
						data: {
							id: "korea",
							age: 55
						},
						success: function(d) {
							console.log("btn2", d);
						},
						dataType: "json"
					});
				})
				
				$("#btn3").click(function() {
					$.post("${appRoot}/rest09/sub01", {id: "korea", age: 55}
						, function (d) {
							console.log("btn3", d);
						}, "json"
					);
				})
			
			});
			
		
	</script>
	<button id="btn1">btn1</button>
	<button id="btn2">btn2</button>
	<button id="btn3">btn3</button>
	</div>
</body>
</html>