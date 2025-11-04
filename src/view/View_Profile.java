package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.mainMVC;
import model.ADHERENT;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class View_Profile {

	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JTextField txtNum;

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
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public View_Profile() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
		frame.setVisible(true);
	}

	public View_Profile(String num) throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
		ADHERENT ad = mainMVC.getM().findAdherentByNum(num);
		txtNum.setText(num);
		txtNom.setText(ad.getNom());
		txtPrenom.setText(ad.getPrenom());
		txtEmail.setText(ad.getEmail());
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTitre = new JLabel("INFORMATIONS DU COMPTE");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitre.setBounds(185, 10, 181, 30);
		frame.getContentPane().add(lblTitre);

		JLabel lblNewLabel = new JLabel("Emprunts");
		lblNewLabel.setBounds(334, 50, 59, 12);
		frame.getContentPane().add(lblNewLabel);

		JScrollPane scrollPaneEmprunts = new JScrollPane();
		scrollPaneEmprunts.setBounds(250, 72, 240, 169);
		frame.getContentPane().add(scrollPaneEmprunts);

		JLabel lblNumero = new JLabel("N°");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(59, 71, 25, 12);
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

		txtNom = new JTextField();
		txtNom.setEnabled(false);
		txtNom.setBounds(79, 89, 96, 18);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);

		txtPrenom = new JTextField();
		txtPrenom.setEnabled(false);
		txtPrenom.setBounds(79, 111, 96, 18);
		frame.getContentPane().add(txtPrenom);
		txtPrenom.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(79, 133, 161, 18);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

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
		btnRetour.setBounds(442, 14, 84, 24);
		frame.getContentPane().add(btnRetour);

		JButton btnModif = new JButton("Modifier");
		btnModif.setBounds(79, 161, 89, 20);
		frame.getContentPane().add(btnModif);

		txtNum = new JTextField();
		txtNum.setEnabled(false);
		txtNum.setBounds(79, 68, 96, 18);
		frame.getContentPane().add(txtNum);
		txtNum.setColumns(10);
	}
}
