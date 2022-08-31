package taxi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String URL_TO_DATABASE = "jdbc:mysql://db4free.net: ";
    private static final String PORT = "3306";

    private static final String DATABASE_NAME = "/sql220491";
    private static final String DATABASE_USERNAME = "sql220491";
    private static final String DATABASE_PASSWORD = "220491Ira!";
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
