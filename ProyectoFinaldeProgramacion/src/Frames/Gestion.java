package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Gestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
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
	public Gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnRecorridos = new JButton("Recorridos");
		panel.add(btnRecorridos);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnCorredores = new JButton("Corredores");
		panel_1.add(btnCorredores);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnInscripciones = new JButton("Inscripciones");
		panel_2.add(btnInscripciones);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnTrabajadores = new JButton("Trabajadores");
		panel_3.add(btnTrabajadores);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnVoluntarios = new JButton("Voluntarios");
		panel_4.add(btnVoluntarios);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnClubs = new JButton("Clubs");
		panel_5.add(btnClubs);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton btnPatrocinadores = new JButton("Patrocinadores");
		panel_6.add(btnPatrocinadores);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton btnInforme = new JButton("Informe");
		panel_7.add(btnInforme);
	}
}
