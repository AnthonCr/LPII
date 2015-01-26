package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Usuario;

import patronDataAccessObjec.Factory;
import patronDataAccessObjec.UsuarioDao;


@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			String  usu = request.getParameter("txtUsuario");
			String  pass = request.getParameter("txtPassword");
			
			Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
			UsuarioDao dao = fabrica.getUsuario();
			
			Usuario usuario = null;
			try {
				usuario = dao.valida(usu, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			if(usuario == null){
				request.setAttribute("MENSAJE", "-1");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				//Se obtiene la session
				HttpSession session = request.getSession();
				
				//se guarda en sesion el objeto que contiene los datos del usuario
				session.setAttribute("USUARIO_LOGEADO", usuario);
				
				//se ingresa a la intranet
				request.getRequestDispatcher("/index.jsp").forward(request, response);  
			}
	}

}
