package view;

import controller.IController;
import model.Account;
import model.MoneyType;
import model.User;

import javax.swing.*;
import java.awt.event.*;

public class AccountWindow extends JDialog {
    private IController controller;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldName;
    private JTextField textFieldUser;
    private JTextField textFieldMoneyType;
    private JLabel labelAccountName;
    private JLabel labelUser;
    private JLabel labelMoneyType;
    private JPanel bottomPanel;
    private JPanel mainPanel;

    public AccountWindow(IController controller) {
        this.controller = controller;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Create new account");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    private void onOK() {

        if ("".equals(textFieldName) == true || "".equals(textFieldMoneyType) == true || "".equals(textFieldUser) == true) {
            MessageBox.show("Incorrect data", "My finance");
            return;
        }

        User user = controller.getUserByName(textFieldUser.getText());
        if (user != null) {
            Account newAccount = new Account(user, textFieldMoneyType.getText().equals("CASH") ? MoneyType.CASH : MoneyType.CASHLESS, textFieldName.getText());
            controller.addAccount(newAccount);
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
