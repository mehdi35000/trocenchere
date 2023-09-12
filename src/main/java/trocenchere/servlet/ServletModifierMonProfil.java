package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import trocenchere.bll.EnchereManager;
import trocenchere.bll.UtilisateurManager;
import trocenchere.bo.Enchere;
import trocenchere.bo.Utilisateur;

import java.io.IOException;
import java.util.List;

public class ServletModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer idUtilisateurInteger = (Integer) request.getSession().getAttribute("idUtilisateur"); 

		if (idUtilisateurInteger != null) { // vérifier si l'id est bien présent (utile ? )
			Utilisateur utilisateurEnCours = UtilisateurManager.getInstance()
					.selectUtilisateurById(idUtilisateurInteger);// utiliser l'ID pour récupérer l'utilisateur
			request.setAttribute("utilisateurEnCours", utilisateurEnCours);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id_utilisateur = (int) request.getSession().getAttribute("idUtilisateur");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		
		
		//Utilisateur utilisateurMaj= null;
		Utilisateur utilisateurMaj = new Utilisateur(id_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville);
		
		try {
			
	        UtilisateurManager.getInstance().updateProfil(utilisateurMaj);

	        HttpSession session = request.getSession();
	        session.setAttribute("utilisateurEnCours", utilisateurMaj);

	        System.out.println("l'utilisateur mis à jour est : " + utilisateurMaj);

	        response.sendRedirect("ServletMonProfil");

	    } catch (Exception e) {
	        e.printStackTrace();		
			response.sendRedirect("ServletAccueil");	
	    }

	}

}
