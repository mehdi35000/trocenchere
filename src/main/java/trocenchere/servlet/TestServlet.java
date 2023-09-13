package trocenchere.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bo.Article;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.DAOFactory;
import trocenchere.dal.UtilisateurDAO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur util = DAOFactory.getUtilisateurDAO().selectUtilisateurById(4);
		
		List<Enchere> list = DAOFactory.getEnchereDAO().selectAllEnchereByUtilisateur(util);
		System.out.println(list);// TODO Auto-generated method stub
		

		Article article = DAOFactory.getArticleDAO().selectArticlesById(19);
		
		List<Enchere> listArticle = DAOFactory.getEnchereDAO().selectAllEnchereByArticle(article);
		System.out.println(listArticle);
		response.getWriter().append("Served at: \n" + list + "\n" + listArticle).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
