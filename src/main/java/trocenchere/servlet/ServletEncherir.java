package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trocenchere.bll.ArticleManager;
import trocenchere.bll.CategorieManager;
import trocenchere.bll.EnchereManager;
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Enchere;
import trocenchere.bo.Retrait;
import trocenchere.bo.Utilisateur;

import java.io.IOException;
import java.time.LocalDate;

public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// récupérer l'identifiant de l'article à afficher et le convertir en entier
		int id_Article = Integer.valueOf(request.getParameter("id_Article"));

		// accéder aux méthodes de gestion des articles.
		ArticleManager articleManager = ArticleManager.getInstance();

		// récupérer l'article correspondant à l'identifiant
		Article article = articleManager.selectArticlesById(id_Article);

		// Stocker l'article dans la requête
		request.setAttribute("article", article);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encherir.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int montant_Enchere = Integer.parseInt(request.getParameter("enchere"));

		System.out.println("montant_Enchere " + montant_Enchere);
		LocalDate date_enchere = LocalDate.now();

		// Récupérer l'utilisateur encherisseur depuis la session
		Utilisateur utilisateurEncherisseur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		int id_Article = Integer.parseInt(request.getParameter("id_Article"));
		System.out.println("id_Article " + id_Article);
		
		Article articleEnCours = ArticleManager.getInstance().selectArticlesById(id_Article);

		// insérer la nouvelle enchère dans la base de données
		EnchereManager.getInstance().insert(date_enchere, montant_Enchere, utilisateurEncherisseur, articleEnCours);

		RequestDispatcher rd = request.getRequestDispatcher("ServletAccueil");
		rd.forward(request, response);
	}
}
