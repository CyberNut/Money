package view;

import controller.IController;

import javax.swing.*;
import java.awt.event.*;

public class AuthorizationWindow extends JDialog {
    private IController controller;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelUserName;
    private JTextField userName;
    private JLabel labelPassword;
    private JTextField userPassword;
    private JLabel labelRegister;
    private JLabel labelTitle;
    private JPanel mainPanel;
    private JPanel bottomPanel;

    public AuthorizationWindow(IController controller) {
        this.controller = controller;
        setContentPane(contentPane);
        setTitle("My finance");
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

        labelRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RegisterWindow dialog = new RegisterWindow(controller);
                dialog.pack();
                dialog.setVisible(true);
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
        if (!"".equals(userName.getText())) {
            if (controller.authoriseUser(userName.getText(), userPassword.getText())) {
                //MessageBox.show("Welcome to my finance", "My finance");
                MainWindow mainWindow = new MainWindow(controller);
                mainWindow.open();
                //dispose();
            } else {
                MessageBox.show("Username or password is incorrect", "My finance");
            }
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
