package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	private String updateSql = "UPDATE `fournisseur` SET `NOM`= ? WHERE fournisseur.NOM = ?;";
	private String extractSql = "SELECT * FROM `fournisseur`";
	private String insertSql = "INSERT INTO `fournisseur`(`NOM`) VALUES (?)";
	private String deleteSql = "DELETE FROM `fournisseur` WHERE fournisseur.ID = ? AND fournisseur.NOM = ?";

	static {
		ResourceBundle props = ResourceBundle.getBundle("database");
		DB_URL = props.getString("jdbc.db.url");
		DB_USER = props.getString("jdbc.db.user");
		DB_PWD = props.getString("jdbc.db.pwd");
	}

	@Override
	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		ArrayList<Fournisseur> liste = new ArrayList<>();

		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(extractSql); ResultSet result = ps.executeQuery();) {
				while (result.next()) {
					liste.add(new Fournisseur(result.getInt("ID"), result.getString("NOM")));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
				ps.setString(1, fournisseur.getNom());
				System.out.println("Nombre de ligne insérer : " + ps.executeUpdate());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub

		int result = 0;
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
				ps.setString(1, nouveauNom);
				ps.setString(2, ancienNom);
				result = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		boolean delete = false;
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
				ps.setInt(1, fournisseur.getId());
				ps.setString(2, fournisseur.getNom());
				if ((ps.executeUpdate()) > 0)
					delete = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return delete;
	}

}
