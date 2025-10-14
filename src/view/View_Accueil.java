package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class View_Accueil {

	private JFrame frame;
	private JTextField txtRendre;
	private JTextField txtConnecter;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Accueil() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCatalogue = new JButton("catalogue");
		btnCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Catalogue vc = new View_Catalogue();
			}
		});
		btnCatalogue.setBounds(434, 196, 149, 68);
		frame.getContentPane().add(btnCatalogue);
		
		JButton btnRendre = new JButton("rendre un livre");
		btnRendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRendre.setBounds(235, 229, 132, 27);
		frame.getContentPane().add(btnRendre);
		
		JButton btnConnecter = new JButton("se connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConnecter.setBounds(630, 229, 124, 27);
		frame.getContentPane().add(btnConnecter);
		
		txtRendre = new JTextField();
		txtRendre.setBounds(241, 196, 114, 21);
		frame.getContentPane().add(txtRendre);
		txtRendre.setColumns(10);
		
		txtConnecter = new JTextField();
		txtConnecter.setColumns(10);
		txtConnecter.setBounds(640, 196, 114, 21);
		frame.getContentPane().add(txtConnecter);
		
		JLabel lblIsbnDuLivre = new JLabel("ISBN DU LIVRE");
		lblIsbnDuLivre.setBounds(251, 167, 104, 17);
		frame.getContentPane().add(lblIsbnDuLivre);
		
		JLabel lblNAdherent = new JLabel("N° ADHERENT");
		lblNAdherent.setBounds(650, 167, 104, 17);
		frame.getContentPane().add(lblNAdherent);
	}
}
