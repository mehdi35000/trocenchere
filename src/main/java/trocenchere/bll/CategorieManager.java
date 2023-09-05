package trocenchere.bll;

public class CategorieManager {

	// CREATION DU SINGLETON
	
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	private CategorieManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des requetes SQL
}
