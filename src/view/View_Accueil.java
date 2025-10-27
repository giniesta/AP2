package view;

import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
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
		frame.setBounds(100, 100, 573, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCatalogue = new JButton("catalogue");
		btnCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new View_Catalogue();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCatalogue.setBounds(203, 116, 149, 68);
		frame.getContentPane().add(btnCatalogue);
		
		JButton btnRendre = new JButton("rendre un livre");
		btnRendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRendre.setBounds(12, 149, 132, 27);
		frame.getContentPane().add(btnRendre);
		
		JButton btnConnecter = new JButton("se connecter");
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConnecter.setBounds(409, 149, 132, 27);
		frame.getContentPane().add(btnConnecter);
		
		txtRendre = new JTextField();
		txtRendre.setBounds(18, 116, 114, 21);
		frame.getContentPane().add(txtRendre);
		txtRendre.setColumns(10);
		
		txtConnecter = new JTextField();
		txtConnecter.setColumns(10);
		txtConnecter.setBounds(417, 116, 114, 21);
		frame.getContentPane().add(txtConnecter);
		
		JLabel lblIsbnDuLivre = new JLabel("ISBN DU LIVRE");
		lblIsbnDuLivre.setBounds(28, 87, 104, 17);
		frame.getContentPane().add(lblIsbnDuLivre);
		
		JLabel lblNAdherent = new JLabel("N° ADHERENT");
		lblNAdherent.setBounds(427, 87, 104, 17);
		frame.getContentPane().add(lblNAdherent);
		
		JLabel lblBonjour = new JLabel("Bonjour, ");
		lblBonjour.setBounds(184, 28, 195, 39);
		frame.getContentPane().add(lblBonjour);
	}
}
