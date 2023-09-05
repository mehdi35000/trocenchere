package trocenchere.bll;

public class RetraitManager {

	// CREATION DU SINGLETON
	
	private static RetraitManager instance;
	
	public static RetraitManager getInstance() {
		if(instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}
	private RetraitManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des requetes SQL
}
