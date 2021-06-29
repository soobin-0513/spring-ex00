<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
<script>
$(function() {
	$("#submit1").click(function(e) {
		e.preventDefault();
		$(this).attr("disabled", "disabled");
		$(this).html('<i class="fas fa-spinner fa-spin"></i>');
		
		var id = $("#input1").val();
		var age = $("#input2").val();
		
		var data = {id: id, age: age};
		
		$.post({
			url: "${appRoot}/rest10/add",
			data: data,
			success: function (data) {
				console.log(data);
				alert(data.id + "가 등록되었습니다.");
				$("#submit1")
				.removeAttr("disabled")
				.html("전송");
			}
		});
	});
	
	//button2 목록보기 동작하기 
	$("#button2").click(function() {
		$.get({
			url : "${appRoot}/rest10/list",
			success : function(list) {
				console.log(list);
				var table1body = $("#table1 tbody");
				//밑에서 append로내용을 추가해줬기때문에 
				// 목록보기 클릭하면 기준에추가한게 계속 보이니까 
				//empty()사용해서  table1body이전에 추가한 내용 다 지워주기 
				table1body.empty();
				
				for (var i = 0; i < list.length; i++) {
					var tr = $(generateTableRow(list[i]));
					table1body.append(tr);
				}
			}
		});
	});
	
	function generateTableRow(data) {
		return "<tr><td>" + data.id + "</td><td>" + data.age +"</td></tr>"
	}
	/*  
		//class 사용해서 변경해주기 
	// css파일을 사용해야함 
	// <link href="${pageContext.request.contextPath }/resources/css/all.css" rel="stylesheet">
	
	$("#like-button1").click(function(){
		var cn = $("#like-icon1");
		console.log("like button")
		console.log(cn.hasClass("far"));
		console.log(cn.hasClass("fas"));
		console.log(cn.hasClass("fa-heart"))
		if(cn.hasClass("far")){
			$.post({
				url: "${appRoot}/rest10/like",
				success : function(data){
					$("#like-cnt1").text(data);
					$("#like-icon1").removeClass("far").addClass("fas");
				}
			})
		} else if (cn.hasClass("fas")) {
			$.post({
				url: "${appRoot}/rest10/dislike",
				success : function(data){
					$("#like-icon1").removeClass("fas").addClass("far");
					$("#like-cnt1").text(data);
				}
			})
		}
	})
	*/
 

	$("#like-button1").click(function() {
		var operation = $(this).attr("data-operation");
		
		var url = "${appRoot}/rest10/" + operation;
		
		$.post({
			url : url,
			success : function(data) {
				//$("#like-icon1").toggleClass("far fas");
				$("#like-cnt1").text(data);
				
				if (operation === "like") {
					$("#like-button1").attr("data-operation", "dislike");
					$("#like-icon1").removeClass("far").addClass("fas");
				} else {
					$("#like-button1").attr("data-operation", "like");
					$("#like-icon1").removeClass("fas").addClass("far");
				}
			}
		});
	});
});
</script>
</head>
<body>
<div class="container">
	<%= Math.random() %>
	<hr>
	<button id="like-button1" data-operation="like">
		<i id="like-icon1" class="far fa-heart"></i>
		<span id="like-cnt1">10</span>
	</button>
		<br>
		<input id="input1" name="id" placeholder="id">
		<input id="input2" name="age" type="number" placeholder="age" >
		<!-- <input id="submit1" type="submit" value="전송"> -->	
		<button id="submit1">전송</button>
		
		<hr>
		
		<button id="button2">목록보기 </button>
		
		<table class="table" id="table1">
			<thead>
			<tr>
				<th>ID</th>
				<th>AGE</th>
			</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
</div>
</body>
</html>

