package Paquete;

public class Empleado extends Persona{
	String idEmpleado;

	public Empleado(String nombre, String apellido, String edad, String direccion, String dni, String idEmpleado) {
		super(nombre, apellido, edad, direccion, dni);
		this.idEmpleado = idEmpleado;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "idEmpleado: "+idEmpleado+"Nombre: "+nombre+"Apellido: "+apellido+"Edad: "+edad+"DNI: "+dni+"Direccion: "+direccion;
	}
	
		
	

}
