package Paquete;

	public class Administrador extends Persona {
	
	private Usuario cuenta;

	public Administrador(String nombre, String apellido, String edad, String direccion, String dni, Usuario cuenta,
	Administrador administrador) {
		
		super(nombre, apellido, edad, direccion, dni);
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
	
		return "| Nombre: " +nombre+ " | Apellido: " +apellido+ " | Edad: "+edad+" | DNI: "+dni+" | Direccion: "+direccion; 
}



}