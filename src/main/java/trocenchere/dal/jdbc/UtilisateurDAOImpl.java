package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import trocenchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE id_utilisateur = ?;";

@Override
public void delete(int id_utilisateur) {
	try(Connection cnx = ConnectionProvider.getConnection()) {
		PreparedStatement pStmt = cnx.prepareStatement(DELETE);
		pStmt.setInt(1, id_utilisateur);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
}