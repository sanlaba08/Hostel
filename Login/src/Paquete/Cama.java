package Paquete;

public class Cama {

	private int idCama;
	private boolean estado;
	
	public Cama(int idCama, boolean estado) {
		super();
		this.idCama = idCama;
		this.estado = estado;
	}
	
	public int getidCama() {
		return idCama;
	}

	public void setidCama(int idCama) {
		this.idCama = idCama;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean mostrarEstado() {
		
		return estado;
	}
	
}
