package trocenchere.dal;

<<<<<<< HEAD
import trocenchere.bo.Article;
=======
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git

public interface ArticleDAO {
	void insert(Article article);

	List<Article> selectAllArticlesEnVente();
}
