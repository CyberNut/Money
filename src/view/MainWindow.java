package view;

import controller.IController;
import model.Account;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JDialog {
    private IController controller;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbAccounts;
    private JTable tableOperations;
    private JPanel mainPanel;
    private JPanel innerPanel;
    private JPanel topPanel;
    private JPanel operationPanel;

    public MainWindow() {
        setContentPane(contentPane);
        setModal(true);
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

    private void onOK() {
        // add your code here
        dispose();
    }

    public IController getController() {
        return controller;
    }

    public void setController(IController controller) {
        this.controller = controller;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private String[] getAccountNames(List<Account> accountList) {
        String[] names = new String[accountList.size()];
        int i = 0;
        for (Account account : accountList) {
            names[i++] = account.getName();
        }
        return names;
    }

    public void open() {
        cbAccounts = new JComboBox(getAccountNames(controller.getAccounts()));
        pack();
        setVisible(true);
    }
}
