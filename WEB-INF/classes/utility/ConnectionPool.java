package utility;

import java.sql.*;

/**
 *
 * @author Aditi ConnectionPool Utility class to get the RDS database connection.
 */
public class ConnectionPool {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbName = "tipsdb";
        String userName = "agoel4";
        String password = "Assignment2";
        String hostname = "dbmurach.cgswxlllhe4p.us-west-2.rds.amazonaws.com";
        String port = "3306";
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        return DriverManager.getConnection(jdbcUrl);
    }
}