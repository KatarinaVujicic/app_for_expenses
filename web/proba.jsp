<%-- 
    Document   : PretragaZaposlenih
    Created on : Nov 22, 2020, 12:59:39 PM
    Author     : Katarina
--%>



<%@page import="domen.Zaposleni"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:template title="Home">
    <jsp:attribute name="content">

        <a href="PretragaZaposlenih.jsp"></a>

    </jsp:attribute>


</template:template>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
        <script src = "/scripts/jquery.min.js"></script>
        <script src = "/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    </head>
    <body>

       
        <div class="container">
<h1>Idite na stranu za pretragu. </h1>
            
<td><a class="btn btn-primary " href="./pretraga" >Pretraga</a></td>
        </div>




    </body>
</html>
