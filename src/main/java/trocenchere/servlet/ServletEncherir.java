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
import trocenchere.bo.Article;

import java.io.IOException;


public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // Récupérer l'ID de l'article
	    int id_Article = Integer.valueOf(request.getParameter("id_Article"));

	    // Récupérer l'article
	    ArticleManager articleManager = ArticleManager.getInstance();
	    Article article = articleManager.selectArticlesById(id_Article);

	    // Stocker l'article dans la requête
	    request.setAttribute("article", article);

	    // Forwarder la requête à la servlet de détail de l'article
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encherir.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
