import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String BDD = "events";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn = DriverManager.getConnection(url, user, null);
		    System.out.println("Connecter");
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);
		}
		
	}

}
