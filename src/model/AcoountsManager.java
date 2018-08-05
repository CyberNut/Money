package model;

import java.util.ArrayList;
import java.util.List;

public class AcoountsManager {

    private static List<Account> accounts = new ArrayList<>();
    private  static String tableName = "RefAccounts";


    public void addAccount(Account account) {
        //TODO: need control unique of accounts
        accounts.add(account);
    }

    public static boolean readFromDB() {
        return true;
    }

    public static boolean writeToRB() {

        return true;
    }


}
