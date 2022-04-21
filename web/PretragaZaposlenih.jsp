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
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>Pretraga zaposlenih</title>
        <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
        <script src = "/scripts/jquery.min.js"></script>
        <script src = "/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 
    </head>
    <body>


        <div class="container" >

            <div id="formContent">
                <div class="container mt-5 mb-5 d-flex justify-content-center">
                    <div class="card px-2 py-4" style="  width: 700px;
                         background-color: #fff;

                         border: none;
                         border-radius: 12px;
                         background-color: whitesmoke"
                         >

                        <form action="./pretraga" method="post">
                            <h3 style="text-align: center;">Unesite vrednosti za pretragu zaposlenih:</h3>
                            <input type="text" class="form-control" id="myInput"  placeholder="Pretrazi zaposlene" style="align-self:  center;">

                            <br/>
                            <br>
                            <table id="myTable" class="table table-striped table-responsive " >
                                <thead class="thead-dark">
                                    <tr>
                                        <th></th>
                                        <th >Ime</th>
                                        <th >Prezime</th>
                                        <th >JMBG</th>
                                        <th >Username</th>
                                     
                                        <th>Tip </th>
                                        <th>Izmena</th>
                                        <th>Brisanje</th>
                                    </tr>
                                </thead>
                                <tbody >
                                    <c:forEach items="${lista}" var="zaposleni">    
                                        <tr>

                                            <td><input type="hidden"  value="${zaposleni.zaposleniId}"/></td>
                                            <td> <input type="hidden"  id="ime"  name="imeZaposlenog" value="${zaposleni.ime}"/>${zaposleni.ime}</td>
                                            <td><input type="hidden" id="prezime"  name="prezime" value="${zaposleni.prezime}" />  ${zaposleni.prezime}     </td>
                                            <td> <input type="hidden"id="JMBG"  name="JMBG" value="${zaposleni.jmbg}"  />${zaposleni.jmbg}</td>
                                            <td> <input type="hidden"  id="username" type="email" name="username" value="${zaposleni.username}"  />${zaposleni.username}</td>
                                           
                                            <td><input type="hidden"  id="tip"  name="tip" value="${zaposleni.tip.naziv}"   />${zaposleni.tip.naziv}</td>

                                            <td><a class="btn btn-primary btn-sm" href="./testServlet?ZaposleniId=${zaposleni.zaposleniId}" >Izmeni</a></td>


                                            <td><a class="btn btn-primary btn-sm" href="./brisanje?zaposleniId=${zaposleni.zaposleniId}">Obrisi</a></td>



                                        </tr>
                                    </c:forEach>

                                </tbody>

                            </table>

                        </form>


                    </div>
                </div>
            </div> </div>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                    
                });
            });
        </script> 



    </body>
</html>
