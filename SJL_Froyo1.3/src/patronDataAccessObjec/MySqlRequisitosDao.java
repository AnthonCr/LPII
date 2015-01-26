package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import miConexion.MySqlDBConn;
import entidad.Requisitos;

public class MySqlRequisitosDao implements RequisitosDao{

	@Override
	public ArrayList<Requisitos> Listar() throws SQLException {
		ArrayList<Requisitos> data = new ArrayList<Requisitos>();
		Requisitos bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql = "select * from tb_requesitos";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new Requisitos();
				bean.setCodRequisito(rs.getString("codRequisito"));
				bean.setDescripcion(rs.getString("descripcion"));
				bean.setEstado(rs.getInt("estado"));
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
	public int Agregar(String nombreReq) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="insert into tb_requesitos values(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, this.GeneraCod());
			pstm.setString(2, nombreReq);
			pstm.setInt(3, 0);
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

	@Override
	public Requisitos buscar(String codReq) throws SQLException {
		Requisitos bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql = "select * from tb_requesitos where codRequisito =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, codReq);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new Requisitos();
				bean.setCodRequisito(rs.getString("codRequisito"));
				bean.setDescripcion(rs.getString("descripcion"));
				bean.setEstado(rs.getInt("estado"));
			}
			return bean;
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
		return bean;
	}

	@Override
	public int Modificar(Requisitos req) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="update tb_requesitos set descripcion=?,estado=? where codRequisito=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, req.getDescripcion());
			pstm.setInt(2, req.getEstado());
			pstm.setString(3, req.getCodRequisito());
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

	@Override
	public String GeneraCod() throws SQLException {
		Requisitos bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql = "SELECT * FROM tb_requesitos order by codRequisito desc LIMIT 1";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new Requisitos();
				bean.setCodRequisito(rs.getString("codRequisito"));
				bean.setDescripcion(rs.getString("descripcion"));
				bean.setEstado(rs.getInt("estado"));
			}
			
			Integer aux=Integer.parseInt(bean.getCodRequisito().substring(3,5))+1;
			
			return "RQ"+"00"+Integer.toString(aux);
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
		return "-1";
	}

	@Override
	public int Eliminar(String Codigo) throws SQLException {
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="delete from tb_requesitos where codRequisito=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, Codigo);
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
