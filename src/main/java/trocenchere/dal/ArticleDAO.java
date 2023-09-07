package trocenchere.dal;

import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;

public interface ArticleDAO {

	List<Article> selectAllArticlesEnVente();
}
