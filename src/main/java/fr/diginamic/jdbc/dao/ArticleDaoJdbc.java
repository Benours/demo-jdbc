package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.entites.Article;
import fr.diginamic.entites.Fournisseur;

public class ArticleDaoJdbc implements IDao<Article> {
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	private String updateSql = "UPDATE `article` SET `REF`=?,`DESIGNATION`=?,`PRIX`=?,`ID_FOU`=? WHERE article.REF = ?";
	private String extractSql = "SELECT article.ID, article.REF, article.DESIGNATION, article.PRIX, article.ID_FOU, fournisseur.NOM FROM `article`, `fournisseur` WHERE article.ID_FOU = fournisseur.ID;";
	private String insertSql = "INSERT INTO `article`(`REF`, `DESIGNATION`, `PRIX`, `ID_FOU`) VALUES (?,?,?,?)";
	private String deleteSql = "DELETE FROM `article` WHERE ID = ? AND REF = ?";

	static {
		ResourceBundle props = ResourceBundle.getBundle("database");
		DB_URL = props.getString("jdbc.db.url");
		DB_USER = props.getString("jdbc.db.user");
		DB_PWD = props.getString("jdbc.db.pwd");
	}

	@Override
	public List<Article> extraire() {
		// TODO Auto-generated method stub
		ArrayList<Article> liste = new ArrayList<>();

		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(extractSql); ResultSet result = ps.executeQuery();) {
				while (result.next()) {
					liste.add(new Article(result.getInt("ID"), result.getString("REF"), result.getString("DESIGNATION"), result.getFloat("PRIX"), new Fournisseur(result.getInt("ID_FOU"), result.getString("NOM"))));
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
	public void insert(Article article) {
		// TODO Auto-generated method stub
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
				ps.setString(1, article.getRef());
				ps.setString(2, article.getDesignation());
				ps.setFloat(3, article.getPrix());
				ps.setInt(4, article.getfournisseur().getId());
				System.out.println("Nombre de ligne insérer : " + ps.executeUpdate());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public int update(Article ancienArticle, Article nouvelArticle) {
		// TODO Auto-generated method stub

		int result = 0;
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
				ps.setString(1, nouvelArticle.getRef());
				ps.setString(2, nouvelArticle.getDesignation());
				ps.setFloat(3, nouvelArticle.getPrix());
				ps.setInt(4, nouvelArticle.getfournisseur().getId());
				ps.setString(5, ancienArticle.getRef());
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
	public boolean delete(Article article) {
		// TODO Auto-generated method stub
		boolean delete = false;
		try (Connection connection =  DriverManager.getConnection(DB_URL, DB_USER, DB_PWD)) {
			try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
				ps.setInt(1, article.getId());
				ps.setString(2, article.getRef());
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
