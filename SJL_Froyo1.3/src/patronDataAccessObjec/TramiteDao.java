package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Tramite;

public interface TramiteDao {
	public ArrayList<Tramite> Listar() throws SQLException;
	public int Agregar(String nombreTra) throws SQLException;
	public Tramite buscar(String codTra) throws SQLException;
	public int Modificar(Tramite Tra) throws SQLException;
	public String GeneraCod() throws SQLException;
	public int Eliminar(String Codigo) throws SQLException;
}
