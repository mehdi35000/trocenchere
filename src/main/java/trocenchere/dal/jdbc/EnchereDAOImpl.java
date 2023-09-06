package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.repas.bo.Aliment;
import fr.eni.repas.dal.jdbc.ConnectionProvider;
import trocenchere.bo.Enchere;
import trocenchere.dal.EnchereDAO;

public class EnchereDAOImpl implements EnchereDAO {
	
	private final static String SELECT_ALL_ENCHERES = """
	SELECT * FROM ENCHERES; """;
	
	@Override
	public List<Enchere> selectAllEncheres(){
		List<Enchere> encheres = new ArrayList<>(); //mettre Enchere ou pas dans le diamant ?
		
		//je demande une connexion
		try (Connection cnx = ConnectionProvider.getConnection()) {
		// je prépare ma requête selectAll	
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERES);
		
			
			
			
		}//fin de méthode
		
		


}//fin EnchereDAOimpl

