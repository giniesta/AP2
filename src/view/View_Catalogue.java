package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

import controller.mainMVC;
import model.LIVRE;
import model.model;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class View_Catalogue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Catalogue window = new View_Catalogue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Catalogue() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		btnRetour.setBounds(502, 13, 84, 24);
		frame.getContentPane().add(btnRetour);
		
		JList listCatalogue = new JList();
		listCatalogue.setModel(new AbstractListModel() {
			String[] values = new String[] {"test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;", "test; ", "test2;"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listCatalogue.setBounds(52, 48, 274, 281);
		frame.getContentPane().add(listCatalogue);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(310, 40, 16, 289);
		frame.getContentPane().add(scrollBar);
	}
}
