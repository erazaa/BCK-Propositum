<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 14/07/2017
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/login.css" rel="stylesheet">
    <title>Ingresar</title>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
        <p id="profile-name" class="profile-name-card"></p>
        <form class="form-signin">
            <span id="reauth-email" class="reauth-email"></span>
            <input type="email" id="inputEmail" class="form-control" placeholder="Correo Electrónico" required autofocus>
            <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" a href="Profile.jsp">Ingresar</button>
        </form><!-- /form -->
         <p>¿Todavía no eres miembro? <a href="registro.jsp" class="form-control" >
            Registrate
       </a></p>
        <p><a href="#" class="forgot-password" >
            ¿Has olvidado tu contraseña?
        </a></p>
    </div><!-- /card-container -->
</div><!
</body>
</html>
