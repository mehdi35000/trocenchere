package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Utilisateur;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class ServletInscription
 */
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter ("pseudo");
		String nom = request.getParameter ("nom");
		String prenom = request.getParameter ("prenom");
		String email = request.getParameter ("email");
		String telephone = request.getParameter ("telephone");
		String rue = request.getParameter ("rue");
		String code_postal = request.getParameter ("codePostal");
		String ville = request.getParameter ("ville");
		String mot_de_passe = request.getParameter ("motDePasse");
		String confirm = request.getParameter ("confirm");
		
		
	
		try {  
			UtilisateurManager.getInstance().insert(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, false);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
