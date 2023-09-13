package trocenchere.bll;

import java.time.LocalDate;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.DAOFactory;
import trocenchere.dal.EnchereDAO;

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
	
	public List<Enchere> selectAllEnchere() {
		return DAOFactory.getEnchereDAO().selectAllEnchere();
	}
	
	public Enchere selectEnchereById(int id_article) {
	    Enchere enchereEnCours = DAOFactory.getEnchereDAO().selectEnchereById(id_article);
	    return enchereEnCours;
	}
	
	public Enchere insert(LocalDate date_enchere, int montant_enchere, Utilisateur utilisateur, Article article) {
		
	    Enchere nouvelleEnchere = new Enchere(date_enchere, montant_enchere, utilisateur, article);
	    
	    DAOFactory.getEnchereDAO().insert(nouvelleEnchere);
	    return nouvelleEnchere;
	}
	


	} 
	