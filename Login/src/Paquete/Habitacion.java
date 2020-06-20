package Paquete;
import java.util.ArrayList;

public class Habitacion {

	private int nroHabitacion;
	private boolean disponibilidad;
	private ArrayList<Cama>camas;
	
	public Habitacion(int nroHabitacion, boolean disponibilidad) {
		super();
		this.nroHabitacion = nroHabitacion;
		this.disponibilidad = disponibilidad;
		camas = new ArrayList<>();
	}
	
	public boolean mostrarDisponibilidad() {
		
		return disponibilidad;
	}
	
	@Override
	public String toString() {
		
		return "Numero Habitacion: "+nroHabitacion+"Disponibilidad: "+disponibilidad;
	}
	
	
	
	
}
