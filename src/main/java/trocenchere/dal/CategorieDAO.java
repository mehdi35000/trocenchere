package trocenchere.dal;

import java.util.List;

import trocenchere.bo.Categorie;

public interface CategorieDAO {

	List<Categorie> selectAllCategorie();

	public Categorie selectCategorieById(int id_Categorie);


}
