package view;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;

import controller.mainMVC;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class View_Accueil {

	private JFrame frame;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(84, 140, 60, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("catalogue");
		btnNewButton.setBounds(61, 169, 106, 27);
		frame.getContentPane().add(btnNewButton);
	}
}
