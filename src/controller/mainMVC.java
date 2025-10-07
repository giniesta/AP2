package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.model;
import view.View_Accueil;

public class mainMVC {
	private static model m;
	
	public static model getM() {
		return m;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Lancement de mon programme");
		m = new model();
		View_Accueil va = new View_Accueil();
	}
}
