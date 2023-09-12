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
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Retrait;
import trocenchere.bo.Utilisateur;

import java.io.IOException;


public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//  récupérer l'identifiant de l'article à afficher et le convertir en entier
	    int id_Article = Integer.valueOf(request.getParameter("id_Article"));

	    	// accéder aux méthodes de gestion des articles.
	    ArticleManager articleManager = ArticleManager.getInstance();
	    
	    	// récupérer l'article correspondant à l'identifiant 
	    Article article = articleManager.selectArticlesById(id_Article);
	    Retrait retrait = articleManager.selectRetraitByIdArticle(id_Article);
	    
	    	// Stocker l'article dans la requête
	    request.setAttribute("article", article);
	    request.setAttribute("retrait", retrait);
	    
	    	// récupère l'identifiant de la catégorie de l'article
	    int id_categorie = article.getCategorie().getId_categorie();
	    
	    	// crée une instance du gestionnaire de catégories 
	    CategorieManager categorieManager = CategorieManager.getInstance();
	    
	    	//utilise le gestionnaire de catégories pour récupérer la catégorie correspondant à l'identifiant
	    Categorie categorie = categorieManager.selectCategorieById(id_categorie);
	    
	    	///stocke l'objet pour accéder à la catégorie dans la page JSP
	    request.setAttribute("categorie", categorie);
	    
	    
	    	//récupère l'identifiant de l'utilisateur (vendeur) de l'article
	    int id_utilisateur = article.getUtilisateur().getId_utilisateur();
	    
	    	//crée une instance du gestionnaire d'utilisateurs 
	    UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	    
	    	//récupérer l'utilisateur correspondant à l'identifiant 
	    Utilisateur utilisateur = utilisateurManager.selectUtilisateurById(id_utilisateur);
	    
	    	//stocke l'objet pour accéder à l'utilisateur dans la page JSP
	    request.setAttribute("utilisateur", utilisateur);

	    
	    
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encherir.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
