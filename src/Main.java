import model.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DBHelper dbHelper = DBHelper.getInstance();
        test(DBHelper.getConnection());

    }

    private static void test(Connection connection) {

        User andrey = new User("andrey", "Andrey");
        User anna = new User("anna", "Anna");

        AccountsManager.addAccount(new Account( andrey, MoneyType.CASH, "Cash Andrey"));
        AccountsManager.addAccount(new Account(anna, MoneyType.CASHLESS, "Tinkoff black Anna"));
        AccountsManager.addAccount(new Account(anna, MoneyType.CASH, "Cash Anna"));
        AccountsManager.addAccount(new Account( andrey, MoneyType.CASHLESS, "Tinkoff black Andrey"));
        AccountsManager.addAccount(new Account( andrey, MoneyType.CASHLESS, "Tinkoff credit card"));

        AccountsManager.printOnConsole();

    }
}
