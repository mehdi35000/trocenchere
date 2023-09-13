package trocenchere.dal;


import trocenchere.bo.Article;
import trocenchere.bo.Retrait;

import java.util.List;

public interface ArticleDAO {

	List<Article> selectAllArticlesEnVente();
	
	void insert(Article article,int utilisateurId); //throws BusinessException
	
	public Article selectArticlesById (int id_Article) ;
	
	public Retrait selectRetraitByIdArticle (int id_Article);

	public List<Article> afficherMesArticlesEnVente(int id_utilisateur);
}
