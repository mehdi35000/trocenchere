package trocenchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enchere {
	
	private int id_enchere;
	private LocalDate date_enchere;
	private int montant_enchere;
	private Utilisateur utilisateur;
	private Article article;
	
	public Enchere() {}
	
	
	public Enchere(LocalDate date_enchere, int montant_enchere) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	
	public Enchere(int id_enchere, LocalDate date_enchere, int montant_enchere, Utilisateur utilisateur,
			Article article) {
		super();
		this.id_enchere = id_enchere;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}


	public Enchere(LocalDate date_enchere, int montant_enchere, Utilisateur utilisateur, Article article) {
		super();
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}

	
	
	public int getId_enchere() {
		return id_enchere;
	}


	public void setId_enchere(int id_enchere) {
		this.id_enchere = id_enchere;
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


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Enchere [id_enchere=" + id_enchere + ", date_enchere=" + date_enchere + ", montant_enchere="
				+ montant_enchere + ", utilisateur=" + utilisateur + ", article=" + article + "]";
	}


	
}
