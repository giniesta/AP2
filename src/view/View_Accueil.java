package view;

import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;
import java.awt.Font;

public class View_Accueil {

    private JFrame frame;
    private JTextField txtISBN;
    private JTextField txtConnecter;

    public View_Accueil() throws ClassNotFoundException, SQLException {
        mainMVC.getM().getall();
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();		
        frame.setBounds(100, 100, 550, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton btnCatalogue = new JButton("catalogue");
        btnCatalogue.addActionListener(e -> {
            frame.dispose();
            try {
                new View_Catalogue();
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnCatalogue.setBounds(191, 169, 149, 68);
        frame.getContentPane().add(btnCatalogue);
        
        JButton btnRendre = new JButton("rendre un livre");
        btnRendre.setEnabled(false);
        btnRendre.addActionListener(e -> {
            String isbn = txtISBN.getText().trim();
            try {
                LIVRE livre = mainMVC.getM().findLivreByISBN(isbn);
                if (livre != null) {
                	if (livre.getEmprunteur().getNum().isEmpty()) {
                		JOptionPane.showMessageDialog(frame, "Livre déjà rendu !");
                	} else {
                        JOptionPane.showMessageDialog(frame, "Livre rendu : " + livre.getTitre());
                	}
                } else {
                    JOptionPane.showMessageDialog(frame, "ISBN invalide !");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnRendre.setBounds(236, 82, 132, 27);
        frame.getContentPane().add(btnRendre);
        
        JButton btnConnecter = new JButton("voir mes informations");
        btnConnecter.setEnabled(false);
        btnConnecter.addActionListener(e -> {
            String num = txtConnecter.getText().trim();
            try {
                frame.dispose();
                new View_Profile(num);
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        });
        btnConnecter.setBounds(289, 111, 162, 27);
        frame.getContentPane().add(btnConnecter);
        
        JButton btnEmprunter = new JButton("emprunter un livre");
        btnEmprunter.setEnabled(false);
        btnEmprunter.addActionListener(e -> {
            String num = txtConnecter.getText().trim();
            String isbn = txtISBN.getText().trim();
            try {
                ADHERENT ad = mainMVC.getM().findAdherentByNum(num);
                LIVRE livre = mainMVC.getM().findLivreByISBN(isbn);
                if (ad != null && livre != null) {
                    JOptionPane.showMessageDialog(frame, ad.getPrenom() + " emprunte " + livre.getTitre());
                } else {
                    JOptionPane.showMessageDialog(frame, "ISBN ou adhérent invalide !");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnEmprunter.setBounds(376, 82, 150, 27);
        frame.getContentPane().add(btnEmprunter);

        txtISBN = new JTextField();
        txtISBN.setBounds(112, 85, 114, 21);
        frame.getContentPane().add(txtISBN);
        txtISBN.setColumns(10);
        
        txtConnecter = new JTextField();
        txtConnecter.setColumns(10);
        txtConnecter.setBounds(112, 114, 114, 21);
        frame.getContentPane().add(txtConnecter);
        
        JLabel lblIsbnDuLivre = new JLabel("ISBN DU LIVRE");
        lblIsbnDuLivre.setBounds(10, 87, 90, 17);
        frame.getContentPane().add(lblIsbnDuLivre);
        
        JLabel lblNAdherent = new JLabel("N° ADHERENT");
        lblNAdherent.setBounds(10, 116, 90, 17);
        frame.getContentPane().add(lblNAdherent);
        
        JLabel lblNewLabel = new JLabel("BONJOUR");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
        lblNewLabel.setBounds(182, 10, 178, 39);
        frame.getContentPane().add(lblNewLabel);

        DocumentListener updateButtonsListener = new DocumentListener() {
            private void updateButtons() {
                String num = txtConnecter.getText().trim();
                String isbn = txtISBN.getText().trim();
                
                ADHERENT ad = null;
                LIVRE livre = null;
                try {
                    if (!num.isEmpty()) ad = mainMVC.getM().findAdherentByNum(num);
                    if (!isbn.isEmpty()) livre = mainMVC.getM().findLivreByISBN(isbn);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                btnConnecter.setEnabled(ad != null);
                btnEmprunter.setEnabled(ad != null && livre != null);
                btnRendre.setEnabled(livre != null);
            }

            @Override
            public void insertUpdate(DocumentEvent e) { updateButtons(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updateButtons(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updateButtons(); }
        };

        txtConnecter.getDocument().addDocumentListener(updateButtonsListener);
        txtISBN.getDocument().addDocumentListener(updateButtonsListener);
    }
}
