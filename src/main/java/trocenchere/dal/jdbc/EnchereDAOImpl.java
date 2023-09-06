package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			
			while (rs.next()) {
	            Enchere enchere = new Enchere();
	            
	            int id_enchere = rs.getInt("id_enchere");
	            LocalDate date = rs.getDate("date").toLocalDate();
	            int montant_enchere montant_enchere = rs.
	            		
	            /*		
	            enchere.setMontantEnchere(rs.getInt("montant_enchere"));
	            enchere.setIdArticle(rs.getInt("id_article"));
	            enchere.setIdUtilisateur(rs.getInt("id_utilisateur"));
	            */

            encheres.add(enchere);
			}
		
		}
			catch (SQLException e) {
			e.printStackTrace();
			//BusinessException be = new BusinessException();
			//be.ajouterErreur("Erreur lors de la récupération des données : " + e.getMessage());
			//throw be;
		}
			
		return encheres;
		}//fin de méthode
		
		


}//fin EnchereDAOimpl

