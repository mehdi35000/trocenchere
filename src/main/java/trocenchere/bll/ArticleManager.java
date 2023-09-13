package trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Retrait;
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
	public Article insert(String nom_article,String description,LocalDate date_debut_encheres,LocalDate date_fin_encheres,int mise_a_prix,Categorie c, int utilisateurId,Retrait retrait) {
		
		Article nouvelArticle = new Article(nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, c);
		nouvelArticle.setRetrait(retrait);
		DAOFactory.getArticleDAO().insert(nouvelArticle,utilisateurId);
		return nouvelArticle;
	}
	
	public List<Article> selectAllArticlesEnVente() {//throws BusinessException 
		return DAOFactory.getArticleDAO().selectAllArticlesEnVente();
	
	}
	
	public Article selectArticlesById (int id_Article) {
		Article articleAffiche = DAOFactory.getArticleDAO().selectArticlesById(id_Article);
		//System.out.println("l'article affiche est " +articleAffiche);
		return articleAffiche;
		
	}
	
	public Retrait selectRetraitByIdArticle (int id_Article) {
		Retrait retraitAffiche = DAOFactory.getArticleDAO().selectRetraitByIdArticle(id_Article);
		//System.out.println("l'adresse de retrait est " + retraitAffiche);
		return retraitAffiche;
	}
	
	public List<Article> afficherMesArticlesEnVente(int id_utilisateur) {//throws BusinessException 
		return DAOFactory.getArticleDAO().afficherMesArticlesEnVente(id_utilisateur);
	
	}
	
	public List<Article> afficherMesVentesAVenir(int id_utilisateur) {//throws BusinessException 
		return DAOFactory.getArticleDAO().afficherMesVentesAVenir(id_utilisateur);
	
	}
	
	public List<Article> afficherMesVentesTerminees(int id_utilisateur) {//throws BusinessException 
		return DAOFactory.getArticleDAO().afficherMesVentesAVenir(id_utilisateur);
	
	}

}
