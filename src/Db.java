import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
    public Connection connectToDb() {
        Connection connection = null;
        String user = "postgres";
        String password = "postgres";
        String dbName = "school-management";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if (connection != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Error occurred");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
