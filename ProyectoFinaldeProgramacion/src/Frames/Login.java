package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Principal principal;
	JLabel labelPassword;
	JPasswordField passwdField;
	JTextArea userArea;
	Gestion gestion=new Gestion();
	JButton btnVolver;
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Login(Principal principal) {
		this.principal=principal;
		this.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(450,300));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		contentPane.setLayout(new FlowLayout());
		
		getContentPane().add(contentPane);
		JPanel principalPanel = new JPanel();
		principalPanel.setPreferredSize(new Dimension(450,300));
		principalPanel.setVisible(true);
		
		contentPane.add(principalPanel);
		this.pack();
		principalPanel.setLayout(null);
		
		
		
		
		//Botones
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBounds(226, 163, 117, 25);
		
		
		buttonLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin()){
					gestion.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(Login.this, "USUARIO O CONTRASEÑA INCORRECTOS");
				}
			}
		});
		
		//TextAreas
		userArea = new JTextArea();
		userArea.setBounds(226,69,100,20);
		userArea.setBorder(new LineBorder(Color.black, 1));
		passwdField = new JPasswordField();
		passwdField.setBounds(226,101,100,20);
		passwdField.setBorder(new LineBorder(Color.black, 1));
		principalPanel.add(buttonLogin);
		principalPanel.add(passwdField);
		principalPanel.add(userArea);
		
		
		//Labels
		JLabel labelUser = new JLabel("usuario");
		labelUser.setBounds(115,67,100,20);
		
		principalPanel.add(labelUser);
		
		labelPassword = new JLabel("contraseña");
		
		labelPassword.setBounds(115,100,100,20);
		
		principalPanel.add(labelPassword);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						Principal.getFrame().setVisible(true);
						Login.this.setVisible(false);
						
			}	
		});
		btnVolver.setBounds(88, 163, 117, 25);
		principalPanel.add(btnVolver);
		
		
	}
	
	public boolean checkLogin(){
		boolean validado=false;
		try {
			String ADMIN = "SELECT CONTRASEÑA,NOMBRE_USUARIO FROM ADMINISTRADOR";
			PreparedStatement selectCod = principal.DB.connection.prepareStatement(ADMIN);
			
			ResultSet rs = selectCod.executeQuery();
			
			 if (rs.next()) {
				 if(passwdField.getText().equals(rs.getString("CONTRASEÑA")) && userArea.getText().equals(rs.getString("NOMBRE_USUARIO"))){
					 validado=true;
				 }
				 else {
					 validado=false;
				 }	 
			 }

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return validado;
	}
}
