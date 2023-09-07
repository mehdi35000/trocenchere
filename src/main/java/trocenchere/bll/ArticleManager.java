package trocenchere.bll;

import java.time.LocalDate;

import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.dal.DAOFactory;

public class ArticleManager {

	// CREATION DU SINGLETON 
	
	private static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	private ArticleManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des methodes SQL
	public Article insert(String nom_article,String description,LocalDate date_debut_encheres,LocalDate date_fin_encheres,int mise_a_prix,Categorie categorie) {
	 
		Article nouvelArticle = new Article(nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, categorie);
		DAOFactory.getArticleDAO().insert(nouvelArticle);
		return nouvelArticle;

	}
}
