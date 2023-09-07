package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.dal.ArticleDAO;

public class ArticleDAOImpl implements ArticleDAO{
	private final static String SELECT_ALL_ARTICLESENVENTE = """
			SELECT * FROM ARTICLES WHERE prix_vente IS NULL;""";
			
			@Override
			public List<Article> selectAllArticlesEnVente() {
			    List<Article> articlesEnVente = new ArrayList<>();

			    try (Connection cnx = ConnectionProvider.getConnection()) {
			        Statement stmt = cnx.createStatement();
			        ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLESENVENTE);

			        while (rs.next()) {
			        	//permet créer une nouvelle instance d'Article pour chaque enregistrement de la base de données
			        	//afin de les mettre dans une liste articlesEnVente
			            Article article = new Article(); 
			            article.setNom_article(rs.getString("nom_article"));
			            
			            article.setDate_debut_encheres(rs.getDate("date_debut_encheres").toLocalDate());
			            article.setDate_fin_encheres(rs.getDate("date_fin_encheres").toLocalDate());
			            article.setMise_a_prix(rs.getInt("prix_initial"));
			            article.setPrix_vente(rs.getInt("prix_vente"));
			            articlesEnVente.add(article);	
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return articlesEnVente;
			    
			}
}
