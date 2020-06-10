<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Types</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">
	<span style="color:red;">${error}</span>
	<table class="table">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Book Name</th>
	        <th>Client</th>
	         <th>Fullname</th>
	        <th>Date_BEG</th>
	        <th>Date_END</th>
	        <th>Date_RET</th>
	        <th></th>
<!-- 	        <th></th> -->
	      </tr>
	    </thead>
	    <tbody>
	   		<c:forEach items="${listJournal}" var="item">
		      <tr>
		        <td>${item.id}</td>
		        <td>${item.bookName}</td>
		        <td>${item.client}</td>
		        <td>${item.fullName}</td>
		        <td>${item.dateBeg}</td>
		        <td>${item.dateEnd}</td>
		        <td>${item.dateRet}</td>
		        <c:if test="${pageContext.request.userPrincipal.name == item.client && item.dateRet == null}">
		        	<td><a href="/journal/returnBook?id=${item.id}">Return Book</a></td>
		        </c:if>
<%-- 		        <td><a href="/journal/delete?id=${item.id}">Delete</a></td> --%>
		      </tr>
		    </c:forEach>
	    </tbody>
	  </table>
	  <br>
	</div>
	
</body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 </script>
</html>