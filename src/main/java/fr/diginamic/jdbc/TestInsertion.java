package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle props = ResourceBundle.getBundle("database");
		String url = props.getString("jdbc.db.url");
		String user = props.getString("jdbc.db.user");
		String pwd = props.getString("jdbc.db.pwd");

		try (Connection connection =  DriverManager.getConnection(url, user, pwd)) {
			System.out.println("Connecter");
			try (Statement state = connection.createStatement()) {
				int result = state.executeUpdate("INSERT INTO `fournisseur`(`NOM`) VALUES ('La Maison de la Peinture')");
				System.out.println("Nombre de ligne insérer : " + result);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}


	}

}
