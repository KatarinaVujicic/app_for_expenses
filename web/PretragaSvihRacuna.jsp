<%-- 
    Document   : PretragaSvihRacuna
    Created on : Dec 28, 2021, 12:11:39 PM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:template title="Home">
    <jsp:attribute name="content">

      

    </jsp:attribute>


</template:template>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>Pretraga računa</title>
        <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
        <script src = "/scripts/jquery.min.js"></script>
        <script src = "/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    </head>
    <body>
         <div class="container">

              <div class="container mt-5 mb-5 d-flex justify-content-center">
    <div class="card px-2 py-4" style="  width: 815px;
    background-color: #fff;
    
    border: none;
    border-radius: 12px;
    background-color: whitesmoke"
    >

            <form action="./PretragaSvihRacuna" method="post">
                   <h3 style="text-align: center;">Unesite vrednosti za pretragu računa:</h3>
                  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Pretraži račune">
 
<br/>
<br>
                <table id="myTable" class="table table-striped table-responsive ">
                    <thead class="thead-dark">
                        <tr>
                           <th></th>
                        <th >Broj računa</th>
                        <th >Datum</th>
                        <th >Ukupan iznos</th>
                        <th >Zaposleni</th>
                        <th >Trošak</th>
                     <th>Prikaz</th>
                        </tr>
                    </thead>
                    <tbody >
                      <c:forEach items="${listaRacuna}" var="lr">    
                        <tr>

                            <td><input type="hidden"  value="${lr.brojRacuna}"/></td>
                            <td> <input type="hidden"  id="rb"  name="rb" value="${lr.RBRacuna}"/>${lr.RBRacuna}</td>
                            
                            <td> <input type="hidden"id="datum"  name="datum" value="${lr.datum}"  />${lr.datum}</td>
                            <td> <input type="hidden"  id="ui"  name="ui" value="${lr.ukupanIznos}"  />${lr.ukupanIznos}</td>
                            <td> <input type="hidden"  id="zaposleni"  name="zaposleni" value="${lr.zaposleni.ime}"    />${lr.zaposleni.ime} ${lr.zaposleni.prezime}</td>
                            <td><input type="hidden"  id="trosak"  name="trosak" value="${lr.trosak.naziv}"   />${lr.trosak.naziv}</td>
                            <td> <a class="btn btn-primary btn-sm" href="./VracanjeZaRacun?rID=${lr.brojRacuna}" >Prikaži</a></td>
                            

                            
                            




                        </tr>
                    </c:forEach>

                    </tbody>

                </table>

            </form>


    </div></div></div>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
    
  });
});
</script> 


    </body>
</html>
