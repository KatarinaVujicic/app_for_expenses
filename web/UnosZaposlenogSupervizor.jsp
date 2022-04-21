<%-- 
    Document   : ajde
    Created on : Oct 25, 2020, 1:50:13 PM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:templateSupervizor title="Home">
    <jsp:attribute name="content">



    </jsp:attribute>


</template:templateSupervizor>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
         <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Unos novog zaposlenog</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<legend><center><h2><b>Unos novog zaposlenog</b></h2></center></legend><br>


                <!-- Login Form -->
                <form action="UnosZaposlenogSupervizor" method="post">
                    <input type="hidden" id="id" class="fadeIn second" name="id" placeholder="id">
                    <div class="form-group">
                        <label for="Ime">Ime: </label>
                        <input type="text" class="form-control" id="ime" placeholder="Unesite ime" name="ime" required="">
                        <div class="invalid-feedback">
                            Please choose a username.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Prezime">Prezime: </label>
                        <input type="text" class="form-control" id="prezime" placeholder="Unesite prezime" name="prezime" required="">
                    </div>
                    <div class="form-group">
                        <label for="JMBG">JMBG: </label>
                        <input type="text" class="form-control" id="JMBG" placeholder="Unesite JMBG" name="JMBG" required="">
                    </div>
                    <div class="form-group">
                        <label for="Username">Username: </label>
                        <input type="text" class="form-control" id="username" placeholder="Unesite username" name="username" required="">
                    </div>
                    <div class="form-group">
                        <label for="Password">Password: </label>
                        <input type="password" class="form-control" id="password" placeholder="Unesite password" name="password" required="">
                    </div>
                     <div class="form-group">
                        <label for="Tip">Tip: </label>
                        <input type="tip" class="form-control" id="tip"  name="tip" value="Zaposleni">
                    </div>
                   
                    <input type="button"  value="Zapamti" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">

                    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Sačuvaj zaposlenog</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Da li ste sigurni da zelite da sačuvate zaposlenog?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Odustani</button>
                                    <button type="submit" class="btn btn-primary"> Sačuvaj</button>
                                </div>
                            </div>
                        </div>
                       
                </form>
 </div></div>
</div></div>
                </body>
                </html>
