package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import miConexion.MySqlDBConn;
import entidad.Tramite;

public class MySqlTramiteDao implements TramiteDao{

	@Override
	public ArrayList<Tramite> Listar() throws SQLException {
		ArrayList<Tramite> data = new ArrayList<Tramite>();
		Tramite bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql = "select * from tb_tramite";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new Tramite();
				bean.setCodTramite(rs.getString("codTramite"));
				bean.setNomTramite(rs.getString("nomTramite"));
				data.add(bean);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null)rs.close();
				if(pstm!= null)pstm.close();
				if(conn!= null)conn.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}

	@Override
	public int Agregar(String nombreTra) throws SQLException {
		return 0;
	}

	@Override
	public Tramite buscar(String codTra) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Modificar(Tramite Tra) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String GeneraCod() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Eliminar(String Codigo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
