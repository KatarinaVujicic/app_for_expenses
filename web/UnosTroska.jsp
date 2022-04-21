<%-- 
    Document   : UnosTroska
    Created on : Feb 16, 2021, 12:36:32 PM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:templateSupervizor title="Home">
    <jsp:attribute name="content">



    </jsp:attribute>


</template:templateSupervizor>
<html>
    <head>
        <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Unos novog troška</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
                function validLogin() {
                if (document.f.naziv.value === "") {
                    alert("Greška prilikom čuvanja troška.");
                    document.loginform.userName.focus();
                    return false;
                }
                if (document.f.opis.value === "") {
                    alert("Greška prilikom čuvanja troška.");
                    document.userform.password.focus();
                    return false;
                }
               
                return true;
            }
        </script>
    </head>
    <body>
       <div class="container">
            <div id="formContent">
<div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card px-2 py-4" style="  width: 500px;
    background-color: #fff;
    border: none;
    border-radius: 12px;
    background-color: whitesmoke">
        
<legend><center><h2><b>Unos novog troška</b></h2></center></legend><br>

                    <!-- Login Form -->
                    <form action="./UnosNovogTroska" method="post" name="f"onsubmit="return validLogin();">
                        <input type="hidden" id="id" class="fadeIn second" name="id" placeholder="id">
                        <div class="form-group">
                            <label  for="NazivTroska">Naziv </label>
                            <input type="text" class="form-control" id="mm" placeholder="Unesite naziv" name="naziv" required="">
                        </div>
                        <div class="form-group">
                            <label for="VrstaTroska">Vrsta troška: </label>
                            <br/>
                            <select name="vrstaTroska">
                                <c:forEach items="${vr}" var="vr">
                                    <option value="${vr.vrstaTroskaID}"><c:out value="${vr.naziv}"></c:out> </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="datum">Datum: </label>
                            <input type="date" class="form-control" id="datum"  name="datum" required="">
                        </div>
                        <div class="form-group">
                            <label for="Opis">Opis: </label>
                            <input type=text class="form-control" id="opis" placeholder="Unesite opis" name="opis" >
                        </div>
                        <div class="form-group">


                            <c:forEach items="${listaZaVracanje}" var="zap">
                                <input type="hidden" id="idZap" class="fadeIn second" name="zaposleniId" placeholder="id" value="${zap.zaposleniId}">
                            </c:forEach>


                        </div>



                        <input type="submit" class="btn btn-primary" value="Zapamti"/>
             </form>  
            </div>
        </div>



    
    </div></div>
</body>
</html>
