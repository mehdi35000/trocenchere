package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.ArticleDAO;

public class ArticleDAOImpl implements ArticleDAO{
	/*private final static String SELECT_ALL_ARTICLESENVENTE = """
			SELECT * FROM ARTICLES WHERE prix_vente IS NULL;""";*/
	private final static String SELECT_ALL_ARTICLESENVENTE = """
			SELECT
    articles.nom_article,
    articles.description,
    articles.date_debut_encheres,
    articles.date_fin_encheres,
    articles.prix_initial,
    articles.prix_vente,
    utilisateurs.pseudo AS pseudo_proprietaire
FROM ARTICLES INNER JOIN UTILISATEURS ON articles.id_utilisateur = utilisateurs.id_utilisateur;"""; //WHERE articles.prix_vente IS NULL;""";

			
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
			            
			            // Récupérer le pseudo du propriétaire depuis le champ "pseudo_proprietaire"
		                String pseudoVendeur = rs.getString("pseudo");
		                Utilisateur vendeur = new Utilisateur(); // Créez l'objet Utilisateur si nécessaire
		                vendeur.setPseudo(pseudoVendeur);
		                //article.setVendeur(vendeur); // Assurez-vous d'avoir une méthode pour définir le propriétaire
			            //------
			            articlesEnVente.add(article);	
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return articlesEnVente;
			    
			}
}
