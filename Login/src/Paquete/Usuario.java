package Paquete;

public class Usuario {
	
	private String usuario;
	private String password;
	private int tipoCuenta;
	
	public Usuario(String usuario, String password, int tipoCuenta) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.tipoCuenta = tipoCuenta;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	@Override
	public String toString(){
		
		return "Usuario: "+usuario+"Password: "+password;
	}
	

}
