package trocenchere.bll;

import java.util.List;

import trocenchere.bo.Categorie;
import trocenchere.dal.DAOFactory;

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
	
	public List<Categorie> selectAllCategorie() {
		return DAOFactory.getCategorieDAO().selectAllCategorie();
}
}	
