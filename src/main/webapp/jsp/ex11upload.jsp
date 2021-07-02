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
	<h1> 파일 업로드 </h1>
	
	<%-- 파일전송할때 항상 post로 전송해야하면   enctype속성 존재해야하고 값은 multipart/form-data 이거!   --%>
		<form action="${appRoot }/upload/sub01" method="post" enctype="multipart/form-data">
			fname : <input name="fname" value="soobin" /> <br>
			file : <input type="file" name="upfile" accept="image/*" />
			<input type="submit" value="upload"> 
			
		</form>
		
		<hr>
		
		<form action="${appRoot }/upload/sub02" method="post" enctype="multipart/form-data">
			name :<input name="name" value="donala"/><br>
			file: <input type="file" name="file" accept="image/*" /> 
			<input type="submit" value="upload">
			
		</form>
		
	</div>
</body>
</html>