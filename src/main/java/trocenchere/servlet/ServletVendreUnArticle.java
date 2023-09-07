package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.ArticleManager;
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Categorie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletVendreUnArticle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date currentDate = new Date();
	    String formattedDate = dateFormat.format(currentDate);

	    // Stockez la date formatée dans un attribut de la requête
	    request.setAttribute("currentDate", formattedDate);
	    // Stockez la date formatée dans un attribut de la requête
	    request.setAttribute("currentDate", formattedDate);
		
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
		
		
		LocalDate dateDebutEnchere =LocalDate.now();
		request.setAttribute("dateDebut", dateDebutEnchere);
		
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
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(mise_a_prix);
		
		Integer categorieNumero = -1; //// Valeur par défaut en cas d'erreur
		
		try {
			categorieNumero = Integer.parseInt(categorie);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(categorieNumero);
<<<<<<< HEAD
=======
		
		Categorie c = new Categorie();
		c.setId_categorie(categorieNumero);
		
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git

		try {  
<<<<<<< HEAD
			ArticleManager.getInstance().insert(article, description, dateDebutEnchere,dateFinEnchere, mise_a_prix,categorieNumero);
=======
			ArticleManager.getInstance().insert(article, description, dateDebutEnchere,dateFinEnchere, mise_a_prix,c  );
>>>>>>> branch 'master' of https://github.com/mehdi35000/trocenchere.git
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
