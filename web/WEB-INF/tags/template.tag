<%-- 
    Document   : template
    Created on : Oct 23, 2020, 1:28:23 PM
    Author     : Katarina
--%>

<%@tag language="java" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true" rtexprvalue="true" %>
<%@attribute name="content" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional// EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- any content can be specified here e.g.: --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <title>Navbar</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
 <div class="test" style="background-image:  url('https://eskipaper.com/images/engineering-4.jpg'); height: 100%; width: 100%; position: fixed; opacity: 
             0.3; z-index: -1;"></div>
        <nav class="navbar navbar-expand-sm   navbar-light bg-light" >
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
           
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03" >
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item">


                    <li class="nav-item dropdown dmenu bg-light">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Rad sa zaposlenima
                        </a>
                        <div class="dropdown-menu sm-menu bg-light" >
                            <a class="dropdown-item" href="./unos">Unos novog zaposlenog</a>
                            <a class="dropdown-item" href="./pretraga">Pretraga zaposlenih</a>

                        </div>
                    </li>
                    <li class="nav-item dropdown dmenu bg-light">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Rad sa troškovima
                        </a>
                        <div class="dropdown-menu sm-menu bg-light">
                          <c:forEach var="zap" items="${listaZaVracanje}">
                                 <a class="dropdown-item" href="./pretragaTroskova?zaposleniId=${zap.zaposleniId}">Pretraga troškova</a></c:forEach>
                                   <a class="dropdown-item" href="./PretragaSvihRacuna">Pretraga računa</a>
                        </div>
                        
                    </li>
                    
                       
                  
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('.navbar-light .dmenu').hover(function () {
                                $(this).find('.sm-menu').first().stop(true, true).slideDown(150);
                            }, function () {
                                $(this).find('.sm-menu').first().stop(true, true).slideUp(105);
                            });
                        });
                    </script>
                  
                </ul>
               <a class="close" style="float: right" href="./LogoutServlet">Logout</a>
            </div>
        </nav>
       
             
           <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-1 px-1 px-xl-2 bg-secondary" style="clear: both;
    border: 1px groove #aaaaaa;
    background: blue;
    color: White;
    padding: 0;
    text-align: center;
    vertical-align: middle;
    line-height: normal;
    margin: 0;
    z-index: 1;
    position: fixed;
    bottom: 0px;
    width: 100%;" >
    <!-- Copyright -->
    <div class="text-white mb-3 mb-md-0 " >
      Copyright © 2022. All rights reserved.
    </div>
    <!-- Copyright -->

  
  </div>
    </body>
    <jsp:invoke fragment="content"></jsp:invoke>
</body>
</html>

