<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home Page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:url var="logoutURL" value="/logout"/>
<form action="${logoutURL }" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-md btn-warning btn-block" type="Submit">Logout</button>
</form>

<div class="container">

    <p>
        <sec:authorize access="isAuthenticated()">
            Welcome Back, <sec:authentication property="name"/>
        </sec:authorize>
    </p>
</div>

<div class="container">
    <sec:authorize access="isRememberMe()">
        <h2># This user is login by "Remember Me Cookies".</h2>
    </sec:authorize>

    <sec:authorize access="isFullyAuthenticated()">
        <h2># This user is login by username / password.</h2>
    </sec:authorize>
</div>

</body>
</html>