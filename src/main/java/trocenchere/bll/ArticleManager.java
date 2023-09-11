package trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.dal.ArticleDAO;
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
	public Article insert(String nom_article,String description,LocalDate date_debut_encheres,LocalDate date_fin_encheres,int mise_a_prix,Categorie c, int utilisateurId) {
		
		Article nouvelArticle = new Article(nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, c);
		DAOFactory.getArticleDAO().insert(nouvelArticle,utilisateurId);
		return nouvelArticle;
	}
	
	public List<Article> selectAllArticlesEnVente() {//throws BusinessException 
		return DAOFactory.getArticleDAO().selectAllArticlesEnVente();
	
	}
	
	public Article selectArticlesById (int id_article) {
		return DAOFactory.getArticleDAO().selectArticlesById(id_article);
		
	}
}
