package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trocenchere.bo.Utilisateur;
import trocenchere.dal.UtilisateurDAO;
import trocenchere.dal.jdbc.UtilisateurDAOImpl;

import java.io.IOException;


public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter ("pseudo");
		String mot_de_passe = request.getParameter ("motDePasse");
		
		  // vérifier l'authentification
	    UtilisateurDAO utilisateurDAO = new UtilisateurDAOImpl();
	    Utilisateur utilisateur = utilisateurDAO.connexionUtilisateur(pseudo, mot_de_passe);

	    if (utilisateur != null) {
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("idUtilisateur", utilisateur.getPseudo());
	        
	    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
			rd.forward(request, response);
			
	    } else {
	    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
			rd.forward(request, response);

	    }
	}
}