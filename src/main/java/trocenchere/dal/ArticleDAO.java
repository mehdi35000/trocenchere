package trocenchere.dal;

import trocenchere.bo.Article;
import java.util.List;

public interface ArticleDAO {
	void insert(Article article);

	List<Article> selectAllArticlesEnVente();
}
