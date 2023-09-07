package trocenchere.dal;

<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git
import trocenchere.bo.Article;
import java.util.List;

public interface ArticleDAO {

	List<Article> selectAllArticlesEnVente();
	
	void insert(Article article); //throws BusinessException
}
