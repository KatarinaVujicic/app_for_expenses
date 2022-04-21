<%-- 
    Document   : template1
    Created on : Jan 26, 2021, 9:57:25 AM
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
       <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

        <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
        
        <script src = "/scripts/jquery.min.js"></script>
        <script src = "/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <title>Pretraga troskova</title>
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
        <form action="./pretragaTroskova" method="post">
  <h3 style="text-align: center;">Unesite vrednosti za pretragu troškova:</h3>
                <input type="text" class="form-control" id="myInput"  placeholder="Pretrazi troškove" style="align-self:  center;">
 
<br/>
<br>


            <table id="myTable" class="table table-striped table-responsive ">
                <thead class="thead-dark">
                    <tr>
                        <th></th>
                        
                        <th >Naziv</th>
                        <th >Vrsta troska</th>
                        <th >Datum</th>
                        <th >Opis</th>
                        <th >Zaposleni</th>
                        <th>Status troska </th>
                        <th>Izmena</th>
                        <th>Brisanje</th>
                    </tr>
                </thead>
                <tbody >
                    <c:forEach items="${lista}" var="t">    
                        <tr>

                          <td><input type="hidden"  value="${t.trosakID}"/></td>
                                <td> <input type="hidden"  id="naziv"  name="naziv" value="${t.naziv}"/>${t.naziv}</td>
                                <td><input type="hidden" id="vrsta"  name="vrsta" value="${t.vrstaTroska.naziv}" />  ${t.vrstaTroska.naziv}     </td>
                                <td> <input type="hidden"id="datum"  name="datum" value="${t.datum}"  />${t.datum}</td>
                                <td> <input type="hidden"  id="opis"  name="opis" value="${t.opis}"  />${t.opis}</td>
                                <td> <input type="hidden"  id="zaposleni"  name="zaposleni" value="${t.zaposleni.ime}"    />${t.zaposleni.ime} ${t.zaposleni.prezime}</td>
                                <td><input type="hidden"  id="odobren"  name="odobren" value="${t.statusTroska.naziv}"   />${t.statusTroska.naziv}</td>

                           
                            <td><a class="btn btn-primary btn-sm" href="./VracanjeZaIzmenuTroskaServlet?trID=${t.trosakID}" style="display: block" >Izmeni</a>
                            </td>
                             
                                <td><a class="btn btn-primary btn-sm" href="./ObrisiTrosakServlet?troID=${t.trosakID}">Obrisi</a></td>

                       






                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </form>
  </div></div></div>
           </div>
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
