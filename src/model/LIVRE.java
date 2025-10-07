package model;

public class LIVRE {
	private String isbn;
	private String titre;
	private float prix;
	private AUTEUR auteur;
	private ADHERENT emprunteur;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public AUTEUR getAuteur() {
		return auteur;
	}
	public void setAuteur(AUTEUR auteur) {
		this.auteur = auteur;
	}
	public ADHERENT getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(ADHERENT emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	public LIVRE(String isbn, String titre, float prix, AUTEUR auteur, ADHERENT emprunteur) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.prix = prix;
		this.auteur = auteur;
		this.emprunteur = emprunteur;
	}
}
