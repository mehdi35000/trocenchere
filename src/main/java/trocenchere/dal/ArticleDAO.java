package trocenchere.dal;

import trocenchere.bo.Article;
import trocenchere.bo.Retrait;

import java.util.List;

public interface ArticleDAO {

	List<Article> selectAllArticlesEnVente();

	void insert(Article article, int utilisateurId); // throws BusinessException

	public Article selectArticlesById(int id_Article);

	public Retrait selectRetraitByIdArticle(int id_Article);

	public List<Article> recupererMesArticlesEnVente(int id_utilisateur);

	public List<Article> recupererMesVentesAVenir(int id_utilisateur);

	public List<Article> recupererMesVentesTerminees(int id_utilisateur);

	public List<Article> recupererMesEncheres(int id_utilisateur);
}
