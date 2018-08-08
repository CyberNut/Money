import controller.Controller;
import controller.IController;
import model.*;
import view.AuthorizationWindow;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        IController controller = new Controller();
        authoriseUser(controller);
//        DBHelper dbHelper = DBHelper.getInstance();
//        test(DBHelper.getConnection());

    }

    private static void authoriseUser(IController controller) {
        AuthorizationWindow dialog = new AuthorizationWindow(controller);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
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
