package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trocenchere.bo.Utilisateur;
import trocenchere.dal.UtilisateurDAO;

public class UtilisateurDAOImpl implements UtilisateurDAO{

	private final static String SELECT_CONNEXION = "SELECT id_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
													+ "FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	
	private final static String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			
	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE id_utilisateur = ?;";

@Override
public void insert(Utilisateur nouvelUtilisateur) {
	try (Connection cnx = ConnectionProvider.getConnection()){
		
		PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1,nouvelUtilisateur.getPseudo());
		pstmt.setString(2,nouvelUtilisateur.getNom());
		pstmt.setString(3,nouvelUtilisateur.getPrenom());
		pstmt.setString(4,nouvelUtilisateur.getEmail());
		pstmt.setString(5,nouvelUtilisateur.getTelephone());
		pstmt.setString(6,nouvelUtilisateur.getRue());
		pstmt.setString(7,nouvelUtilisateur.getCode_postal());
		pstmt.setString(8,nouvelUtilisateur.getVille());
		pstmt.setString(9,nouvelUtilisateur.getMot_de_passe());
		pstmt.setInt(10,nouvelUtilisateur.getCredit());
		pstmt.setBoolean(11,nouvelUtilisateur.isAdministrateur());

		pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
public Utilisateur connexionUtilisateur(String pseudo, String mot_de_passe) {
	
	PreparedStatement pstmt  = null;
	ResultSet rs = null;
	Utilisateur utilisateur = null;
	
	try (Connection cnx = ConnectionProvider.getConnection()){
		
		pstmt = cnx.prepareStatement(SELECT_CONNEXION);
		pstmt.setString(1,pseudo);
		pstmt.setString(2,mot_de_passe);
		
		pstmt.executeQuery();
		
		if (rs.next()) {
		utilisateur = new Utilisateur ();
		utilisateur.setId_utilisateur(rs.getInt ("id_utilisateur"));
		utilisateur.setPseudo(rs.getString ("pseudo"));
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

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