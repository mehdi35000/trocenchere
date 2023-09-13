package trocenchere.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trocenchere.bll.ArticleManager;
import trocenchere.bo.Article;
import trocenchere.bo.Categorie;
import trocenchere.bo.Retrait;


public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int utilisateurID;
   
    public ServletVendreUnArticle() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	utilisateurID= (int) session.getAttribute("idUtilisateur");
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
		
		String rue = request.getParameter("rue");
		
		String codePostal = request.getParameter("code_postal");
		
		String ville = request.getParameter("ville");
		
		Retrait retrait =  new Retrait ();
		
		retrait.setRue(rue);
		retrait.setCodePostal(codePostal);
		retrait.setVille(ville);
		
		

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
		
		Integer categorieNumero = -1; //// Valeur par défaut en cas d'erreur
		
		try {
			categorieNumero = Integer.parseInt(categorie);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		
		Categorie c = new Categorie();
		c.setId_categorie(categorieNumero);
		


		try {  

			
			ArticleManager.getInstance().insert(article, description, dateDebutEnchere,dateFinEnchere, mise_a_prix,c,utilisateurID,retrait  );

			response.sendRedirect("ServletAccueil"); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
