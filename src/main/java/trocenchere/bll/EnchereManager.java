package trocenchere.bll;

public class EnchereManager {

	// CREATION DU SINGLETON
	
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	private EnchereManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des requetes SQL
}
