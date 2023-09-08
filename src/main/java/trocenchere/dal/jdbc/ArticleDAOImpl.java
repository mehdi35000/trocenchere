package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.ArticleDAO;

public class ArticleDAOImpl implements ArticleDAO{
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git
	private final static String INSERT_ARTICLE ="INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente, id_utilisateur, id_categorie)"; 
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git


	/*private final static String SELECT_ALL_ARTICLESENVENTE = """
			SELECT
    articles.nom_article,
    articles.description,
    articles.date_debut_encheres,
    articles.date_fin_encheres,
    articles.prix_initial,
    articles.prix_vente,
    utilisateurs.pseudo 
FROM ARTICLES INNER JOIN UTILISATEURS ON articles.id_utilisateur = utilisateurs.id_utilisateur;"""; //WHERE articles.prix_vente IS NULL;"""; // à changer pour un truc qui combine les deux
*/
	private final static String SELECT_ALL_ARTICLES_A_VENDRE = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur;
			""";
	
	@Override
	public List<Article> selectAllArticlesEnVente() {
	    List<Article> articlesEnVente = new ArrayList<>();

	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        Statement stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES_A_VENDRE);

	        while (rs.next()) {
	        	//permet créer une nouvelle instance d'Article pour chaque enregistrement de la base de données
	        	//afin de les mettre dans une liste articlesEnVente
	            Article article = new Article(); 
	            article.setNom_article(rs.getString("nom_article"));
	            article.setDate_debut_encheres(rs.getDate("date_debut_encheres").toLocalDate());
	            article.setDate_fin_encheres(rs.getDate("date_fin_encheres").toLocalDate());
	            article.setMise_a_prix(rs.getInt("prix_initial"));
	            article.setPrix_vente(rs.getInt("prix_vente"));           
	            
	            Utilisateur vendeur = new Utilisateur();
	            vendeur.setId_utilisateur(rs.getInt("id_utilisateur"));
	            vendeur.setPseudo(rs.getString("pseudo"));
	            vendeur.setNom(rs.getString("nom"));
	            vendeur.setPrenom(rs.getString("prenom"));
	            vendeur.setEmail(rs.getString("email"));
	            vendeur.setTelephone(rs.getString("telephone"));
	            vendeur.setRue(rs.getString("rue"));
	            vendeur.setCode_postal(rs.getString("code_postal"));
	            vendeur.setVille(rs.getString("ville"));
	            vendeur.setMot_de_passe(rs.getString("mot_de_passe"));
	            vendeur.setCredit(rs.getInt("credit"));
	            vendeur.setAdministrateur(rs.getBoolean("administrateur"));

	            article.setUtilisateur(vendeur);
	            //UtilisateurDAOImpl dao = new UtilisateurDAOImpl();//pour récupérer les infos de Flavie 
	            //Utilisateur vendeur = dao.selectById( rs.getString("id_utilisateur")); //pour récupèrer l'id de l'utilisateur qui a mis l'article en vente pour avoir le pseudo associé au vendeur.
	            //utilisateur.getPseudo ?? 
	            
	            /*
                String pseudoVendeur = rs.getString("pseudo_proprietaire");
                Utilisateur vendeur = new Utilisateur();
                vendeur.setPseudo(pseudoVendeur);
                //article.setUtilisateur(vendeur);
                System.out.println(pseudoVendeur);
                System.out.println(article);
                System.out.println(articlesEnVente);
                
                article.setUtilisateur(vendeur);
                */

	            articlesEnVente.add(article);	
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return articlesEnVente;
	    
	}
	
	public void insert(Article article) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
		PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);	
			
<<<<<<< HEAD
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
			            //article
			            
			            // Récupérer le pseudo du propriétaire depuis le champ "pseudo_proprietaire"

		                String pseudoVendeur = rs.getString("pseudo_proprietaire");
		                Utilisateur vendeur = new Utilisateur();
		                vendeur.setPseudo(pseudoVendeur);
		                //article.setUtilisateur(vendeur);

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
=======
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git
}
