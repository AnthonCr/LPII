<jsp:include page="SesionValidaL.jsp" />
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrador SIS. SJL</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
  </head>
  <% String men=(String) request.getAttribute("MENSAJE"); %>
  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
		      <form class="form-login" action="login" method="post">
		        <h2 class="form-login-heading">INICIE SESION</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" placeholder="Usuario" autofocus name="txtUsuario">
		            <br>
		            <input type="password" class="form-control" placeholder="Contraseña" name="txtPassword"><br>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> ENTRAR</button>
		            <br>
		            <%if(men=="-1"){ %>
		            <div class="alert alert-danger">Usuario o Contraseña Incorrecta</div>
		            <%} %>
		            <div class="registration">
		                Sistema de administracion de<br/>San Juan de Lurigancho
		            </div>
		        </div>
		      </form>
	  	</div>
	  </div>
    <script>
        $.backstretch("assets/img/login.jpg", {speed: 500});
    </script>
  </body>
</html>
