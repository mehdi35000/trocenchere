package trocenchere.dal;

import trocenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	void insert(Utilisateur nouvelUtilisateur);
	
	void delete(int id_utilisateur);

	Utilisateur connexionUtilisateur(String pseudo, String mot_de_passe);
	
	//pour récupérer les informations sur le profil
	public Utilisateur selectUtilisateurById(
			int id_utilisateur);

	//pour mettre à jour le profil
	void  updateProfil(Utilisateur utilisateurMaj);


}
