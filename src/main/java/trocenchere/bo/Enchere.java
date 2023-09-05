package trocenchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enchere {
	
	private LocalDate date_enchere;
	private int montant_enchere;
	private List<Utilisateur>listeUtilisateurs = new ArrayList <Utilisateur>();
	private List<ArticleVendu>listeArticlesVendus = new ArrayList<ArticleVendu>();
	
	public Enchere() {}

	public Enchere(LocalDate date_enchere, int montant_enchere) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	public List<ArticleVendu> getListeArticlesVendus() {
		return listeArticlesVendus;
	}

	public void setListeArticlesVendus(List<ArticleVendu> listeArticlesVendus) {
		this.listeArticlesVendus = listeArticlesVendus;
	}

	@Override
	public String toString() {
		return "Enchere [date_enchere=" + date_enchere + ", montant_enchere=" + montant_enchere + ", listeUtilisateurs="
				+ listeUtilisateurs + ", listeArticlesVendus=" + listeArticlesVendus + "]";
	}
	
	
}
