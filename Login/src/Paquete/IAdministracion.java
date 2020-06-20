package Paquete;

public interface IAdministracion {
	
	public void mostrarDisponibilidad();
	public void elegirCamas();
	public boolean reservar();
	public boolean cancelarReserva();
	public boolean checkIn();
	public boolean checkOut();
	public String toString();

}
