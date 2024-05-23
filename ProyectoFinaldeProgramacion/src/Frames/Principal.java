package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.DataBaseHandling;
import Persona.Persona;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Principal frame;
	DataBaseHandling DB = new DataBaseHandling();
	InscripcionCorredor inscripcion;
	Login Login = new Login(this);
	//Implementar persona
	Persona persona = new Persona();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setFrame(new Principal());
					getFrame().setVisible(true);
					getFrame().setTitle("Programa de Carrera");
					DataBaseHandling DB = new DataBaseHandling();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		DB.initializeConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		add(contentPane);
		contentPane.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(450,300));
		panel.setBackground(Color.white);
		panel.setFocusable(true);
		panel.setDoubleBuffered(true);
		panel.setVisible(true);
		
		contentPane.add(panel);
		
		
		
		
		
		JButton btnAdministrar = new JButton("Administrar");
		panel.add(btnAdministrar);
		btnAdministrar.setBounds(160,70,150,30);
		Login login = new Login(this);
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				getFrame().setVisible(false);
			}
		});
			
		
		
		inscripcion = new InscripcionCorredor(this);
		inscripcion.frame.setVisible(false);
		JButton btnInscribirse = new JButton("Inscribirse");
		
		btnInscribirse.setBounds(160,120,150,30);
		
		btnInscribirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inscripcion.frame.setVisible(true);
				inscripcion.frame.setTitle("Inscripcion");
				
				getFrame().setVisible(false);
				
				
			}
		});
		
		inscripcion.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().setVisible(true);
				inscripcion.frame.setVisible(false);
				
				//CAMBIOS DE DISEÑOS AL VOLVER
				inscripcion.getPanel_DNI().setBackground(null);
			}
		});
		
		panel.add(btnInscribirse);
		
		
	}

	public static Principal getFrame() {
		return frame;
	}

	public static void setFrame(Principal frame) {
		Principal.frame = frame;
	}

}
