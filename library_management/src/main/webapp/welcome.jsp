<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
  <div class="container">
  		<h2>Menu</h2>
		<a href="/bookTypes/list">List Book Types</a>
		<br>
		<a href="/books/list">List Book</a>
		<br>
		<a href="/books/borrow">Borrow Book</a>
		<br>
		<a href="/journal/list">Journal List</a>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>