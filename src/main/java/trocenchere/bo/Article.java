package trocenchere.bo;

import java.time.LocalDate;

public class Article {
	
	private int id_Article;
	private String nom_article;
	private String description;
	private LocalDate date_debut_encheres;
	private LocalDate date_fin_encheres;
	private int mise_a_prix;
	private int prix_vente;
	private boolean etat_vente;
	private Retrait retrait;
	private Enchere enchere;
	private int id_utilisateur;
	private Utilisateur utilisateur;
	private int id_categorie;
	private Categorie categorie;
	
	public Article() {}

	public Article(int id_Article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int mise_a_prix, int prix_vente, boolean etat_vente, Retrait retrait,
			Enchere enchere, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.id_Article = id_Article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.mise_a_prix = mise_a_prix;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.retrait = retrait;
		this.enchere = enchere;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}
	
	public Article(String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres,
			int mise_a_prix, Categorie categorie) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.mise_a_prix = mise_a_prix;
		this.categorie = categorie;
	}

	
	
	public Article(int id_Article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int mise_a_prix, int prix_vente, Utilisateur utilisateur,
			Categorie categorie) {
		super();
		this.id_Article = id_Article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.mise_a_prix = mise_a_prix;
		this.prix_vente = prix_vente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public Article(int id_Article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int mise_a_prix, int prix_vente, int id_utilisateur, int id_categorie) {
		super();
		this.id_Article = id_Article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.mise_a_prix = mise_a_prix;
		this.prix_vente = prix_vente;
		this.id_utilisateur = id_utilisateur;
		this.id_categorie = id_categorie;
	}



	public int getId_Article() {
		return id_Article;
	}

	public void setId_Article(int id_Article) {
		this.id_Article = id_Article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(LocalDate date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getMise_a_prix() {
		return mise_a_prix;
	}

	public void setMise_a_prix(int mise_a_prix) {
		this.mise_a_prix = mise_a_prix;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public boolean isEtat_vente() {
		return etat_vente;
	}

	public void setEtat_vente(boolean etat_vente) {
		this.etat_vente = etat_vente;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	@Override
	public String toString() {
		return "Article [id_Article=" + id_Article + ", nom_article=" + nom_article + ", description="
				+ description + ", date_debut_encheres=" + date_debut_encheres + ", date_fin_encheres="
				+ date_fin_encheres + ", mise_a_prix=" + mise_a_prix + ", prix_vente=" + prix_vente + ", etat_vente="
				+ etat_vente + ", retrait=" + retrait + ", enchere=" + enchere + ", utilisateur=" + utilisateur
				+ ", categorie=" + categorie + "]";
	}
	
}
