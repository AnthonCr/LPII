package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import miConexion.MySqlDBConn;
import entidad.Usuario;

public class MySqlUsuarioDao  implements UsuarioDao{

	@Override
	public Usuario valida(String usu, String pass) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Usuario obj = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from tb_usuario where usuario = ? and password =? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usu);
			pstm.setString(2, pass);
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Usuario();
				obj.setCodigo(rs.getInt("codUsuario"));
				obj.setLogin(rs.getString("usuario"));
				obj.setPassword(rs.getString("password"));
				obj.setTipo(rs.getInt("tipo"));
				obj.setNombre(rs.getString("usuNombre"));
				obj.setApellido(rs.getString("usuApellido"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return obj;
	}

	@Override
	public int CambioContraseña(String usu, String Npass) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="update tb_usuario set password=? where usuario = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, Npass);
			pstm.setString(2, usu);
			pstm.executeUpdate();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return -1;
	}

}
