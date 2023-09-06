package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.UtilisateurManager;
import java.io.IOException;

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
		String confirm = request.getParameter ("confirmation");
		
		
		if (mot_de_passe.equals (confirm)) {
			try {  
				UtilisateurManager.getInstance().insert(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, false);
			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				rd.forward(request, response);
			
			} catch (Exception e) {
				  // Gérer les erreurs ici
				e.printStackTrace();
			}
	    } else if (!mot_de_passe.equals(confirm)){
	        // Les mots de passe ne correspondent pas, rediriger vers la page de connexion
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
	        rd.forward(request, response);
	    }
		
		//System.out.println("mot_de_passe : " + mot_de_passe);
		// System.out.println("confirm : " + confirm);
		 // pour le moment, lors d'une mauvaise insertion du mot de passe on retombe sur la page de connexion.
		// Il faut faire la gestion des erreurs et notifier que les mots de passe ne sont pas les memes.
	}

}
