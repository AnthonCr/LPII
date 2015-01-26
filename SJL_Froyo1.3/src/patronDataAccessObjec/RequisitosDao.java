package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Requisitos;

public interface RequisitosDao {
	public ArrayList<Requisitos> Listar() throws SQLException;
	public int Agregar(String nombreReq) throws SQLException;
	public Requisitos buscar(String codReq) throws SQLException;
	public int Modificar(Requisitos req) throws SQLException;
	public String GeneraCod() throws SQLException;
	public int Eliminar(String Codigo) throws SQLException;
}
