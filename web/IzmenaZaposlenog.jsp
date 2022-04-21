<%-- 
    Document   : IzmenaZaposlenog
    Created on : Dec 7, 2020, 2:42:47 PM
    Author     : Katarina
--%>

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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="resources/cssFile.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   
      <link href = "/bootstrap/css/bootstrap.min.css" rel = "stylesheet">
      <script src = "/scripts/jquery.min.js"></script>
      <script src = "/bootstrap/js/bootstrap.min.js"></script>
            <script>
            function validLogin() {
                if (document.f.username.value === "") {
                    alert("Molimo unesite e-mail.");
                    document.loginform.userName.focus();
                    return false;
                }
                if (document.f.password.value === "") {
                    alert("Molimo unesite password.");
                    document.userform.password.focus();
                    return false;
                }
                alert("Uspešno ste izmenili zaposlenog.");
                return true;
            }</script>
    <body>
    <div class="container" >

            <div id="formContent">
                 
<div class="container mt-5 mb-5 d-flex justify-content-center">
    
    <div class="card px-2 py-4" style="  width: 815px;
    background-color: #fff;
    
    border: none;
    border-radius: 12px;
    background-color: whitesmoke"
    >
        <h3>Zaposleni:</h3>
        <br/>
       
                <!-- Login Form -->
                <form action="./IzmenaZaposlenogServlet" method="post" name="f" onsubmit="return validLogin();">
                   <c:forEach items="${selektovani}" var="zap">
                       <input type="hidden" id="id" class="fadeIn second" name="idZap" placeholder="id" value="${zap.zaposleniId}">
                    <div class="form-group">
                       
                        <label for="Ime">Ime: </label>
                         
                              <input type="text" class="form-control" id="ime" placeholder="Unesite prezime" name="ime" required="" value="${zap.ime}">
                         
                        
                        
                    </div>
                    <div class="form-group">
                        <label for="Prezime">Prezime: </label>
                        <input type="text" class="form-control" id="prezime" placeholder="Unesite prezime" name="prezime" required=""value="${zap.prezime}">
                    </div>
                    <div class="form-group">
                        <label for="JMBG">JMBG: </label>
                        <input type="text" class="form-control" id="JMBG" placeholder="Unesite JMBG" name="JMBG" required=""value="${zap.jmbg}">
                    </div>
                    <div class="form-group">
                        <label for="Username">Username: </label>
                        <input type="text" class="form-control" id="username" placeholder="Unesite username" name="username" required=""value="${zap.username}">
                    </div>
                    <div class="form-group">
                        <label for="Password">Password: </label>
                        <input type="password" class="form-control" id="password" placeholder="Unesite password" name="password" required=""value="${zap.password}">
                    </div>
                    <label for="Tip">Tip:</label></br>
                    Trenutni tip: ${zap.tip.naziv}</br>
                    <select name="tip">
                        <c:forEach items="${tip}" var="tip">
                            <option value="${tip.tipID}"><c:out value="${tip.naziv}"></c:out> </option>
                        </c:forEach>
                    </select>
                    </c:forEach>
                    <input type="submit"  value="Zapamti" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
             </form>
    </div></div></div></div>
         <script type="text/javascript">
           
   alert('Sistem je učitao podatke o zaposlenom');</script>
         
    </body>
</html>
