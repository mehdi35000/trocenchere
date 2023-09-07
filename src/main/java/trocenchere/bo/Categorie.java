package trocenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private int id_categorie;
	private String libelle;
	private List<Article>listeArticles = new ArrayList<Article>();
	
	public Categorie() {}
	
	

	public Categorie(int id_categorie, String libelle) {
		super();
		this.id_categorie = id_categorie;
		this.libelle = libelle;
	}

	public int getId_categorie() {
		return id_categorie;   
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;  
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticlesVendus(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	@Override
	public String toString() {
		return "Categorie [id_categorie=" + id_categorie + ", libelle=" + libelle + ", listeArticles="
				+ listeArticles + "]";
	}
	
	
	
	
}
