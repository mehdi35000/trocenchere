package trocenchere.bll;

import trocenchere.dal.DAOFactory;

public class UtilisateurManager {

	// CREATION DU SINGLETON
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	private UtilisateurManager() {}
	
	// FIN SINGLETON
	
	// inserer les methodes des requetes SQL
	
	//DELETE (pour supprimer profil) //ne marche pas complètement parce que c'est fait pour supprimer un profil parmi d'autres, mais pas l'utilisateur actuel.
	public void delete(int id_utilisateur) {
		DAOFactory.getUtilisateurDAO().delete(id_utilisateur);
	}
}
