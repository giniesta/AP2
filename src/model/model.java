package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class model {
	private ArrayList<LIVRE> listLivre = new ArrayList<LIVRE>();
	private ArrayList<AUTEUR> listAuteur = new ArrayList<AUTEUR>();
	private ArrayList<ADHERENT> listAdherent = new ArrayList<ADHERENT>();
	private Connection conn;
	
	private String bdd = "ap2";
	private String url = "jdbc:mysql://localhost:3306/"+bdd;
	private String user = "root";
	private String passwd = "";
	
	public model() throws ClassNotFoundException, SQLException {
		listLivre = new ArrayList<LIVRE>();
		listAuteur = new ArrayList<AUTEUR>();
		listAdherent = new ArrayList<ADHERENT>();
		
		// On se connecte à la bdd
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("connexion ok");
	}
	
	public AUTEUR findAuteurByNum(String num) {
		for (AUTEUR a : listAuteur) {
			if (a.getNum().equals(num)) {
				return a;
			}
		}
		return null;
	}
	public ADHERENT findAdherentByNum(String num) {
		for (ADHERENT a : listAdherent) {
			if (a.getNum().equals(num)) {
				return a;
			}
		}
		return null;
	}
	public void getall() throws SQLException, ClassNotFoundException {
		listLivre.clear();
		listAuteur.clear();
		listAdherent.clear();
		listLivre = new ArrayList<LIVRE>();
		listAuteur = new ArrayList<AUTEUR>();
		listAdherent = new ArrayList<ADHERENT>();
		
		ResultSet resultats;
		String requete;
		Statement stmt = conn.createStatement() ;
		
		// On récupère les auteurs
		requete = "SELECT * FROM AUTEUR";
		resultats = stmt.executeQuery(requete);
		while (resultats.next()) {
			AUTEUR au = new AUTEUR(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getDate(4));
			listAuteur.add(au);
		}
				
		// On récupère les adherents
		requete = "SELECT * FROM ADHERENT";
		resultats = stmt.executeQuery(requete);
		while (resultats.next()) {
			ADHERENT ad = new ADHERENT(resultats.getString(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), null);
			listAdherent.add(ad);
		}
		
		// On récupère les livres
		requete = "SELECT * FROM LIVRE";
		resultats = stmt.executeQuery(requete);
		while (resultats.next()) {
			LIVRE l = new LIVRE(resultats.getString(1), resultats.getString(2), resultats.getFloat(3), null, null);
			if (resultats.getString(4) != null) {
				l.setAuteur(findAuteurByNum(resultats.getString(4)));
			}
			if (resultats.getString(5) != null) {
				l.setEmprunteur(findAdherentByNum(resultats.getString(4)));
			}
			listLivre.add(l);
		}
	}
}

