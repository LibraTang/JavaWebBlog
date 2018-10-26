package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost/account" + "?serverTimezone=GMT%2B8" + "&useSSL=false";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String USER = "root";
    static final String PASS = "password";

    public static Connection dbconnect(Connection conn) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return conn;
        }
    }
}
