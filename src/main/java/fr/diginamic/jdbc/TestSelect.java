package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle props = ResourceBundle.getBundle("database");
		String url = props.getString("jdbc.db.url");
		String user = props.getString("jdbc.db.user");
		String pwd = props.getString("jdbc.db.pwd");
		
		ArrayList<Fournisseur> liste = new ArrayList<>();

		try (Connection connection =  DriverManager.getConnection(url, user, pwd)) {
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
		
		for (Fournisseur fournisseur : liste) {
			System.out.println(fournisseur.toString());
		}

	}

}
