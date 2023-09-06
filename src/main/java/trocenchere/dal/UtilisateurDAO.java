package trocenchere.dal;

import trocenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	void insert(Utilisateur nouvelUtilisateur);
	
	void delete(int id_utilisateur);


}
