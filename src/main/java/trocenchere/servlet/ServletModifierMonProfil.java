package trocenchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trocenchere.bll.EnchereManager;
import trocenchere.bo.Enchere;

import java.io.IOException;
import java.util.List;


public class ServletModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierMonProfil.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("enregistrer") != null) {
	        response.sendRedirect("accueil.jsp");
	    } else if (request.getParameter("supprimer") != null) {
	        response.sendRedirect("accueil.jsp");
	    }
	}

}
