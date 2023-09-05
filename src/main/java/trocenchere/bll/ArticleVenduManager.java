package trocenchere.bll;

public class ArticleVenduManager {

	// CREATION DU SINGLETON 
	
	private static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance() {
		if(instance == null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
	private ArticleVenduManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des requetes SQL
	
}
