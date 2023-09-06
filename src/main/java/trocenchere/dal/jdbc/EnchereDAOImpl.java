package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Enchere;
import trocenchere.dal.EnchereDAO;

public class EnchereDAOImpl implements EnchereDAO {
	
	private final static String SELECT_ALL_ENCHERES = """
	SELECT * FROM ENCHERES; """;
	
	@Override
	public List<Enchere> selectAllEncheres() {
	    List<Enchere> encheres = new ArrayList<>();

	    try (Connection cnx = ConnectionProvider.getConnection()) {
	        Statement stmt = cnx.createStatement();
	        ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERES);

	        while (rs.next()) {
	            Enchere enchere = new Enchere();
	            enchere.setDate_enchere(rs.getDate("date_enchere").toLocalDate());
	            enchere.setMontant_enchere(rs.getInt("montant_enchere"));

	            encheres.add(enchere);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return encheres;
	}


}//fin EnchereDAOimpl

