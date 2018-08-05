package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    private static Connection connection;
    private static DBHelper instance;
    private static String connectionString = "jdbc:postgresql://localhost:5432/money";
    private static String dbUser = "user";
    private static String dbUserPassword = "12345@qw";

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(connectionString, dbUser, dbUserPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private DBHelper() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = getConnection();
    }
}
