<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Sign in with Facebook example</title>
</head>
<body>

<tag:loggedin>
<hr>
<h1>LOGGED</h1>
</tag:loggedin>

<p>Login flow for Web Applications:</p>
<a href="signin"><img src="./assets/login-with-facebook.png" alt="Sign in with Facebook"></a>



<tag:loggedin>

    <a href="tokenInfo" target="_blank">Access Token Info</a>
    <hr/>
    <form action="./post" method="post">
        <textarea cols="80" rows="2" name="message"></textarea>
        <input type="submit" name="post" value="statuses"/>
    </form>
    <hr>
    <a href="./logout">logout</a>

</tag:loggedin>
</body>
</html>