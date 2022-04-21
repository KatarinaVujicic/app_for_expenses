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
        <title>Unos novog racuna</title>
      
         <script>
                function validLogin() {
                if (document.f.brojRacuna.value === "") {
                    alert("Greška prilikom čuvanja računa.");
                    document.loginform.userName.focus();
                    return false;
                }
              
                alert("Uspešno ste kreirali novi račun.");
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
        
<legend><center><h2><b>Prikaz racuna</b></h2></center></legend><br>
<form action="./UnosRacuna" method="post" name="f" onsubmit="return validLogin();">
  <c:forEach var="r"items="${selektovaniRacun}">
                        <input type="hidden" id="id" class="fadeIn second" name="id" placeholder="id">
                        <div class="form-group">
                            <label for="BrojRacuna">Broj racuna: </label>
                            <input type="text" class="form-control" id="br"  name="brojRacuna" placeholder="Broj racuna" value="${r.RBRacuna}" >

                        </div>
                        <div class="form-group">
                            <label for="datum">Datum: </label>
                            <input type="date" class="form-control" id="datum"  name="datum" required="" value="${r.datum}">
                        </div>
                        <div class="form-group">
                            <label for="Ukupan iznos">Ukupan iznos: </label>
                            <input type="text" class="form-control" id="ui" placeholder="Ukupan iznos računa" name="ui" required=""value="${r.ukupanIznos}">

                        </div>

                        <c:forEach items="${selektovaniTrosak}" var="tr">

                            <div class="form-group">



                                <input type="hidden" id="idZap" class="fadeIn second" name="idZap" placeholder="id" value="${tr.zaposleni.zaposleniId}">



                            </div>

                            <div class="form-group">



                                <input type="hidden" id="idTroska" class="fadeIn second" name="trosakID" placeholder="id" value="${tr.trosakID}">

                            </div>


                        </c:forEach>
                       


  </c:forEach>

                    </form>
<script type="text/javascript">
           
   alert('Uspešno je učitan traženi račun');</script>
                 </div>
</div></div></div>
         <script>
var date = new Date();
var currentDate = date.toISOString().slice(0,10);
var currentTime = date.getHours() + ':' + date.getMinutes();

document.getElementById('datum').value = currentDate;
</script>
    </body>
</html>
