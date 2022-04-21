<%-- 
    Document   : proba
    Created on : Oct 25, 2020, 2:35:34 PM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:template title="Home">
    <jsp:attribute name="content">



    </jsp:attribute>


</template:template>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
         <link rel="stylesheet" href="resources/cssFile.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>Početna strana</title>
    </head>
    <body>
        <% String message = (String)request.getAttribute("alertMsg");%>
   
        <c:forEach items="${listaZaVracanje}" var="zap">
            <h1>Dobrodošli!</h1>
            </br> Zaposleni:<p> ${zap.ime} ${zap.prezime}</p>
        </c:forEach>
        
        
    </body>
</html>
