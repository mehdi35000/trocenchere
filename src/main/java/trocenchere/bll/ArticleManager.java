package trocenchere.bll;

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
	
}
