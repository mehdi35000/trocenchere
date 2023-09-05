package trocenchere.dal;

import trocenchere.dal.jdbc.ArticleVenduDAOImpl;
import trocenchere.dal.jdbc.CategorieDAOImpl;
import trocenchere.dal.jdbc.EnchereDAOImpl;
import trocenchere.dal.jdbc.UtilisateurDAOImpl;

// Fourni les instances de classe 

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOImpl();
	}
	
}
