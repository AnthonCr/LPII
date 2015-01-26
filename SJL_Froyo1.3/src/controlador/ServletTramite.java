package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patronDataAccessObjec.Factory;
import patronDataAccessObjec.RequisitosDao;
import patronDataAccessObjec.TramiteDao;
import entidad.Requisitos;
import entidad.Tramite;

/**
 * Servlet implementation class ServletTramite
 */
@WebServlet("/Tramite")
public class ServletTramite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt=request.getParameter("opt");
		
		if(opt.equals("listar")){
			listar(request,response);
		}else if(opt.equals("agregar")){
			agregar(request,response);
		}else if(opt.equals("modificar")){
			modificar(request,response);
		}else{
			eliminar(request,response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response){
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		TramiteDao dao = fabrica.getTramite();
		RequisitosDao dao2 = fabrica.getRequisito();
		ArrayList<Tramite> list=null;
		ArrayList<Requisitos> list2=null;
		try {
			list = dao.Listar();
			list2=dao2.Listar();
			request.setAttribute("listaR", list2);
			request.setAttribute("lista", list);
			request.getRequestDispatcher("/AgregarTramite.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void agregar(HttpServletRequest request, HttpServletResponse response){
		
	}private void modificar(HttpServletRequest request, HttpServletResponse response){
		
		
	}private void eliminar(HttpServletRequest request, HttpServletResponse response){
		
	}

}
