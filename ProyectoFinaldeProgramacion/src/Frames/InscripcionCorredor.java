package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.DataBaseHandling;
import Persona.Persona;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class InscripcionCorredor {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_Nombre;
	private JTextField txt_CodigoPostal;
	private JTextField txt_Localidad;
	private JTextField txt_Provincia;
	private JTextField txt_Direccion;
	private JTextField txt_Telefono;
	private JTextField txt_DNI;
	private JTextField txtNaci;
	public  JFrame frame;
	public JButton btnVolver;
	private JTextField txt_Apellido;
	private JComboBox <String>elegirClub;
	private JPanel panel_DNI;
	
	//CODIGO
	
	private int codCorredor=0;
	
	//Date
	
	long date = 2004/8/12;
	Date date1 = new Date(date);
	
	long datet = 2006/8/12;
	Date date2 = new Date(datet);
	
	protected Connection connection;
	
	Principal principal;

	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public InscripcionCorredor(Principal principal) {
		this.principal=principal;
		
		
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Inscripcion");
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setPreferredSize(new Dimension(450,300));
		
		frame.add(contentPane);
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.pack();

		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 5));
		
		
		JLabel lblInscribete = new JLabel("Inscribete");
		lblInscribete.setText("Inscribete");
		lblInscribete.setBackground(frame.getBackground());
		panel.add(lblInscribete);
		
		JPanel panel_Nombre = new JPanel();
		contentPane.add(panel_Nombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBackground(UIManager.getColor("Button.background"));
		panel_Nombre.add(lblNombre);
		
		txt_Nombre = new JTextField();
		txt_Nombre.setText("Nombre");
		panel_Nombre.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		
		JPanel panel_Apellido = new JPanel();
		contentPane.add(panel_Apellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBackground(UIManager.getColor("Button.background"));
		panel_Apellido.add(lblApellido);
		
		txt_Apellido = new JTextField();
		txt_Apellido.setText("Apellido");
		txt_Apellido.setColumns(10);
		panel_Apellido.add(txt_Apellido);
		
		 setPanel_DNI(new JPanel());
		contentPane.add(getPanel_DNI());
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBackground(UIManager.getColor("Button.background"));
		getPanel_DNI().add(lblDNI);
		
		txt_DNI = new JTextField();
		txt_DNI.setText("DNI");
		txt_DNI.setColumns(10);
		getPanel_DNI().add(txt_DNI);
		
		JPanel panel_CodigoPostal = new JPanel();
		contentPane.add(panel_CodigoPostal);
		
		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBackground(UIManager.getColor("Button.background"));
		panel_CodigoPostal.add(lblCodigoPostal);
		
		txt_CodigoPostal = new JTextField();
		txt_CodigoPostal.setText("Codigo Postal");
		txt_CodigoPostal.setColumns(10);
		panel_CodigoPostal.add(txt_CodigoPostal);
		
		JPanel panel_Localidad= new JPanel();
		contentPane.add(panel_Localidad);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBackground(UIManager.getColor("Button.background"));
		panel_Localidad.add(lblLocalidad);
		
		txt_Localidad = new JTextField();
		txt_Localidad.setText("Localidad");
		txt_Localidad.setColumns(10);
		panel_Localidad.add(txt_Localidad);
		
		JPanel panel_Provincia = new JPanel();
		contentPane.add(panel_Provincia);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBackground(UIManager.getColor("Button.background"));
		panel_Provincia.add(lblProvincia);
		
		txt_Provincia = new JTextField();
		txt_Provincia.setText("Provincia");
		txt_Provincia.setColumns(10);
		panel_Provincia.add(txt_Provincia);
		
		JPanel panel_Direccion = new JPanel();
		contentPane.add(panel_Direccion);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBackground(UIManager.getColor("Button.background"));
		panel_Direccion.add(lblDireccion);
		
		txt_Direccion = new JTextField();
		txt_Direccion.setText("Direccion");
		txt_Direccion.setColumns(10);
		panel_Direccion.add(txt_Direccion);
		
		JPanel panel_Telefono = new JPanel();
		contentPane.add(panel_Telefono);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBackground(UIManager.getColor("Button.background"));
		panel_Telefono.add(lblTelefono);
		
		txt_Telefono = new JTextField();
		txt_Telefono.setText("Telefono");
		txt_Telefono.setColumns(10);
		panel_Telefono.add(txt_Telefono);
		
		
		JPanel panelNaci = new JPanel();
		txtNaci = new JTextField("Introduce tu fecha de nacimiento");
		txtNaci.setColumns(20);
		contentPane.add(txtNaci);
		
		
		JLabel labelNaci = new JLabel("Fecha Nacimiento");
		
		panelNaci.add(labelNaci);
		panelNaci.add(txtNaci);
		
		
		contentPane.add(panelNaci);
		
		//EL DESPLEGABLE DE CLUBS
		setupDesplegable();
		
		
		btnVolver = new JButton("Volver");
		
		contentPane.add(btnVolver);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validarDNI(txt_DNI.getText())==false) {
					System.out.println("El DNI no es valido");
					getPanel_DNI().setBackground(Color.red);
					JOptionPane.showMessageDialog(null,"Introduce parametros validos");
					
				}
				else {
					getPanel_DNI().setBackground(null);
					insertIntoPersona();
					insertIntoCorredor();
				}
				
			}
		});
		contentPane.add(btnEnviar);
		
	}
	
	public void setupDesplegable() {
		JPanel panelClub = new JPanel();
		elegirClub = new JComboBox<String>();
		elegirClub.addItem(new String("------"));
		elegirClub.addItem(new String("CLUB 1"));
		elegirClub.addItem(new String("CLUB 2"));
	    elegirClub.setBounds(300,300,100,100);
		panelClub.add(elegirClub);
		contentPane.add(panelClub);
	}
	
	public void insertIntoPersona() {
		String persona = "SELECT COUNT(CODIGO_PERSONA) AS CODIGO FROM PERSONA";
		
		try {
			
			PreparedStatement selectCod = principal.DB.connection.prepareStatement(persona);
			
			ResultSet rs = selectCod.executeQuery();
			
			 if (rs.next()) {
			principal.persona.setCodPersona(rs.getInt("CODIGO"));
			principal.persona.setCodPersona(principal.persona.getCodPersona() + 1);
			 }
			
			String insertPersona = "INSERT INTO PERSONA(CODIGO_PERSONA,NOMBRE,APELLIDOS,DIRECION,CODIGO_POSTAL,LOCALIDAD,PROVINCIA,TELEFONO) VALUES(?,?,?,?,?,?,?,?)";
					
					
			PreparedStatement preparedStmt = principal.DB.connection.prepareStatement(insertPersona);
			
			
			preparedStmt.setInt(1, principal.persona.getCodPersona());
			preparedStmt.setString(2, txt_Nombre.getText());
			preparedStmt.setString(3, txt_Apellido.getText());
			preparedStmt.setString(4, txt_Direccion.getText());
			preparedStmt.setInt(5, Integer.parseInt(txt_CodigoPostal.getText()));
			preparedStmt.setString(6, txt_Localidad.getText());
			preparedStmt.setString(7, txt_Provincia.getText());
			preparedStmt.setString(8, txt_Telefono.getText());
			
			
			
			
			preparedStmt.execute();
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
	
	public void insertIntoCorredor() {
		String corredor = "SELECT COUNT(CODIGO_CORREDOR) AS CODIGO FROM PERSONA";
		
	
		try {
			
			PreparedStatement selectCod = principal.DB.connection.prepareStatement(corredor);
			
			ResultSet rs = selectCod.executeQuery();
			
			 if (rs.next()) {
			codCorredor=(rs.getInt("CODIGO"));
			codCorredor += 1;
			 }
			
			 String insertCorredor = "INSERT INTO CORREDOR(CODIGO_CORREDOR,FECHA_NACIMIENTO,CODIGO_CLUB,CODIGO_PERSONA) VALUES (?,?,?,?)";
					
					
			PreparedStatement preparedStmt = principal.DB.connection.prepareStatement(insertCorredor);
			
			
			preparedStmt.setInt(1, codCorredor);
			preparedStmt.setString(2, txtNaci.getText());
			preparedStmt.setString(3, elegirClub.getName());
			preparedStmt.setInt(4, principal.persona.getCodPersona());
			
			
			
			
			
			preparedStmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	
	}
	
	
	
	
	public boolean validarDNI(String dni) {
	    if (dni.length() != 9) {
	        return false;
	    }
	    String digitos = dni.substring(0, 8);
	    char letra = dni.charAt(8);
	    if (!digitos.matches("\\d{8}") || !Character.isLetter(letra)) {
	    	System.out.println();
	        return false;
	    }
	    char letraEsperada = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.parseInt(digitos) % 23);
	    return letraEsperada == letra;
	}

	public JPanel getPanel_DNI() {
		return panel_DNI;
	}

	public void setPanel_DNI(JPanel panel_DNI) {
		this.panel_DNI = panel_DNI;
	}

	public int getCodCorredor() {
		return codCorredor;
	}

	public void setCodCorredor(int codCorredor) {
		this.codCorredor = codCorredor;
	}

}
