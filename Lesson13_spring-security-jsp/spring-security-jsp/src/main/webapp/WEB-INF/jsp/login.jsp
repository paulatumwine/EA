<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>

<div class="container">

    <form action="login" method="POST" class="form-signin">
        <h3 class="form-signin-heading">Welcome</h3>
        <br/>
        <input type="text" id="email" name="email" placeholder="Email" class="form-control"/> <br/>
        <input type="password" placeholder="Password" id="password" name="password" class="form-control"/> <br/>

        <c:if test="${param.error}">
            <p style="font-size: 20; color: #FF1C19;">Email or Password
                invalid, please verify</p>
        </c:if>
        <input type='checkbox' name="remember-me"/>Remember Me? <br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" name="Submit"
                value="Login" type="Submit">Login
        </button>
    </form>
</div>
</body>
</html>