package trocenchere.bll;

import trocenchere.bo.Utilisateur;
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
	
	//INSERT (pour ajouter un utilisateur)
	
	public Utilisateur insert(String pseudo, String nom, String prenom, String email, String telephone, String rue,
		String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
	
		Utilisateur nouvelUtilisateur = new Utilisateur (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);	
		
		System.out.println(nouvelUtilisateur);
		DAOFactory.getUtilisateurDAO().insert(nouvelUtilisateur);
		
		return nouvelUtilisateur;
	} 
	
	//DELETE (pour supprimer profil)
	public void delete(int id_utilisateur) {
		DAOFactory.getUtilisateurDAO().delete(id_utilisateur);
	}
}
