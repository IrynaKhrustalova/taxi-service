package taxi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL_TO_DATABASE = "jdbc:mysql://YOUR_URL_TO_DATABASE: ";
    private static final String PORT = "YOUR_PORT_NUMBER";

    private static final String DATABASE_NAME = "YOUR_DATABASE_NAME";
    private static final String DATABASE_USERNAME = "YOUR_USERNAME";
    private static final String DATABASE_PASSWORD = "YOUR_PASSWORD";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", DATABASE_USERNAME);
        dbProperties.setProperty("password", DATABASE_PASSWORD);
        try {
            return DriverManager.getConnection(URL_TO_DATABASE
                    + PORT + DATABASE_NAME, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB ", e);
        }
    }
}
