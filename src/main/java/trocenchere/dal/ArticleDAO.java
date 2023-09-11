package trocenchere.dal;


import trocenchere.bo.Article;
import java.util.List;

public interface ArticleDAO {

	List<Article> selectAllArticlesEnVente();
	
	void insert(Article article,int utilisateurId); //throws BusinessException
	
	public Article selectArticlesById (int id_Article) ;
}
