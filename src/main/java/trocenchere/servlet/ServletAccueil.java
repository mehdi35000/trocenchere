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

		List<Article> listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
		request.setAttribute("ListeEncheres", listeEncheres);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

//		try (Connection cnx = ConnectionProvider.getConnection()) {
//			System.out.println("Message connection ok");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		List<Categorie> categorie = CategorieManager.getInstance().selectAllCategorie();

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Article> listeEncheres = null;

		String toggleOption = request.getParameter("toggleOption");

		if ("encheres".equals(toggleOption)) {
				listeEncheres = ArticleManager.getInstance().selectAllArticlesEnVente();
			}
		if ("mesEnchères".equals(toggleOption)) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesEncheres(id_utilisateur);
			}
		if ("mesEnchèresRemportées".equals(toggleOption)) {
				// TODO : Charger la liste des articles que j'ai gagné
				// listeEncheres = ArticleManager.getInstance().selectAllMesArticlesAchetes();
			}

		if ("mesVentesEnCours".equals(toggleOption)) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesArticlesEnVente(id_utilisateur);

			}
		
		if ("mesVentesAVenir".equals(toggleOption)) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesVentesAVenir(id_utilisateur);
			}

		if ("mesVentesTerminees".equals(toggleOption)) {
				int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
				listeEncheres = ArticleManager.getInstance().recupererMesVentesTerminees(id_utilisateur);
			}

		request.setAttribute("ListeEncheres", listeEncheres);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);

	}

}
