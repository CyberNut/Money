package model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
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
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(connectionString, dbUser, dbUserPassword);
                prepareTables();

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

    private static String readFile(String fileName) {
        java.net.URL url = DBHelper.class.getResource(fileName);
        java.nio.file.Path resPath = null;
        try {
            resPath = java.nio.file.Paths.get(url.toURI());
            return new String(java.nio.file.Files.readAllBytes(resPath), "UTF8");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean prepareTables() {
        String createSQL = readFile("create.sql");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            return true;
        } catch (SQLException e) {
            System.out.println("Something is wrong!");
            e.printStackTrace();
            return false;
        }
    }
}
