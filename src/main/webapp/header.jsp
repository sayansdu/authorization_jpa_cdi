<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>EntityManager</title>
    <link rel="stylesheet" type="text/css" href="/EntityManager/css/style.css">

</head>
<body>
<div class="main">
    <div class="header">
        <span class="title">Authorization</span>
        <% if(session.getAttribute("current_user")==null) {%>
            <span class="sign"><a class="in" href="/EntityManager/sign_in">sign in</a> / <a class="up" href="/EntityManager/sign_up">sign up</a></span>
        <%} else {%>
            <span class="sign"><a class="up" href="/EntityManager/sign_out">sign out</a></span>
        <%}%>
    </div>
    <hr>