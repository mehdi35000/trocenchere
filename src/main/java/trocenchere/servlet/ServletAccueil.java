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
import trocenchere.bll.EnchereManager;
import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.dal.jdbc.ConnectionProvider;


public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Article> articlesEnVente = ArticleManager.getInstance().selectAllArticlesEnVente();
		request.setAttribute("articlesEnVente", articlesEnVente);
		System.out.println(articlesEnVente);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		rd.forward(request, response);
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			System.out.println("Message connection ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

