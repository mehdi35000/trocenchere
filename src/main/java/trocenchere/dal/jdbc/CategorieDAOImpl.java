package trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trocenchere.bo.Categorie;
import trocenchere.dal.CategorieDAO;

public class CategorieDAOImpl implements CategorieDAO {

	public static final String SELECT_ALL_CATEGORIE = "SELECT * FROM CATEGORIES ;";

	public List<Categorie> selectAllCategorie() {
		List<Categorie> categories = new ArrayList<Categorie>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_CATEGORIE);

			Categorie categorie = null;

			while (rs.next()) {
				int idCategorieEnCours = rs.getInt("id_categorie");

				String libelle = rs.getString("libelle");
				categorie = new Categorie(idCategorieEnCours, libelle);
				categories.add(categorie);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

}
