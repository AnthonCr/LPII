package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patronDataAccessObjec.Factory;
import patronDataAccessObjec.UsuarioDao;

/**
 * Servlet implementation class ServletCambioContraseña
 */
@WebServlet("/CambioContrasena")
public class ServletCambioContrasena extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Npass=request.getParameter("Npass");
		String usu=request.getParameter("usuario");
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		UsuarioDao dao = fabrica.getUsuario();

		try {
			
			dao.CambioContraseña(usu, Npass);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
