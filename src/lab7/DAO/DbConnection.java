package lab7.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getDBconnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/lab7";
            connection =
                    DriverManager.getConnection( dbURL, "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
