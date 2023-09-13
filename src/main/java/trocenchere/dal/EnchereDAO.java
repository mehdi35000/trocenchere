package trocenchere.dal;

import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;

public interface EnchereDAO {

	public void insert(Enchere nouvelleEnchere);

	Enchere selectEnchereById(int id_article);

	List<Enchere> selectAllEnchere();

	List<Enchere> selectAllEnchereByArticle(Article article);

	List<Enchere> selectAllEnchereByUtilisateur(Utilisateur utilisateur);
	
}
