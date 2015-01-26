package patronDataAccessObjec;

import java.sql.SQLException;

import entidad.Usuario;

public interface UsuarioDao {

	public Usuario valida(String usu, String pass) throws SQLException;
	public int CambioContraseña(String usu,String Npass) throws SQLException;
	
}
