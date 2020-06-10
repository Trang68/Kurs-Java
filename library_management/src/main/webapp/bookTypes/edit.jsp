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
		<span style="color: red;">${error}</span>
	 	<form:form method="POST" modelAttribute="bookTypeForm"  action="/bookTypes/save">
	 		<form:input path="id" type="hidden"/>
            <label>Name</label>
            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="name" class="form-control" placeholder="name"
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
                </div>
            </spring:bind>
            
            <label>CNT</label>
            <spring:bind path="cnt">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="cnt" class="form-control" placeholder="cnt"
                                autofocus="true"></form:input>
                    <form:errors path="cnt"></form:errors>
                </div>
            </spring:bind>
            
            <label>Fine</label>
            <spring:bind path="fine">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="fine" class="form-control" placeholder="fine"
                                autofocus="true"></form:input>
                    <form:errors path="fine"></form:errors>
                </div>
            </spring:bind>
            
            <label>Day count</label>
            <spring:bind path="dayCount">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="dayCount" class="form-control" placeholder="dayCount"
                                autofocus="true"></form:input>
                    <form:errors path="dayCount"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
	</div>
</body>
</html>