<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>403 Access Denied</title>
</head>
<body>
<c:url var="logoutURL" value="/logout"/>
<form action="${logoutURL }" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-md btn-warning btn-block" type="Submit">Logout</button>
</form>
<h1>403</h1>
<h2>Sorry, you do not have permission to view this page.</h2>
</body>
</html>