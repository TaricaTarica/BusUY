<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BusUY</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" />
	<link rel="stylesheet" href="assets/busuy.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body class="body-login">
<form class="container" action="Sesion" method="post">
	<h3 class="center">Iniciar Sesion</h3>
	<div class="row">
    	<div class="input-field col s12">
	      <input name = "nickname" id="id-nickname" type="text" class="validate">
	      <label class="active" for="first_name2">Usuario</label>
	    </div>
	    <div class="input-field col s12">
	      <input name = "password" id="id-password" type="password" class="validate">
	      <label class="active" for="first_name2">Contraseña</label>
	    </div>
	    <div class="center">
	    	<button type="submit" class="waves-effect waves-light btn orange darken-4">Iniciar Sesion</button>
	    </div>
  </div>
</form>

 <%if(request.getAttribute("error") != null){%>
 <script>
 	var toastHTML = '<span>${error}</span>';
 	M.toast({html: toastHTML, classes: 'red lighten-2'});
  </script>
 <%}%>
</body>
</html>