package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.EnchereManager;
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;

import java.io.IOException;
import java.util.List;


public class ServletModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		Integer idUtilisateurInteger = (Integer) request.getSession().getAttribute("idUtilisateur"); //récupérer l'id de l'utilisateur depuis la session

	    if (idUtilisateurInteger != null) { //vérifier si l'id est bien présent (utile ? )
	        Utilisateur utilisateurEnCours = UtilisateurManager.getInstance().selectUtilisateurById(idUtilisateurInteger);//utiliser l'ID pour récupérer l'utilisateur
	        request.setAttribute("utilisateurEnCours", utilisateurEnCours); //placer l'utilisateur dans la requête pour l'affichage dans la jsp
	    }
	    
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idUtilisateurInteger = (Integer) request.getSession().getAttribute("idUtilisateur");
		Utilisateur utilisateurMaj = new Utilisateur(idUtilisateurInteger, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
		UtilisateurManager.getInstance().updateProfil(utilisateurMaj);
		
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
			
				RequestDispatcher rd = request.getRequestDispatcher("ServletAccueil");
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
		
		if (request.getParameter("Enregistrer les modifications") != null) {
	        response.sendRedirect("ServletAccueil");
	    } else if (request.getParameter("Supprimer le profil") != null) {
	        response.sendRedirect("ServletAccueil");
	    }
	}

}
