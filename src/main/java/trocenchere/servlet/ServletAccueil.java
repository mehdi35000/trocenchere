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
			System.out.println("Message connection ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Categorie> categorie = CategorieManager.getInstance().selectAllCategorie();
		System.out.println(categorie.toString());

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toggleOption = request.getParameter("toggle");

		if ("achats".equals(toggleOption)) {
			// Chargez la liste des articles en vente (${articlesEnVente})
			List<Article> articlesEnVente = ArticleManager.getInstance().selectAllArticlesEnVente();
			request.setAttribute("articlesEnVente", articlesEnVente);
		} else if ("ventes".equals(toggleOption)) {
			// Chargez la liste de vos articles en vente (${mesArticlesEnVente})
			int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
			List<Article> mesArticlesEnVente = ArticleManager.getInstance().afficherMesArticlesEnVente(id_utilisateur);
			request.setAttribute("mesArticlesEnVente", mesArticlesEnVente);
			System.out.println("L'utilisateur actuel est " + id_utilisateur + "il veut afficher ses ventes en ligne");
		}

		// Redirigez vers votre JSP d'accueil
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

	}

}
