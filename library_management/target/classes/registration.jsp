<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<%--       <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
  </head>

  <body>

    <div class="container">

        <h2 class="form-signin-heading">Create your account</h2>
        <span style="color: red;">${error}</span>
        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <label>First Name</label>
            <spring:bind path="firstName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="firstName" class="form-control" placeholder="firstName"
                                autofocus="true"></form:input>
                    <form:errors path="firstName"></form:errors>
                </div>
            </spring:bind>
            
            <label>Last Name</label>
            <spring:bind path="lastName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="lastName" class="form-control" placeholder="lastName"
                                autofocus="true"></form:input>
                    <form:errors path="lastName"></form:errors>
                </div>
            </spring:bind>
            
            <label>Pather Name</label>
            <spring:bind path="patherName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="patherName" class="form-control" placeholder="patherName"
                                autofocus="true"></form:input>
                    <form:errors path="patherName"></form:errors>
                </div>
            </spring:bind>
            
            <label>Passport Seria</label>
            <spring:bind path="passportSeria">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="passportSeria" class="form-control" placeholder="passportSeria"
                                autofocus="true"></form:input>
                    <form:errors path="passportSeria"></form:errors>
                </div>
            </spring:bind>

			<label>Passport Num</label>
            <spring:bind path="passportNum">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passportNum" class="form-control" placeholder="passportNum"></form:input>
                    <form:errors path="passportNum"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>