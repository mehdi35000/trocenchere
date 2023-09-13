package trocenchere.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trocenchere.bll.ArticleManager;
import trocenchere.bll.CategorieManager;
import trocenchere.bll.EnchereManager;
import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Enchere;
import trocenchere.dal.DAOFactory;
import trocenchere.dal.jdbc.ConnectionProvider;

public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// session.setAttribute("pseudoUtilisateur", "Eva");
		// session.setAttribute("idUtilisateur", 4);

		// session.setAttribute("utilisateur",
		// DAOFactory.getUtilisateurDAO().selectUtilisateurById(4));

		List<Article> listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
		request.setAttribute("ListeEncheres", listeEncheres);
		System.out.println("Je suis dans le doGet de ma ServletAccueil");

		// pour éviter erreur null pointer Exception
		/*
		Integer id_utilisateur = (Integer) request.getSession().getAttribute("idUtilisateur");
		System.out.println("vous allez afficher les ventes de " + id_utilisateur);
		if (id_utilisateur != null) {
			id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
			List<Article> listeEncheres = ArticleManager.getInstance().recupererMesArticlesEnVente(id_utilisateur);
			request.setAttribute("mesArticlesEnVente", listeEncheres);
			System.out.println("je suis dans le doGet de ma ServletAccueil");
		}
		*/

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

//		try (Connection cnx = ConnectionProvider.getConnection()) {
//			System.out.println("Message connection ok");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		List<Categorie> categorie = CategorieManager.getInstance().selectAllCategorie();
		// System.out.println(categorie.toString());

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Je suis dans le doGet de ma ServletAccueil");

		List<Article> listeEncheres = null;

		String toggleOption = request.getParameter("toggle");

		if ("achats".equals(toggleOption)) {
			System.out.println("achats");

			if (request.getParameter("enchères") != null) {
				System.out.println("enchères");
				listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
				System.out.println(listeEncheres);
			}
			if (request.getParameter("mesEnchères") != null) {
				System.out.println("mesEnchères");
				// TODO : Charger la liste des articles sur lesquels j'ai enchéri
				// listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
			}
			if (request.getParameter("mesEnchèresRemportées") != null) {
				System.out.println("mesEnchèresRemportées");
				// TODO : Charger la liste des articles que j'ai gagné
				// listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
			}
		} else {
			System.out.println("ventes");

			if (request.getParameter("mesVentesEnCours") != null) {
				System.out.println("mesVentesEnCours");
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesArticlesEnVente(id_utilisateur);
				System.out.println(listeEncheres);

			}
			if (request.getParameter("mesVentesAVenir") != null) {
				System.out.println("mesVentesAVenir");
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesVentesAVenir(id_utilisateur);
				System.out.println(listeEncheres);
			}
			if (request.getParameter("mesVentesTerminees") != null) {
				System.out.println("mesVentesTerminees");
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesVentesTerminees(id_utilisateur);
				System.out.println(listeEncheres);
			}
		}

		request.setAttribute("ListeEncheres", listeEncheres);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

	}

}
