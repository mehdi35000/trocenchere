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
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.ArticleDAO;
import trocenchere.dal.DAOFactory;
import trocenchere.dal.EnchereDAO;

public class EnchereDAOImpl implements EnchereDAO {

	final String SELECT_ALL_ENCHERE = "SELECT * FROM ENCHERES ;";
	final String SELECT_ALL_ENCHERE_UTILISATEUR = "SELECT * FROM ENCHERES WHERE id_utilisateur = ?;";
	final String SELECT_ALL_ENCHERE_ARTICLE = "SELECT * FROM ENCHERES WHERE id_article = ?;";

	final String SELECT_ENCHERE_BY_ID = "SELECT * FROM ENCHERES WHERE id_article = ?;";

	final String INSERT_ENCHERE = "INSERT INTO ENCHERES (id_article, id_utilisateur, date_enchere, montant_enchere) VALUES (?,?,?,?)";

	@Override
	public List<Enchere> selectAllEnchereByArticle(Article article) {
		List<Enchere> enchereEnCours = new ArrayList<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE_ARTICLE);
			pstmt.setInt(1, article.getId_Article());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Enchere enchere = new Enchere ();
				
				enchere.setId_enchere(rs.getInt("id_enchere"));
				enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
				enchere.setArticle(article);
				
				Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("id_utilisateur"));
				enchere.setUtilisateur(utilisateur);
				
				enchereEnCours.add(enchere);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchereEnCours;

	}
	
	@Override
	public List<Enchere> selectAllEnchereByUtilisateur(Utilisateur utilisateur) {
		List<Enchere> enchereEnCours = new ArrayList<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE_UTILISATEUR);
			pstmt.setInt(1, utilisateur.getId_utilisateur());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Enchere enchere = new Enchere ();
				
				enchere.setId_enchere(rs.getInt("id_enchere"));
				enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
				Article article = DAOFactory.getArticleDAO().selectArticlesById(rs.getInt("id_article"));
				enchere.setArticle(article);
				
				enchere.setUtilisateur(utilisateur);
				
				enchereEnCours.add(enchere);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchereEnCours;

	}
	
	
	@Override
	public List<Enchere> selectAllEnchere() {
		List<Enchere> enchereEnCours = new ArrayList<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);
			
			while (rs.next()) {
				Enchere enchere = new Enchere ();
				
				enchere.setId_enchere(rs.getInt("id_enchere"));
				enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
				Article article = DAOFactory.getArticleDAO().selectArticlesById(rs.getInt("id_article"));
				enchere.setArticle(article);
				
				Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectUtilisateurById(rs.getInt("id_utilisateur"));
				enchere.setUtilisateur(utilisateur);
				
		
				
				enchereEnCours.add(enchere);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return enchereEnCours;

	}

	@Override
	public Enchere selectEnchereById(int id_article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Enchere enchereEnCours = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_ENCHERE_BY_ID);
			pstmt.setInt(1, id_article);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int id_enchere = rs.getInt("id_enchere"); // Remplacez "id_enchere" par le nom correct de la colonne
				int id_article1 = rs.getInt("id_article");
				int id_utilisateur = rs.getInt("id_utilisateur"); // Remplacez "id_utilisateur" par le nom correct de la
																	// colonne
				int montantEnchere = rs.getInt("montant_enchere"); // Remplacez "montant_enchere" par le nom correct de
																	// la colonne
				LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate(); // Remplacez "date_enchere" par le nom
																					// correct de la colonne

				enchereEnCours = new Enchere(id_enchere, dateEnchere, montantEnchere, null, null);

				// Assurez-vous d'obtenir correctement l'objet Article en utilisant DAOFactory
				// ou tout autre moyen
				Article article = DAOFactory.getArticleDAO().selectArticlesById(id_article1);

				// Assurez-vous d'obtenir correctement l'objet Utilisateur en utilisant
				// DAOFactory ou tout autre moyen
				Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectUtilisateurById(id_utilisateur);

				enchereEnCours.setArticle(article);
				enchereEnCours.setUtilisateur(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enchereEnCours;
	}

	public void insert(Enchere nouvelleEnchere) {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE);

			pstmt.setInt(1, nouvelleEnchere.getArticle().getId_Article());
			pstmt.setInt(2, nouvelleEnchere.getUtilisateur().getId_utilisateur());
			pstmt.setDate(3, Date.valueOf(nouvelleEnchere.getDate_enchere()));
			pstmt.setInt(4, nouvelleEnchere.getMontant_enchere());

			//System.out.println("nouvelleEnchere ");
			//System.out.println(nouvelleEnchere);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}