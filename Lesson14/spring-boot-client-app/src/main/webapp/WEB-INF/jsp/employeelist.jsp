<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Get Employees</title>
</head>
<body>
<h3 style="color: red;">Get Employee Info</h3>

<div id="getEmployees">

    <form action="http://localhost:8080/oauth/authorize" method="post">
        <p>
            <label>Response Type</label>
            <input type="text" name="response_type" value="code"/>
        </p>
        <p>
            <label>Client Id</label>
            <input type="text" name="client_id" value="cs544"/>
        </p>
        <p>
            <label>Redirect URL</label>
            <input type="text" name="redirect_uri" value="http://localhost:8090/showEmployees"/>
        </p>
        <p>
            <label>Scope</label>
            <input type="text" name="scope" value="read"/>
        </p>

        <input type="SUBMIT" value="Get Employee info"/>
    </form>
</div>
</body>
</html>