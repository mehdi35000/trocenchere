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
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	
    	session.setAttribute("pseudoUtilisateur", "Mars");
    	session.setAttribute("idUtilisateur", 8);
    	
    	session.setAttribute("utilisateur", DAOFactory.getUtilisateurDAO().selectUtilisateurById(8));
    	
		List<Article> articlesEnVente = ArticleManager.getInstance().selectAllArticlesEnVente();
		request.setAttribute("articlesEnVente", articlesEnVente);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
	
	
		List<Categorie>  categorie = CategorieManager.getInstance().selectAllCategorie();
		//System.out.println(categorie.toString());
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

