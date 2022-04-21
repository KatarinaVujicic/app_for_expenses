<%-- 
    Document   : UnosTroska
    Created on : Feb 16, 2021, 12:36:32 PM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:template title="Home">
    <jsp:attribute name="content">

        

    </jsp:attribute>


</template:template>
<html>
    <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   
      <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
      <script src = "/scripts/jquery.min.js"></script>
      <script src = "/bootstrap/js/bootstrap.min.js"></script>
        <title>Unos novog troška</title>
        <script>
            function validLogin() {
                if (document.f.naziv.value === "") {
                    alert("Neuspešna izmena troska");
                    document.loginform.userName.focus();
                    return false;
                }
              
                alert("Uspešno ste se izmenili trošak.");
                return true;
            }</script>
    </head>
    <body >
        
         <div class="wrapper fadeInDown">
            <div id="formContent">
<div class="container mt-5 mb-5 d-flex justify-content-center">
    
    <div class="card px-2 py-4" style="  width: 815px;
    background-color: #fff;
    
    border: none;
    border-radius: 12px;
    background-color: whitesmoke"
    >
        <h3>Trosak:</h3>
        <br/>
     

                <!-- Login Form -->
                <form action="./IzmenaTroskovaServlet" method="post" name="f" onsubmit="return validLogin();">
                    <c:forEach var="tr"items="${selektovaniTrosakZaIzmenu}">
                        <input type="hidden" id="id" class="fadeIn second" name="trID" placeholder="id" value="${tr.trosakID}">
                    <div class="form-group">
                        <label for="NazivTroska">Naziv </label>
                        <input class="form-control" id="mm" placeholder="Unesite naziv" name="naziv" value="${tr.naziv}">
                       
                    </div>
                     <div class="form-group">
                        <label for="datum">Datum izmene troska: </label>
                        <input type="date" class="form-control" id="datum"  name="datum" required="" >
                    </div>
                   
                    <div class="form-group">
                        <label for="Opis">Opis: </label>
                        <input  class="form-control" id="opis" placeholder="Unesite opis" name="opis"value="${tr.opis}" >
                    </div>
                        <div class="form-group">
                      
                            <input type="hidden"  class="form-control" id="vt"  name="vt"value="${tr.vrstaTroska.vrstaTroskaID}" >
                    </div>
                     </c:forEach>
                      
                    <div class="form-group">
                        
                       
                         <c:forEach items="${listaZaVracanje}" var="zap">
                             <input type="hidden"  id="idZap" class="fadeIn second" name="zaposleniId" placeholder="id" value="${zap.zaposleniId}">
                        </c:forEach>
                        
                        
                    </div>
                     <div class="form-group">
                        <label for="StatusTroska">Izaberite status: </label>
                         <select name="StatusTroska">
                        <c:forEach items="${st1}" var="stat">
                              <option value="${stat.statusID}"><c:out value="${stat.naziv}"></c:out> </option>
                        </c:forEach>
                         </select>
                    </div>
                   
                   
                    <input type="submit"  value="Zapamti"/>

                    
                    
                       
                </form>
    </div></div></div></div>
        <script>
var date = new Date();
var currentDate = date.toISOString().slice(0,10);
var currentTime = date.getHours() + ':' + date.getMinutes();

document.getElementById('datum').value = currentDate;
</script>
                 <script type="text/javascript">
           
   alert('Sistem je uspešno pronašao trošak');</script>

    </body>
</html>
