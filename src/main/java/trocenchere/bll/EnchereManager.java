package trocenchere.bll;

import java.util.List;

import trocenchere.bo.Enchere;
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
	
	// inserer les methodes des requetes SQL
	
	private EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
	
	public List<Enchere> selectAllEncheres() {//throws BusinessException 
		return enchereDAO.selectAllEncheres();
	}
	
}//fin EnchereManager
