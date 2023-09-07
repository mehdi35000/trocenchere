package trocenchere.bll;

import java.util.List;

import trocenchere.bo.Article;
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
	
	public List<Article> selectAllArticlesEnVente() {//throws BusinessException 
		return DAOFactory.getArticleDAO().selectAllArticlesEnVente();
	}
}
