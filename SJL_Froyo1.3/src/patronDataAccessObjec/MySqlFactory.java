package patronDataAccessObjec;


public class MySqlFactory  extends Factory{

	@Override
	public UsuarioDao getUsuario() {
		return new MySqlUsuarioDao();
	}

	@Override
	public RequisitosDao getRequisito() {
		return new MySqlRequisitosDao();
	}

	@Override
	public TramiteDao getTramite() {
		return new MySqlTramiteDao();
	}

	
	
}
