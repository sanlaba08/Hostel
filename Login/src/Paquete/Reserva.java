package Paquete;

import java.awt.BorderLayout;
import Paquete.ArchivosUtility;
import java.awt.EventQueue;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.JRadioButton;
//import javax.swing.JPasswordField;
import javax.swing.JTextArea;
//import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
//import java.awt.Frame;
//import java.awt.TextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.util.ArrayList;
import java.util.ConcurrentModificationException;
//import java.awt.Window.Type;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Reserva extends JFrame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre = new JTextField();
	private JTextField apellido = new JTextField();
	private JTextField edad = new JTextField();
	private JTextField dni = new JTextField();
	private JTextField direccion = new JTextField();
	private JTextField llegada = new JTextField();
	private JTextField partida = new JTextField();
	private JTextField cantPersonas = new JTextField();
	private JTextField buscar = new JTextField();
	private JTextArea area = new JTextArea();
	private Fondo contentPane;
	private boolean accion;
	private String contenedorDNI;
	ListaClientes lista = new ListaClientes();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reserva() {
		
		iniciarComponentes();
		mostrarReservas();
	}
		public void iniciarComponentes()
		{
			titulo();
			texto();
			nombre=txtNombre();
			apellido=txtApellido();
			edad=txtEdad();
			llegada=txtLlegada();
			direccion=txtDireccion();
			partida=txtPartida();
			dni=txtDNI();
			cantPersonas=txtCantidadPersonas();
			buscar = txtBuscar();
			lista.mostrar(area);
			area = textArea();
			scroll();
			Reservar();
			Busqueda();
			cancelarReserva();
			Modificar();
			Mostrar();
			cerrarSesion();
			
		}
		
		public void titulo()
		{
			setType(Type.UTILITY);
			setTitle("TP Final");
			setExtendedState(MAXIMIZED_BOTH);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 522, 679);
			contentPane = new Fondo("Reserva.png");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		}
		
		public void texto()	
		{
			JLabel Registro = new JLabel("Reserva");
			Registro.setBounds(41, 11, 115, 44);
			Registro.setForeground(Color.RED);
			Registro.setFont(new Font("Vivaldi", Font.PLAIN, 24));
			contentPane.add(Registro);
			
			JLabel Nombre = new JLabel("Nombre");
			Nombre.setBounds(26, 75, 46, 14);
			Nombre.setForeground(Color.BLACK);
			contentPane.add(Nombre);
			
			JLabel Apellido = new JLabel("Apellido");
			Apellido.setBounds(26, 106, 46, 14);
			Apellido.setForeground(Color.BLACK);
			contentPane.add(Apellido);
			
			JLabel Edad = new JLabel("Edad");
			Edad.setBounds(26, 137, 46, 14);
			Edad.setForeground(Color.BLACK);
			contentPane.add(Edad);
			
			JLabel ValoresEnteros = new JLabel("*NOTA: Solo ingresar valores enteros en la edad.");
			ValoresEnteros.setBounds(26, 151, 193, 30);
			ValoresEnteros.setForeground(Color.RED);
			ValoresEnteros.setFont(new Font("Tahoma", Font.BOLD, 8));
			contentPane.add(ValoresEnteros);	
			
			JLabel Llegada = new JLabel("Fecha de llegada");
			Llegada.setBounds(226, 30, 109, 14);
			Llegada.setForeground(Color.BLACK);
			contentPane.add(Llegada);
			
			JLabel Salida = new JLabel("Fecha de partida");
			Salida.setBounds(226, 61, 99, 14);
			Salida.setForeground(Color.BLACK);
			contentPane.add(Salida);
			
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(21, 184, 71, 14);
			lblDireccion.setForeground(Color.BLACK);
			contentPane.add(lblDireccion);
			
			JLabel lblInformacionDelCliente = new JLabel("Informacion del cliente");
			lblInformacionDelCliente.setBounds(10, 302, 183, 23);
			lblInformacionDelCliente.setForeground(Color.RED);
			lblInformacionDelCliente.setFont(new Font("Vivaldi", Font.PLAIN, 21));
			contentPane.add(lblInformacionDelCliente);
			
			JLabel CantidadPersonas = new JLabel("Cantidad de personas");
			CantidadPersonas.setBounds(225, 92, 150, 14);
			CantidadPersonas.setForeground(Color.BLACK);
			contentPane.add(CantidadPersonas);
			
			JLabel DNI = new JLabel("DNI");
			DNI.setBounds(26, 213, 46, 14);
			DNI.setForeground(Color.BLACK);
			contentPane.add(DNI);
			
			JLabel BuscarPorDNI = new JLabel("Buscar DNI del cliente");
			BuscarPorDNI.setBounds(10, 274, 142, 14);
			contentPane.add(BuscarPorDNI);
			
			JLabel DNIentero = new JLabel("*NOTA: Solo ingresar valores enteros en el DNI.");
			DNIentero.setForeground(Color.RED);
			DNIentero.setFont(new Font("Tahoma", Font.BOLD, 8));
			DNIentero.setBounds(26, 238, 193, 20);
			contentPane.add(DNIentero);
		
		}
		
		public JTextField txtNombre()
		{
			JTextField txtNombre = new JTextField();
			txtNombre.setBounds(84, 72, 121, 20);
			//SOLO EL USUARIO PUEDE INGRESAR LETRAS .
			txtNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					ingresarCaracteres(evt);
				}
			});
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
			
			return txtNombre;
		}
	
		public JTextField txtApellido()
		{
			JTextField txtApellido = new JTextField();
			txtApellido.setBounds(84, 103, 121, 20);
			//SOLO EL USUARIO PUEDE INGRESAR LETRAS .
			txtApellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					ingresarCaracteres(evt);
				}
			});
			contentPane.add(txtApellido);
			txtApellido.setColumns(10);
			return txtApellido;
		}
		

		public JTextField txtEdad()
		{
			JTextField txtEdad = new JTextField();
			txtEdad.setBounds(84, 134, 38, 20);
			//SOLO EL USUARIO PUEDE INGRESAR ENTEROS.
			txtEdad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					ingresarEnteros(evt);
					
				}
			});
			contentPane.add(txtEdad);
			txtEdad.setColumns(10);	
			return txtEdad;
		}
		
		public JTextField txtLlegada()
		{
			JTextField txtLlegada = new JTextField();
			txtLlegada.setBounds(355, 27, 115, 20);
			contentPane.add(txtLlegada);
			txtLlegada.setColumns(10);
			return txtLlegada;
			
		}
	
		public JTextField txtDireccion()
		{
			JTextField txtDireccion = new JTextField();
			txtDireccion.setBounds(84, 181, 121, 20);
			contentPane.add(txtDireccion);
			txtDireccion.setColumns(10);
			return txtDireccion;
		}
			
		public JTextField txtPartida()
		{
			JTextField txtPartida = new JTextField();
			txtPartida.setBounds(355, 58, 115, 20);
			contentPane.add(txtPartida);
			txtPartida.setColumns(10);
			return txtPartida;
		}
			
		public JTextField txtDNI()
		{
			JTextField txtDNI = new JTextField();
			txtDNI.setBounds(84, 209, 121, 20);
			txtDNI.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					ingresarEnteros(evt);	
			}
			});
			contentPane.add(txtDNI);
			txtDNI.setColumns(10);
			txtDNI.getText();
			return txtDNI;
		}
	
		public JTextField txtCantidadPersonas()
		{
			JTextField txtCantidadPersonas = new JTextField();
			txtCantidadPersonas.setBounds(355, 89, 46, 20);
			txtCantidadPersonas.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					ingresarEnteros(evt);
					}
			});
			contentPane.add(txtCantidadPersonas);
			txtCantidadPersonas.setColumns(10);
			return txtCantidadPersonas;
		}
		
		
		public JTextField txtBuscar()
		{
			JTextField txtBuscar = new JTextField();
			txtBuscar.setBounds(138, 271, 101, 20);
			txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				ingresarEnteros(evt);
				}
		});
			contentPane.add(txtBuscar);
			txtBuscar.setColumns(10);
			
			return txtBuscar;	
		}
		
		public JScrollPane scroll()
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(26, 336, 434, 232);
			contentPane.add(scrollPane);
			
			return scrollPane;
		}
	
		public JTextArea textArea()
		{
			JScrollPane a;
			JTextArea textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			a = scroll();
			a.setViewportView(textArea); 
			
			return textArea;
		}

		public JButton Reservar()
		{
			JButton RealizarReserva = new JButton("Realizar Reserva");
			RealizarReserva.setBounds(239, 176, 150, 51);
			RealizarReserva.addActionListener(new ActionListener() {	
				/**
				 * Acciones al presionar el boton "Realizar reserva".
				 */
				public void actionPerformed(ActionEvent arg0)  {
						realizarReserva();
			}	
			});
			RealizarReserva.setForeground(Color.RED);
			RealizarReserva.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
			contentPane.add(RealizarReserva);
			
			return RealizarReserva;
		}
		
		public JButton Busqueda()
		{
			JButton Busqueda = new JButton("Buscar");
			Busqueda.setBounds(249, 271, 86, 21);
			Busqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
			Busqueda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						buscarDNI();		
				}
			});
			contentPane.add(Busqueda);
			
			return Busqueda;
		}
		
		
		public JButton cancelarReserva()
		{
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(366, 306, 86, 21);
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			eliminarReserva();
		}
			});
			contentPane.add(btnEliminar);
			
			return btnEliminar;
		}
		
		
		public JButton Modificar()
		{
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(270, 306, 86, 21);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				modificarCliente();
			}
			});
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPane.add(btnModificar);
			
			return btnModificar;
		}
		
		public JButton Mostrar()
		{
			JButton btnMostrar = new JButton("Mostrar ");
			btnMostrar.setBounds(177, 306, 83, 21);
			btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarReservas();
				}
			});
			contentPane.add(btnMostrar);
			
			return btnMostrar;
		}
		
		public JButton cerrarSesion()
		{
			JButton CerrarSesion = new JButton("Cerrar Sesi\u00F3n");
			CerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CerrarSesion();
					
				}
			});
			CerrarSesion.setBounds(375, 606, 121, 23);
			contentPane.add(CerrarSesion);
			
			return CerrarSesion;
		}
		

	//-----------------------------------------------------------------------------------------------------
	//
	//---------------------------------------METODOS-------------------------------------------------------
	//
	//-----------------------------------------------------------------------------------------------------
		
		
	public void vaciarCampos()
	{
		nombre.setText(null);
		apellido.setText(null);
		edad.setText(null);
		direccion.setText(null);
		dni.setText(null);
		llegada.setText(null);
		partida.setText(null);
		cantPersonas.setText(null);
	}
	
	public void realizarReserva()
	{
		try {
			Cliente cliente = new Cliente(nombre.getText(),apellido.getText(),edad.getText(),direccion.getText(),dni.getText(), llegada.getText(), partida.getText(), cantPersonas.getText());
			if(cliente.comprobarCampos(nombre.getText(), apellido.getText(), edad.getText(), direccion.getText(),dni.getText(), llegada.getText(), partida.getText(), cantPersonas.getText()))
			{
				JOptionPane.showMessageDialog(null, "Por favor, complete los campos para poder avanzar.", "Campos incompletos", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				if(lista.agregarClientes(cliente))
				{
					vaciarCampos();
				}
				area.setText("");
				lista.mostrar(area);
				area.append("\n");
			}
			ArchivosUtility.escribir("Reservas.dat", lista);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void buscarDNI()
	{
		try {
			lista = (ListaClientes) ArchivosUtility.leer("Reservas.dat");
			contenedorDNI = buscar.getText();
			if(!lista.buscarDNI(buscar.getText(), area))
			{
				JOptionPane.showMessageDialog(null, "No se ha encontrado la ID ingresada. Vuelva a intentarlo. ");
			}
			buscar.setText("");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Utilizamos una excpecion porque si tratamos de recorrer una colección (lista, ArrayList, ect..) 
	 *  y al mismo tiempo intentamos realizar cambios sobre esta, lo mas probable 
	 *  es que obtengamos un error de tipo java.util.ConcurrentModificationException
	 */
	public void eliminarReserva()
	{
		try {
			lista = (ListaClientes) ArchivosUtility.leer("Reservas.dat");
			if(lista.buscarDNI(contenedorDNI, area))
			{
				area.setText("");
				lista.eliminarClientePorDNI(contenedorDNI);
				JOptionPane.showMessageDialog(null, "Se canceló una reserva");
			}
			else
			{
				if(contenedorDNI.equals("") || Busqueda().isBackgroundSet() == true)
				{
						JOptionPane.showMessageDialog(null, "No se ha encontrado la ID ingresada. Vuelva a intentarlo. ");
				}	
			}
		}catch(ConcurrentModificationException es) {
				JOptionPane.showMessageDialog(null, "Se canceló una reserva");
			}	
		/**
		 * /**
			 * Si el campo de texto para buscar un DNI esta vacio. Java interpretará que es un error y lanzará una excepcion
			 * nosotros la capturaremos con el catch "NullPointer" y le diremos al usuario que ingrese un valor para poder
			 * continuar con la ejecucion del programa.
			 */
		catch(java.lang.NullPointerException es) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado la ID ingresada. Vuelva a intentarlo. ");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Utilizamos una excpecion porque si tratamos de recorrer una colección (lista, ArrayList, ect..) 
	 *  y al mismo tiempo intentamos realizar cambios sobre esta, lo mas probable 
	 *  es que obtengamos un error de tipo java.util.ConcurrentModificationException.
	 *  La unica diferencia es que en este caso, solo capturamos la excepcion solamente para que el
	 *  programa siga ejecutandose.
	 */
	public void modificarCliente()
	{
		try
		{
			lista = (ListaClientes) ArchivosUtility.leer("Reservas.dat");
			if(!lista.buscarDNI(contenedorDNI, area))
			{
				JOptionPane.showMessageDialog(null, "No se ha encontrado la ID ingresada. Vuelva a intentarlo. ");
			}
			else
			{
				lista.modificarPorDNI(contenedorDNI, nombre, apellido, edad, dni, direccion, llegada, partida, cantPersonas);
			}	
		}
		catch(ConcurrentModificationException es){
		}
		/**
		 * Si el campo de texto para buscar un DNI esta vacio. Java interpretará que es un error y lanzará una excepcion
		 * nosotros la capturaremos con el catch "NullPointer" y le diremos al usuario que ingrese un valor para poder
		 * continuar con la ejecucion del programa.
		 */
		catch(NullPointerException es) {
		JOptionPane.showMessageDialog(null, "Por favor, ingrese un DNI para poder modificar los datos del cliente.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void mostrarReservas() 
	{
		try {
			lista = (ListaClientes) ArchivosUtility.leer("Reservas.dat");
			area.setText(null);
			lista.mostrar(area);
			if(area.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "No se encuentran reservas disponibles en este momento.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void CerrarSesion()
	{
		if(accion == true)
		{
			Login login = new Login();
			login.setVisible(true);
			dispose();
		}
		else {
			int mensaje = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir sin guardar?");
			if(mensaje == JOptionPane.YES_OPTION)
			{
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		}
	}
	
	/**
	 * Nos permite utilizar el teclado.
	 * Si el valor que ingresamos por teclado no esta entre "0 o 9" ingresa al campo del condicional.
	 * @param evt : "evt.consume" rechaza cualquier tecla que no este entre "0 o 9".
	 * 
	 */
	public void ingresarEnteros(KeyEvent evt)
	{
		char c = evt.getKeyChar();
		if(c<'0' || c>'9') { 
			evt.consume();			
		}
	}
	
	/**
	 * Nos permite utilizar el teclado.
	 * Si el valor que ingresamos por teclado no esta entre "a o z" ingresa al campo del condicional.
	 * "consume" rechaza cualquier tecla que no este entre "a o z".
	 * Ademas, "KeyEvent.VK_SPACE" nos permite dejar un espacio entre la cadena que ingresemos en el espacio disponible.
	 */
	public void ingresarCaracteres(KeyEvent evt)
	{
		char c = evt.getKeyChar();						
		if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_SPACE)) {		
			evt.consume();								
		}			
	}
}