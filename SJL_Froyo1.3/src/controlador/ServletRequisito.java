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
import entidad.Requisitos;

/**
 * Servlet implementation class ServletRequisito
 */
@WebServlet("/Requisito")
public class ServletRequisito extends HttpServlet {
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
		RequisitosDao dao = fabrica.getRequisito();
		
		ArrayList<Requisitos> list=null;
		try {
			list = dao.Listar();
			request.setAttribute("lista", list);
			request.getRequestDispatcher("/AgregarRequisito.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void agregar(HttpServletRequest request, HttpServletResponse response){
		String nombreReq=request.getParameter("nombreReq");
		
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		RequisitosDao dao = fabrica.getRequisito();
		
		try {
			dao.Agregar(nombreReq);
			System.out.println(dao.GeneraCod());
			request.getRequestDispatcher("/Requisito?opt=listar").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}private void modificar(HttpServletRequest request, HttpServletResponse response){
		
		String cod=request.getParameter("cod");
		String desc=request.getParameter("desc");
		String est=request.getParameter("estado");
		
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		RequisitosDao dao = fabrica.getRequisito();
		
		try {
			Requisitos bean=new Requisitos();
			bean.setCodRequisito(cod);
			bean.setDescripcion(desc);
			bean.setEstado(Integer.parseInt(est));
			System.out.println(cod);
			dao.Modificar(bean);
			request.getRequestDispatcher("/Requisito?opt=listar").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}private void eliminar(HttpServletRequest request, HttpServletResponse response){
		String cod=request.getParameter("cod");
		
		Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		RequisitosDao dao = fabrica.getRequisito();
		
		try {
			dao.Eliminar(cod);
			request.getRequestDispatcher("/Requisito?opt=listar").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
