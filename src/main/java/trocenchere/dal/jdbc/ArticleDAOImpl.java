package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private final static String INSERT_ARTICLE ="INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente, id_utilisateur, id_categorie)"; 

	private final static String SELECT_ALL_ARTICLESENVENTE = """
			SELECT
    articles.nom_article,
    articles.description,
    articles.date_debut_encheres,
    articles.date_fin_encheres,
    articles.prix_initial,
    articles.prix_vente,
    utilisateurs.pseudo AS pseudo_propriétaire
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
			            Utilisateur vendeur = new Utilisateur();
			            vendeur.setPseudo(pseudoVendeur);
			            article.setUtilisateur(vendeur);
		                System.out.println(pseudoVendeur);
		                System.out.println(article);
		                System.out.println(articlesEnVente);

			            articlesEnVente.add(article);	
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return articlesEnVente;
			    
			}
//			
//			public void insert(Article article) {
//				
//				try (Connection cnx = ConnectionProvider.getConnection()){
//				PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);	
//				  pstmt.setString(1, article.getNom_article());
//			        pstmt.setString(2, article.getDescription());
//			        pstmt.setDate(3, java.sql.Date.valueOf(article.getDate_debut_encheres()));
//			        pstmt.setDate(4, java.sql.Date.valueOf(article.getDate_fin_encheres()));
//			        pstmt.setInt(5, article.getMise_a_prix());
//			        pstmt.setInt(6, article.getUtilisateur().getId_utilisateur()); // Remplacez cela par l'ID de l'utilisateur approprié
//			        pstmt.setInt(7, article.getCategorie().getId_categorie()); /
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//			
//
}
