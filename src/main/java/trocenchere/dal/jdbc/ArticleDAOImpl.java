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
import trocenchere.bo.Categorie;
import trocenchere.bo.Retrait;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.ArticleDAO;
import trocenchere.dal.CategorieDAO;
import trocenchere.dal.DAOFactory;
import trocenchere.dal.EnchereDAO;
import trocenchere.dal.UtilisateurDAO;

public class ArticleDAOImpl implements ArticleDAO {
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,"
			+ "	id_utilisateur, id_categorie)VALUES (?,?,?,?,?,?,?,?);";

	private final static String SELECT_ALL_ARTICLES_A_VENDRE = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur;
			""";

	private final static String SELECT_ARTICLES_BY_ID = "SELECT * FROM ARTICLES WHERE id_article = ?;";

	private final static String SELECT_RETRAIT_BY_ID_ARTICLE = "SELECT * FROM RETRAITS WHERE id_article = ?;";

	private final static String INSERT_RETRAIT = " INSERT INTO RETRAITS (id_article, rue, code_postal, ville) values(?,?,?,?);";
	
	private final static String SELECT_ALL_ARTICLES_BY_ID_UTILISATEUR = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur WHERE articles.id_utilisateur=? AND date_debut_encheres <GETDATE() AND date_fin_encheres>GETDATE();
			""";
	
	private final static String SELECT_MES_VENTES_TERMINEES = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur WHERE articles.id_utilisateur=? AND date_fin_encheres <GETDATE();
			""";
	
	private final static String SELECT_MES_VENTES_A_VENIR = """
			SELECT * FROM UTILISATEURS RIGHT JOIN ARTICLES ON utilisateurs.id_utilisateur=articles.id_utilisateur WHERE articles.id_utilisateur=? AND date_debut_encheres >GETDATE();
			""";
	
	@Override
	public List<Article> selectAllArticlesEnVente() {
		// List<Article> articlesEnVente = new ArrayList<>();
		List<Article> listeEncheres = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES_A_VENDRE);

			while (rs.next()) {
				// permet créer une nouvelle instance d'Article pour chaque enregistrement de la
				// base de données
				// afin de les mettre dans une liste articlesEnVente
				Article article = new Article();
				article.setId_Article(rs.getInt("id_article"));
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

				Categorie categorie = DAOFactory.getCategorieDAO().selectCategorieById(rs.getInt("id_categorie"));
				article.setCategorie(categorie);

				// articlesEnVente.add(article);
				listeEncheres.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return articlesEnVente;
		return listeEncheres;

	}

	public void insert(Article article, int utilisateurId) {

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

			// récupère les clés générées automatiquement (dans ce cas, l'ID de l'article
			// nouvellement inséré) à partir de la base de données.
			ResultSet rsCleGenere = pstmt.getGeneratedKeys();
			if (rsCleGenere.next()) {
				// permet de récupérer la valeur de la première colonne des clés générées
				// automatiquement (dans ce cas, l'ID de l'article) et stocke cette valeur dans
				// une variable.
				rsCleGenere.getInt(1);
			}
			PreparedStatement pstmt1 = cnx.prepareStatement(INSERT_RETRAIT);
			pstmt1.setInt(1, rsCleGenere.getInt(1));
			pstmt1.setString(2, article.getRetrait().getRue());
			pstmt1.setString(3, article.getRetrait().getCodePostal());
			pstmt1.setString(4, article.getRetrait().getVille());

			pstmt1.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Article selectArticlesById(int id_Article) {

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Article article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			preparedStatement = cnx.prepareStatement(SELECT_ARTICLES_BY_ID);
			preparedStatement.setInt(1, id_Article);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int id_Article1 = rs.getInt("id_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int id_utilisateur = rs.getInt("id_utilisateur");
				int id_categorie = rs.getInt("id_categorie");

				Categorie categorie = DAOFactory.getCategorieDAO().selectCategorieById(id_categorie);
				Utilisateur utilisteur = DAOFactory.getUtilisateurDAO().selectUtilisateurById(id_utilisateur);
				Retrait retrait = this.selectRetraitByIdArticle(id_Article);
				article = new Article(id_Article1, nomArticle, description, dateDebutEncheres, dateFinEncheres,
						prix_initial, prix_vente, utilisteur, categorie);
				article.setRetrait(retrait);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public Retrait selectRetraitByIdArticle(int id_Article) {

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Retrait retrait = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			preparedStatement = cnx.prepareStatement(SELECT_RETRAIT_BY_ID_ARTICLE);
			preparedStatement.setInt(1, id_Article);

			rs = preparedStatement.executeQuery();

			if (rs.next()) {

				retrait = new Retrait();

				retrait.setId_Article(rs.getInt("id_article"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCodePostal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retrait;
	}

	@Override
	public List<Article> recupererMesArticlesEnVente(int id_utilisateur) {
		// List<Article> mesArticlesEnVente = new ArrayList<>();
		List<Article> listeEncheres = new ArrayList<>();
		PreparedStatement pstmt = null;

		// Utilisateur utilisateurEnCours = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLES_BY_ID_UTILISATEUR);

			pstmt.setInt(1, id_utilisateur);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// permet créer une nouvelle instance d'Article pour chaque enregistrement de la
					// base de données
					// afin de les mettre dans une liste articlesEnVente
					Article article = new Article();
					article.setId_Article(rs.getInt("id_article"));
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

					// mesArticlesEnVente.add(article);
					listeEncheres.add(article);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return mesArticlesEnVente;
		return listeEncheres;

	}

	@Override
	public List<Article> recupererMesVentesAVenir(int id_utilisateur) {
		// List<Article> mesVentesAVenir = new ArrayList<>();
		List<Article> listeEncheres = new ArrayList<>();

		PreparedStatement pstmt = null;

		// Utilisateur utilisateurEnCours = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_MES_VENTES_A_VENIR);

			pstmt.setInt(1, id_utilisateur);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// permet créer une nouvelle instance d'Article pour chaque enregistrement de la
					// base de données
					// afin de les mettre dans une liste articlesEnVente
					Article article = new Article();
					article.setId_Article(rs.getInt("id_article"));
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

					// mesVentesAVenir.add(article);
					listeEncheres.add(article);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return mesVentesAVenir;
		return listeEncheres;

	}

	@Override
	public List<Article> recupererMesVentesTerminees(int id_utilisateur) {
		// List<Article> mesVentesTerminees = new ArrayList<>();
		List<Article> listeEncheres = new ArrayList<>();

		PreparedStatement pstmt = null;

		// Utilisateur utilisateurEnCours = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_MES_VENTES_TERMINEES);

			pstmt.setInt(1, id_utilisateur);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					// permet créer une nouvelle instance d'Article pour chaque enregistrement de la
					// base de données
					// afin de les mettre dans une liste articlesEnVente
					Article article = new Article();
					article.setId_Article(rs.getInt("id_article"));
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

					// mesVentesTerminees.add(article);
					listeEncheres.add(article);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return mesVentesTerminees;
		return listeEncheres;

	}

	 private final static String SELECT_MES_ENCHERES = """
		 		SELECT distinct (a.id_article), nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente FROM ENCHERES as e LEFT JOIN ARTICLES as a ON a.id_article=e.id_article WHERE e.id_utilisateur=?;
				 """;
	 
	 @Override
	 public List<Article> recupererMesEncheres(int id_utilisateur) {
			List<Article> listeEncheres = new ArrayList<>();

			PreparedStatement pstmt = null;
			try (Connection cnx = ConnectionProvider.getConnection()) {
				pstmt = cnx.prepareStatement(SELECT_MES_ENCHERES);

				pstmt.setInt(1, id_utilisateur);
				ResultSet rs = pstmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						//JE CHERCHE A AFFICHER L'ARTICLE, MAIS POUR LE MOMENT JE N'AI QUE SON ID
						Article article = new Article();
						article.setId_Article(rs.getInt("id_article"));
						article.setNom_article(rs.getString("nom_article"));
						article.setDescription (rs.getString("description"));
						article.setDate_debut_encheres(rs.getDate("date_debut_encheres").toLocalDate());
						article.setDate_fin_encheres(rs.getDate("date_fin_encheres").toLocalDate());
						article.setMise_a_prix(rs.getInt("prix_initial"));
						article.setPrix_vente(rs.getInt("prix_vente"));

						listeEncheres.add(article);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// return mesVentesTerminees;
			return listeEncheres;

		}

	 
	 
	 
}// fin public
