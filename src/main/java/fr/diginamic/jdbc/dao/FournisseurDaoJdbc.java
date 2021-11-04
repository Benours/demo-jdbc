package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;

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
			System.out.println("Connecter");
			try (Statement state = connection.createStatement(); ResultSet result = state.executeQuery("SELECT * FROM `fournisseur`");) {
				while (result.next()) {
					liste.add(new Fournisseur(result.getInt("ID"), result.getString("NOM")));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return liste;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			System.out.println("Connecter");
			try (Statement state = connection.createStatement()) {
				System.out.println("Nombre de ligne insérer : " + state.executeUpdate("INSERT INTO `fournisseur`(`NOM`) VALUES ('" + fournisseur.getNom() + "')"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub

		int result = 0;
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			System.out.println("Connecter");
			try (Statement state = connection.createStatement()) {
				result = state.executeUpdate("UPDATE `fournisseur` SET `NOM`='" + nouveauNom + "' WHERE fournisseur.NOM = '" + ancienNom + "';");
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
			System.out.println("Connecter");
			try (Statement state = connection.createStatement()) {
				if ((state.executeUpdate("DELETE FROM `fournisseur` WHERE fournisseur.ID = " + fournisseur.getId() + " AND fournisseur.NOM = '" + fournisseur.getNom() + "'")) > 0)
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
