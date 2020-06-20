package Paquete;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListaClientes implements Serializable{
	ArrayList<Cliente> clientes;
	
	public ListaClientes()
	{
		super();
		clientes = new ArrayList<>();
	}
	
	public boolean agregarClientes(Cliente cliente)
	{
		boolean rta = false;
		//verificar DNI
		if (verificacionDeDNI(cliente))
		{
			clientes.add(cliente);
			return rta = true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "El DNI que desea ingresar ya existe, ingrese uno distinto.");
		}
		return rta;
	}
	
	public boolean verificacionDeDNI(Cliente cliente)
	{
		if (clientes.contains(cliente)) return false;
		else return true;
	}
	
	public int contarClientes()
	{
		return clientes.size();
	}
	
	public void mostrar(JTextArea area)
	{
		for(Cliente cliente : clientes)
		{
			area.append("--------------------------------------------------------------------------------------------------------");
			area.append("\n");		
			area.append(cliente.toString());
			area.append("\n");		
		}
	}
	
	public boolean modificarPorDNI(String dni, JTextField txtNombre, JTextField txtApellido, JTextField txtEdad, JTextField txtDNI, JTextField txtDireccion, JTextField txtLlegada, JTextField txtPartida, JTextField txtCantidadPersonas)
	{
		boolean flag = false;
		for(Cliente cliente : clientes)
		{
			if(dni.equals(cliente.getDni()))
			{
				txtNombre.setText(cliente.getNombre());
				txtApellido.setText(cliente.getApellido());
				txtEdad.setText(cliente.getEdad());
				txtDNI.setText(cliente.getDni());
				txtDireccion.setText(cliente.getDireccion());
				txtLlegada.setText(cliente.getFechaEntrada());
				txtPartida.setText(cliente.getFechaSalida());
				txtCantidadPersonas.setText(cliente.getCantidadPersonas());
				flag = true;
				clientes.remove(cliente);
			}
		}
		return flag;
	}
	public String mostrarClientes(Cliente clientes)
	{
		return clientes.toString();
	}
	
	public boolean buscarDNI(String dni, JTextArea area)
	{
		boolean flag = false;
		for(Cliente cliente : clientes)
		{
			if(dni.equals(cliente.getDni()))
			{
				area.setText(mostrarClientes(cliente));
				flag = true;
			}
		}
		return flag;
	}
	
	
	public void eliminarClientePorDNI(String dni)
	{
		for(Cliente cliente : clientes)
		{
			if(dni.equals(cliente.getDni()))
			{
				clientes.remove(cliente);
			}
		}
	}
	
	public void eliminarLista()
	{
		clientes.clear();
	}
	
	public void mostrarLista()
	{
		for(Cliente cliente : clientes)
		{
				System.out.println(cliente.toString());
		}
	}

	
	

	

	
	
	
}
