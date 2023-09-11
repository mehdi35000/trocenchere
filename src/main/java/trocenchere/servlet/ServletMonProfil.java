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


public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession();
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monprofil.jsp");
		rd.forward(request, response);
		
		String username = (String) request.getSession().getAttribute("pseudoUtilisateur");
		request.setAttribute("pseudoUtilisateur", username);
		
		Utilisateur utilisateurEnCours = UtilisateurManager.getInstance().selectUtilisateurById();
		
	}
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer idUtilisateurInteger = (Integer) request.getSession().getAttribute("idUtilisateur"); //récupérer l'id de l'utilisateur depuis la session

	    if (idUtilisateurInteger != null) { //vérifier si l'id est bien présent (utile ? )
	        Utilisateur utilisateurEnCours = UtilisateurManager.getInstance().selectUtilisateurById(idUtilisateurInteger);//utiliser l'ID pour récupérer l'utilisateur
	        request.setAttribute("utilisateurEnCours", utilisateurEnCours); //placer l'utilisateur dans la requête pour l'affichage dans la jsp
	    }
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monprofil.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
