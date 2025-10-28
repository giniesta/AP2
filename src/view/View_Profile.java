package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Profile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Profile window = new View_Profile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View_Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitre = new JLabel("INFORMATIONS DU COMPTE");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitre.setBounds(266, 10, 181, 30);
		frame.getContentPane().add(lblTitre);
		
		JLabel lblNewLabel = new JLabel("Emprunts");
		lblNewLabel.setBounds(573, 56, 44, 12);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPaneEmprunts = new JScrollPane();
		scrollPaneEmprunts.setBounds(489, 78, 240, 169);
		frame.getContentPane().add(scrollPaneEmprunts);
		
		JLabel lblNumero = new JLabel("N°");
		lblNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(39, 71, 36, 12);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNom.setBounds(31, 92, 44, 12);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom.setBounds(31, 114, 44, 12);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(31, 136, 44, 12);
		frame.getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(79, 68, 96, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 89, 96, 18);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 111, 96, 18);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(79, 133, 96, 18);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new View_Accueil();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRetour.setBounds(669, 10, 84, 24);
		frame.getContentPane().add(btnRetour);
	}
}
