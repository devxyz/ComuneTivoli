<%--
  Created by IntelliJ IDEA.
  User: stefano
  Date: 27/03/16
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<a href="/LoadExternalDataServlet" target="_blank">LoadExternalDataServlet (ALL)</a><br>
<hr>
<a href="/ResetDataServlet" target="_blank">ResetDataServlet</a><br>
<hr>
<a href="/PrintNotizieServlet" target="_blank">PrintNotizieServlet (stampa estesa)</a><br>
<hr>
<a href="/ReportNotizieServlet" target="_blank">ReportNotizieServlet (stampa sintetica)</a><br>
<hr>
<a href="/JSonDataRequestServlet?param" target="_blank">JSonDataRequestServlet</a><br>
<hr>
Load Data from token
<form action="/PrintNotizieServlet" target="_blank">
    Last news number: <input name="LAST" type="text" maxlength="20">
    <input type="submit" value="Start">
</form>
<hr>
</body>
</html>
