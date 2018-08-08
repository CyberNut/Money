package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBDataStore implements DataStore {

    DBHelper dbHelper = DBHelper.getInstance();

    @Override
    public boolean authoriseUser(String userName, String password) {
        Connection connection = dbHelper.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?")) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean findUser(String userName) {
        Connection connection = dbHelper.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            preparedStatement.setString(1, userName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createUser(String userName, String password) {
        if (findUser(userName)) {
            System.out.println("Username is busy!");
            return false;
        }
        Connection connection = dbHelper.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?, ?)")) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createAccount(String description, String moneyType, String userName) {
        return false;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public boolean createCategory(String name) {
        return false;
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }
}
