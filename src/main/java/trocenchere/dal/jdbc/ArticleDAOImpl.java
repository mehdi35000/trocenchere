package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Article;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.ArticleDAO;

public class ArticleDAOImpl implements ArticleDAO {
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente, id_utilisateur, id_categorie)VALUES (?,?,?,?,?,?,?,?);";

	private final static String SELECT_ALL_ARTICLES_A_VENDRE = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur;
			""";

	private final static String SELECT_ARTICLES_BY_ID = "SELECT * FROM ARTICLES WHERE id_article = ?;";
	
	
	@Override
	public List<Article> selectAllArticlesEnVente() {
		List<Article> articlesEnVente = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES_A_VENDRE);

			while (rs.next()) {
				// permet créer une nouvelle instance d'Article pour chaque enregistrement de la
				// base de données
				// afin de les mettre dans une liste articlesEnVente
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

	public void insert(Article article,int utilisateurId) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);

			// variable de la BO
			pstmt.setString(1, article.getNom_article());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDate_debut_encheres()));
			pstmt.setDate(4, Date.valueOf(article.getDate_fin_encheres()));
			pstmt.setInt(5, article.getMise_a_prix());
			pstmt.setInt(6, article.getPrix_vente());
			
			
			pstmt.setInt(7, utilisateurId);
			pstmt.setInt(8, article.getCategorie().getId_categorie());

			pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public Article selectArticlesById (int id_Article) {
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Article article = null;
		try (Connection cnx = ConnectionProvider.getConnection()){
			preparedStatement = cnx.prepareStatement(SELECT_ARTICLES_BY_ID);
			preparedStatement.setInt(1, id_Article);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				int id_Article1 = rs.getInt("id_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
				int mise_a_prix = rs.getInt("mise_a_prix");
				int prix_vente = rs.getInt("prix_vente");
				int id_utilisateur = rs.getInt("id_utilisateur");
				int id_categorie = rs.getInt("id_categorie");
				article = new Article(id_Article1, nomArticle, description, dateDebutEncheres, dateFinEncheres, mise_a_prix, prix_vente, id_utilisateur, id_categorie);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
}
