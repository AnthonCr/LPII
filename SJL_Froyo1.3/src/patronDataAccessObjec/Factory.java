package patronDataAccessObjec;

public abstract class  Factory {

	public static final int TIPO_MYSQL =1;
	
	
	public abstract UsuarioDao getUsuario();
	public abstract RequisitosDao getRequisito();
	public abstract TramiteDao getTramite();
	public static Factory getTipo(int tipo){
		switch (tipo) {
		case TIPO_MYSQL:
			return new MySqlFactory();
		}	
		return null;
		
	}
	
	
}
