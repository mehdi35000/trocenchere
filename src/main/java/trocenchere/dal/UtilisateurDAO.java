package trocenchere.dal;

import trocenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	void insert(Utilisateur nouvelUtilisateur);
	
	void delete(int id_utilisateur);

	Utilisateur connexionUtilisateur(String pseudo, String mot_de_passe);


}
