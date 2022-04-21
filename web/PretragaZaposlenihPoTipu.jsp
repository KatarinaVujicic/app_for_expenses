<%-- 
    Document   : PretragaZaposlenihPoTipu
    Created on : Dec 3, 2021, 11:02:27 AM
    Author     : Katarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="pretraga" method="post">
             <label for="Ime">Ime: </label>
                        <input type="text" class="form-control" id="ime" placeholder="Unesite ime" name="ime" required="">
                       
         <label for="Tip">Tip:</label></br>
                    <select name="tip">
                        <c:forEach items="${tip}" var="tip">
                            <option value="${tip.tipID}"><c:out value="${tip.naziv}"></c:out> </option>
                       </c:forEach>
                    </select>
                            <a href="./pretraga?tipID=${tip.tipID}" >Trazi</a>
         
        </form>
    </body>
</html>
