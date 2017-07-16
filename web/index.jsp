<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 16/06/2017
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Tesis Market</title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilos.css">
</head>
  <body>
  <header>
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toagle="collapse" data-target="#navegacion-fm">
            <span class="sr-only">Desplegar / Ocultar Menu</span>
            <span class="icon-bar" ></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand"><img src="img/logo.png" width="250px"/></a>
        </div>
        <!-- Inicia Menú -->
        <div class="collapse navbar-collapse" id="navegacion-fm">
          <ul class="nav nav-pills pull-right">
            <li><a href="login.jsp">Ingresar</a></li>
            <li><a href="registro.jsp">Registro</a></li>
            <li><a href="#">Ayuda</a></li>
            <li role="presentation" class="active"><a href="#">Dar clases particulares</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </header>

  <!-- Aqui va el jumbotrom -->
  <section class="jumbotron">
    <div class="container">
    <h2 align="center" style="color: #fff; font-size: 35px;"><strong>¡Encuentra<br>a tu acesor ideal!</strong></h2>
    </div>
  </section>

  <!-- Aqui van los pasos -->
  <div style="background:#0078d1;">
    <div class="container">
      <div>
        <div class="container" style="margin-top: 40px;">
          <h2 align="left" style="color: #f1f1f1; font-size: 38px;"><strong>Eficaz,<br>rápido, gratuito</strong></h2>
          <h3 align="left" style="color: #f1f1f1; font-size: 25px; margin-top: -10px;">Aprende en total confianza</h3><br><br>
        </div>
        <article class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="margin-bottom: 40px;">
          <p>
            <img src="img/icon-encu-01.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-xs">
            <img src="img/icon-encu-01.png" align="left" height="60px" style="margin-bottom: 10px"  class="visible-sm">
            <img src="img/icon-encu.png" align="left" height="45px" style="margin-bottom: 10px"  class="visible-md">
            <img src="img/icon-encu.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-lg">
            <h3 style="color: #f1f1f1; font-size: 23px; margin-bottom: 0"><strong>Encuentra</strong></h3>
            <p style="font-size: 17px; color: #f1f1f1;">la joya entre perfiles titulados, evaluados y disponibles.</p>
          </p>
        </article>

        <article class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="margin-bottom: 40px;">
          <p>
            <img src="img/icon-reserv-01.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-xs">
            <img src="img/icon-reserv-01.png" align="left" height="60px" style="margin-bottom: 10px"  class="visible-sm">
            <img src="img/icon-reserv.png" align="left" height="45px" style="margin-bottom: 10px"  class="visible-md">
            <img src="img/icon-reserv.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-lg">
          <h3 style="color: #f1f1f1; font-size: 23px; margin-bottom: 0px"><strong>Reserva</strong></h3>
          <p style="font-size: 17px; color: #f1f1f1;">tu clase hoy mismo. Obtendrás respuesta muy pronto.</p>
          </p>
        </article>

        <article class="col-xs-12 col-sm-12 col-md-4 col-lg-4" style="margin-bottom: 40px;">
          <p>
            <img src="img/icon-liber-01.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-xs">
            <img src="img/icon-liber-01.png" align="left" height="60px" style="margin-bottom: 10px"  class="visible-sm">
            <img src="img/icon-liber.png" align="left" height="45px" style="margin-bottom: 10px"  class="visible-md">
            <img src="img/icon-liber.png" align="left" height="55px" style="margin-bottom: 10px"  class="visible-lg">
          <h3 style="color: #f1f1f1; font-size: 23px; margin-bottom: 0px"><strong>En total libertad </strong></h3>
          <p style="font-size: 17px; color: #f1f1f1;">trabajas en directo, al mejor precio y sin intermediarios.</p>
          </p>
        </article>
        <br>
      </div>
    </div>
  </div>
  <div>
      <div>
          <div class="container">
              <div>
                  <div class="container" style="margin-top: 40px; margin-bottom: 15px;">
                      <h2 align="left" style="color: #303030; font-size: 38px;"><strong>Graduate,<br>lo que quieras</strong></h2>
                      <p align="left" style="color: #303030; font-size: 17px;">Domina el arte de la caligrafía o las olas <br>cuando hagas surf.<br>¡Vive nuevas aventuras!</p><br><br>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <div>
      <div class="container">
          <div id="carousel-1" class="carousel slide" data-rode="carousel">
              <!-- indicadores -->
              <ol class="carousel-indicators">
                  <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
                  <li data-target="#carousel-1" data-slide-to="1"></li>
                  <li data-target="#carousel-1" data-slide-to="2"></li>
                  <li data-target="#carousel-1" data-slide-to="3"></li>
              </ol>
              <!-- contenedor slide -->
              <div class="carousel-inner" role="listbox">
                  <div class="item active">
                      <img src="img/slide-01.png" class="img-responsive" alt="">
                  </div>
                  <div class="item">
                      <img src="img/slide-02.png" class="img-responsive" alt="">
                  </div>
                  <div class="item">
                      <img src="img/slide-03.png" class="img-responsive" alt="">
                  </div>
                  <div class="item">
                      <img src="img/slide-04.png" class="img-responsive" alt="">
                  </div>
              </div>

              <!-- contenedor slide -->
              <a href="#carousel-1" class="left carousel-control" role="button" data-slide="next">
                  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                  <span class="sr-only">Anterior</span>
              </a>
              <a href="#carousel-1" class="right carousel-control" role="button" data-slide="prev">
                  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                  <span class="sr-only">Siguiente</span>
              </a>
          </div>

      </div>
  </div>
  </body>
</html>
