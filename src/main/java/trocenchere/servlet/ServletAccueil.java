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
import trocenchere.bll.ArticleManager;
import trocenchere.bll.CategorieManager;
import trocenchere.bll.EnchereManager;
import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Enchere;
import trocenchere.dal.jdbc.ConnectionProvider;

public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Article> articlesEnVente = ArticleManager.getInstance().selectAllArticlesEnVente();
		request.setAttribute("articlesEnVente", articlesEnVente);

		// pour éviter erreur null pointer Exception
		
		Integer id_utilisateur = (Integer) request.getSession().getAttribute("idUtilisateur");
		System.out.println("vous allez afficher les ventes de " + id_utilisateur);
		if (id_utilisateur != null) {
			id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");

			List<Article> mesArticlesEnVente = ArticleManager.getInstance().afficherMesArticlesEnVente(id_utilisateur);
			request.setAttribute("mesArticlesEnVente", mesArticlesEnVente);
		}
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

		try (Connection cnx = ConnectionProvider.getConnection()) {
			//System.out.println("Message connection ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Categorie> categorie = CategorieManager.getInstance().selectAllCategorie();
		//System.out.println(categorie.toString());

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toggleOption = request.getParameter("toggle");

		if ("achats".equals(toggleOption)) {
			 if (request.getParameter("enchères") != null) {
			List<Article> articlesEnVente = ArticleManager.getInstance().selectAllArticlesEnVente();
			request.setAttribute("articlesEnVente", articlesEnVente);
			 }
			 if (request.getParameter("mesEnchères") != null) {
					// Charger la liste des articles sur lesquels j'ai enchéri
					 }
			 if (request.getParameter("mesEnchèresRemportées") != null) {
					// Charger la liste des articles que j'ai gagné
					 }
		} else if ("ventes".equals(toggleOption)) {
			if (request.getParameter("mesVentesEnCours") != null) {
			int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
			List<Article> mesArticlesEnVente = ArticleManager.getInstance().afficherMesArticlesEnVente(id_utilisateur);
			request.setAttribute("mesArticlesEnCours", mesArticlesEnVente);
		}
			if (request.getParameter("mesVentesAVenir") != null) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				List<Article> mesVentesAVenir = ArticleManager.getInstance().afficherMesArticlesEnVente(id_utilisateur);
				request.setAttribute("mesVentesAVenir", mesVentesAVenir);
			}
			if (request.getParameter("mesVentesTerminees") != null) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				List<Article> mesVentesTerminees = ArticleManager.getInstance().afficherMesArticlesEnVente(id_utilisateur);
				request.setAttribute("mesVentesTermines", mesVentesTerminees);
			}		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
		}

	}

}
