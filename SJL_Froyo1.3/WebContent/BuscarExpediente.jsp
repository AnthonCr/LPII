<jsp:include page="SesionValida.jsp" />
<!DOCTYPE html>
<%@page import="entidad.Usuario"%>
<html lang="en">
  <head>
    <meta charset="utf-8">

    <title>Sistema</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>
  </head>
  
  <%Usuario usu=(Usuario) session.getAttribute("USUARIO_LOGEADO"); %>
  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Barra de Menu"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>SISTEMA SAN JUAN LURIGANCHO</b></a>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="logout">Cerrar Sesion</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#"><img src="assets/img/ui-sherman.jpg" class="img-circle" width="80"></a></p>
              	  <h5 class="centered"><%=usu.getNombre()+" "+usu.getApellido() %></h5>
              	  	
                  <li class="mt">
                      <a href="index.jsp">
                          <i class="fa fa-home"></i>
                          <span>Inicio</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>Contribuyente</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="#">Consultar</a></li>
                          <li><a  href="#">Agregar</a></li>
                          <li><a  href="#">Modificar</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Expediente</span>
                      </a>
                      <ul class="sub">
                          <li class="active"><a href="BuscarExpediente.jsp">Buscar</a></li>
                          <li><a  href="ModificarExpediente.jsp">Modificar</a></li>
                          <li><a  href="RegistrarExpediente.jsp">Registrar</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="glyphicon glyphicon-list-alt"></i>
                          <span>Tramites</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="AgregarTramite.jsp">Agregar</a></li>
                          <li><a  href="#">Modificar</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Requisitos</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="Requisito?opt=listar">Agregar</a></li>
                          <li><a  href="ModificarRequisito.jsp">Modificar</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Configuracion</span>
                      </a>
                      <ul class="sub">
                          <li><a  data-toggle="modal" href="index.jsp#myModal">Cambio de Contraseña</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
              
          </div>
      </aside>
      <!--sidebar end-->
      <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Cambiar de Contraseña</h4>
		                      </div>
		                      <form action="CambioContraseña" method="post">
		                      	<div class="modal-body">
		                          <p>Ingrese nueva Contraseña (Alfanumera:P@ssw0r)</p>
		                          <input type="hidden" name="usuario" value=<%=usu.getLogin() %>>
		                          <input type="password" name="Npass" placeholder="Nueva Contraseña" autocomplete="off" class="form-control placeholder-no-fix">
		
			                    </div>
			                    <div class="modal-footer">
			                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
			                          <button class="btn btn-theme" type="submit">Confirmar</button>
			                    </div>
		                      </form>
		                      
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Expediente</h3>
          </section>
          <div class="form-panel">
          	<h4 class="mb"><i class="fa fa-angle-right"></i> Busqueda</h4>
            <form>
            	<table >
            		<tr>
            			<td style="padding: 10px;"><label>Num. de Expediente :</label></td>
            			<td style="padding: 10px;"><input type="text" class="form-control" placeholder="Ingreser Numero"></td>
            			<td style="padding: 10px;"><button type="submit" class="btn btn-theme">Buscar</button></td>
            		</tr>
            		<tr>
            			<td style="padding: 10px;"><label>Tipo de Tramite :</label></td>
            			<td style="padding: 10px;"><input type="text" class="form-control"></td>
            			<td style="padding: 10px;"><label>Solicitante :</label></td>
            			<td style="padding: 10px;"><input type="text" class="form-control"></td>
            			<td style="padding: 10px;"><label>Area :</label></td>
            			<td style="padding: 10px;"><input type="text" class="form-control"></td>
            		</tr>
            		<tr>
            			<td style="padding: 10px;"><label>Tipo de Persona :</label></td>
            			<td style="padding: 10px;">
            				<select class="form-control">
            					<option>Juridica</option>
            					<option>Natural</option>
            				</select>
            			</td>
            			<td style="padding: 10px;"><label>Fecha :</label></td>
            			<td style="padding: 10px;"><input type="date" class="form-control"></td>
            			<td style="padding: 10px;"><label>Estado :</label></td>
            			<td style="padding: 10px;">
            				<select class="form-control">
            					<option>En proceso</option>
            					<option>Cerrado</option>
            				</select>
            			</td>
            		</tr>
            	</table>
            </form>
            <br>
            <table class="table table-striped">
				<tr>
					<td>N° Exp.</td>
					<td>Tipo Tramite</td>
					<td>Tipo de Persona</td>
					<td>Solicitante</td>
					<td>Area</td>
					<td>Estado</td>
					<td>Fecha</td>
				</tr>
			</table>
          </div>
          
      </section>

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Studio51pe
              <a href="BuscarExpediente.jsp#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="assets/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="assets/js/sparkline-chart.js"></script>    
	<script src="assets/js/zabuto_calendar.js"></script>	
	
	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  

  </body>
</html>
