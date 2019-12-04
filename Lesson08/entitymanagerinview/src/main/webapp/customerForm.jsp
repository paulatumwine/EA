<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 6/30/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>
<form action="customer" method="post">
    Customer name:<br>
    <input type="text" name="name" value="John Brown">
    <br>
    Street:<br>
    <input type="text" name="street" value="1000 N 4th St">
    <br>
    City:<br>
    <input type="text" name="city" value="Fairfield">
    <br>
    State:<br>
    <input type="text" name="state" value="IA">
    <br>
    Zipcode:<br>
    <input type="text" name="zip" value="52556">
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
