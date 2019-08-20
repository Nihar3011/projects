<%-- 
    Document   : home
    Created on : 2 Feb, 2019, 3:27:50 PM
    Author     : nihar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Argus</title>
    </head>
    <body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">CRUD</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/list/student">Students</a></li>
                
                 <li><a href="/extra">view</a></li>
                
                <li><form:form method="POST" action="${pageContext.request.contextPath}/logout">
                        <input type="submit" value="Logout"/>
                    </form:form></li>
            </ul>
        </div>
    </nav>
   
    <h1>Welcome to CRUD with SpringBoot,JPA and Security</h1>
</body>
</html>

