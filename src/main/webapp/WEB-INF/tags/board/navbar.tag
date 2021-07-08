<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<c:url value="/board/list" var="listUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>



<c:url value="/board/register" var="registerUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>

<!-- 회원가입 페이지 ! -->
<c:url value="/member/signup" var="signUpUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>

<!-- 회원정보 페이지 ! -->
<c:url value="/member/info" var="memberInfoUrl">
	<c:if test="${not empty cri.pageNum }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
	</c:if>
	<c:if test="${not empty cri.amount }">
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
		<c:param name="keyword" value="${cri.keyword }"></c:param>
		<c:param name="type" value="${cri.type }"></c:param>
</c:url>


<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
  <a class="navbar-brand" href="${appRoot }/board/list">
  	<img alt="spring-log" width="110" src="${appRoot }/resources/img/spring-logo.svg">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="${listUrl }"><i class="fas fa-list"></i> 목록보기</a>
      </li>
       <sec:authorize access="isAuthenticated()">
	      <li class="nav-item">
	        <a class="nav-link" href="${registerUrl }"><i class="fas fa-pen"></i> 글쓰기</a>
	      </li>
      </sec:authorize>
      <%--
        security 연습용
        
      <li class="nav-item">
        <a class="nav-link" href="${appRoot}/secure/all">모두</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${appRoot}/secure/member">멤버만</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${appRoot }/secure/admin">어드민만</a>
      </li>
       
       --%>
      
<!-- 회원가입  -->
      <sec:authorize access="!isAuthenticated()">
	  	<li class="nav-item">
	  		<a class="nav-link" href="${signUpUrl }">회원가입</a>
	  	</li>
	  </sec:authorize>
    </ul>
  </div>
  
  <!-- 회원정보  -->
    <sec:authorize access="isAuthenticated()">
	  		<a class="btn btn-outline-success m-2" href="${memberInfoUrl }">회원정보</a>
	  </sec:authorize>
	  
	  
   <!--  로그인   -->
     <sec:authorize access="!isAuthenticated()">
		<a href="${appRoot }/member/login" class="btn btn-outline-success m-2">로그인</a>  
   </sec:authorize>
   
  <!--  로그아웃  -->
  				<!--  로그인한 사용자만 보이게  -->
 <sec:authorize access="isAuthenticated()">
	  <form action="${appRoot }/logout" method="post">
	  	<input type="submit" class="btn btn-outline-success  m-2" value="로그아웃">
	  </form>
  </sec:authorize>
  
  
  
  <!-- 검색  -->
  <form action="${listUrl }" method="get" class="form-inline">
  
    	<select name="type" class="form-control mr-sm-2">
    		<option value="">--</option>
    		<!-- 3항연산식  -->
    		<option value="T" ${cri.type == "T" ? 'selected' : '' }>제목 </option>
    		<option value="C" ${cri.type == "C" ? 'selected' : '' }>내용 </option>
    		<option value="W" ${cri.type == "W" ? 'selected' : '' }>작성자 </option>
    		<option value="TC" ${cri.type == "TC" ? 'selected' : '' }> 제목 or 내용 </option>
    		<option value="TW" ${cri.type == "TW" ? 'selected' : '' }>제목 or 작성자 </option>
    		<option value="TWC" ${cri.type == "TWC" ? 'selected' : '' }>제목 or 내영 or 작성자 </option>
    	</select>
    	<input name="keyword" value="${cri.keyword }" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    	
    	
  		<input type="hidden" name="pageNum" value="1">
  	  <input type="hidden" name="amount" value="${cri.amount }">
    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
  
</nav>
  <br>




