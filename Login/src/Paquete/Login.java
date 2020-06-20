package Paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Login extends JFrame {
	private Fondo contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		setType(Type.UTILITY);
		setTitle("TP Final");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 257); //Resolucion de la ventana
		contentPane = new Fondo("filename-legrand-jpg.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Login = new JLabel("Login"); //Creacion de la opcion "Login"
		Login.setForeground(Color.WHITE);
		Login.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 35)); //Tipografia de la letra
		Login.setBounds(0, 0, 203, 37); //Posicion
		contentPane.add(Login);	//Agrega a la ventana el objeto creado
		
		JLabel Usuario = new JLabel("Usuario");
		Usuario.setForeground(Color.WHITE);
		Usuario.setBounds(27, 85, 46, 14);
		contentPane.add(Usuario);
		
		JLabel Contraseña = new JLabel("Contrase\u00F1a");
		Contraseña.setForeground(Color.WHITE);
		Contraseña.setBounds(27, 135, 73, 14);
		contentPane.add(Contraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 82, 155, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(107, 132, 155, 20);
		contentPane.add(txtContraseña);
		
		JButton Ingresar = new JButton("Ingresar");
		Ingresar.setBackground(Color.RED);
		Ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] clave = txtContraseña.getPassword();
				String claveFinal = new String(clave);
				if(txtUsuario.getText().equals("empleado") && claveFinal.equals("123"))
				{	
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Ingresaste", 
							JOptionPane.INFORMATION_MESSAGE);
					Reserva reserva = new Reserva();
					reserva.setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto", "No se ha podido ingresar al sistema", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Ingresar.setBounds(187, 184, 89, 23);
		contentPane.add(Ingresar);
		
	}
}

