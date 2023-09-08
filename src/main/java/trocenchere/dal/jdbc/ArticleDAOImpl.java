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
	private final static String INSERT_ARTICLE ="INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente, id_utilisateur, id_categorie)"; 

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
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
