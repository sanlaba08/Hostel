package Paquete;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{
	private String fechaEntrada;
	private String fechaSalida;
	private String cantidadPersonas;
	
	

	public Cliente(String nombre, String apellido, String edad, String direccion, String dni,
			String fechaEntrada, String fechaSalida, String cantidadPersonas) {
		super(nombre, apellido, edad, direccion, dni);
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
	public String getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(String cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
	public boolean comprobarCampos(String nombre, String apellido, String edad, String direccion, String dni, String fechaEntrada, String fechaSalida, String cantidadPersonas)
	{
		boolean flag = false;
		if(nombre.equals("") || apellido.equals("") || edad.equals("") || direccion.equals("") || dni.equals("") || fechaSalida.equals("") || fechaEntrada.equals("") || cantidadPersonas.equals(""))
		{
			flag = true;
		}
		return flag;
	}
	@Override
	public String toString() {
		return " | DNI: "+dni+" | Nombre: "+nombre+" | Apellido: "+apellido+" | Edad: "+edad+" | Direccion: "+direccion+" | Fecha de entrada: "+fechaEntrada+" | Fecha de salida: "+fechaSalida+ " | Cantidad de personas: " +cantidadPersonas+ " | ";
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj!=null)
		{
			if (obj instanceof Cliente)
			{
				Cliente cliente = (Cliente)obj;
				if (cliente.getDni().equals(getDni()))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}


	
	
	

	
	
	
	
	

}
