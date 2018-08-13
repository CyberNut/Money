package model;

import java.sql.*;
import java.util.ArrayList;
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
    public boolean createAccount(Account account) {
        return false;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = dbHelper.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DESCRIPTION, MONEY_TYPE, USER_NAME  FROM accounts")) {
            if (resultSet.next()) {
                String description = resultSet.getString(1);
                String moneyType = resultSet.getString(2);
                String userName = resultSet.getString(3);
                if (findUserByName(userName) != null) {
                    Account tempAccount = new Account(new User(userName), "CASH".equals(moneyType) ? MoneyType.CASH : MoneyType.CASHLESS, userName);
                    accounts.add(tempAccount);
                }
            } else {
                return accounts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return accounts;
        }
        return accounts;
    }

    @Override
    public User findUserByName(String userName) {
        Connection connection = dbHelper.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            preparedStatement.setString(1, userName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(userName);
                } else {
                    return null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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