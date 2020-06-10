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
	<table class="table">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>NAME</th>
	        <th>CNT</th>
	        <th>FINE</th>
	        <th>DAY COUNT</th>
	        <th></th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   		<c:forEach items="${listBookTypes}" var="item">
		      <tr>
		        <td>${item.id}</td>
		        <td>${item.name}</td>
		        <td>${item.cnt}</td>
		        <td>${item.fine}</td>
		        <td>${item.dayCount}</td>
		        <td><a href="/bookTypes/edit?id=${item.id}">Edit</a></td>
		        <td><a href="/bookTypes/delete?id=${item.id}">Delete</a></td>
		      </tr>
		    </c:forEach>
	    </tbody>
	  </table>
	  <br>
		<a href="/bookTypes/add">Add new Book Type</a>
	</div>
	
</body>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
 <script type="text/javascript">
 </script>
</html>