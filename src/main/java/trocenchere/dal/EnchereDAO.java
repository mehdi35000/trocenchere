package trocenchere.dal;

import java.util.List;

import trocenchere.bo.Enchere;

public interface EnchereDAO {
	List<Enchere> selectAllEncheres();
}
