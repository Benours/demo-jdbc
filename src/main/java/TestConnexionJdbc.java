import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ResourceBundle;


public class TestConnexionJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle props = ResourceBundle.getBundle("database");
		String url = props.getString("jdbc.db.url");
		String user = props.getString("jdbc.db.user");
		String pwd = props.getString("jdbc.db.pwd");

		try {
			Connection connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connecter");


			Statement state = connection.createStatement();
			int result = state.executeUpdate("CREATE TABLE `compte` (\r\n"
					+ "  `id` int(8) NOT NULL,\r\n"
					+ "  `numerocompte` bigint(255) NOT NULL,\r\n"
					+ "  `typecompte` varchar(11) NOT NULL,\r\n"
					+ "  `valeurcreditee` double NOT NULL,\r\n"
					+ "  `tauxplacement` double NOT NULL\r\n"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;");
			
			System.out.println(result);

			state.close();


			connection.close();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}

	}

}
