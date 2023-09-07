package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.ArticleManager;
import trocenchere.bll.UtilisateurManager;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;


public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletVendreUnArticle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vendreUnArticle.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String article = request.getParameter("article");
		System.out.println(article);
		
		String description = request.getParameter("description");
		System.out.println(description);

		String categorie = request.getParameter("categorie");
		System.out.println(categorie);

		String miseAprix = request.getParameter("miseAprix");
		System.out.println(miseAprix);

		String dateDebut = request.getParameter("dateDebut");

		String dateFin = request.getParameter("dateFin");
		
		
		LocalDate dateDebutEnchere =null;
		
		try {
			dateDebutEnchere = LocalDate.parse(dateDebut);
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
		System.out.println(dateDebutEnchere);

		
		LocalDate dateFinEnchere =null;
		
		try {
			dateFinEnchere = LocalDate.parse(dateFin);
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
		System.out.println(dateFinEnchere);
		
		Integer mise_a_prix =null;
		
		try {
			mise_a_prix = Integer.parseInt(miseAprix);
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
		System.out.println(mise_a_prix);
		
		Integer categorieEnchere =null;
		
		try {
			categorieEnchere = Integer.parseInt(categorie);
		} catch (DateTimeException e) {
			e.printStackTrace();
		}
		System.out.println(categorieEnchere);
		
		

		try {  
			ArticleManager.getInstance().insert(article, description, dateDebutEnchere,dateFinEnchere, mise_a_prix,categorieEnchere  );
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
