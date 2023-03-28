package net.evelyndrake.game.dialogs;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class LoanDialog extends JDialog {
    private MainWindow mainWindow;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel moneyLabel;
    private JLabel promptLabel;
    private JSlider slider1;
    private JLabel quantityLabel;
    private int playerMoney;
    private int playerDebt;
    public LoanDialog(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        playerMoney = mainWindow.getMoney();
        playerDebt = mainWindow.getDebt();
        // set label text
        moneyLabel.setText("Money: " + playerMoney);
        promptLabel.setText("How much money do you wish to repay?");
        int amount = playerMoney;
        // set max amount to total amount of debt if player's money exceeds it
        if (amount > playerDebt) {
            amount = playerDebt;
        }
        // ensure that player will have $100 remaining
        if (playerMoney - amount < 100) {
            amount -= 100;
        }
        slider1.setMinimum(1);
        slider1.setMaximum(amount);
        slider1.setValue(slider1.getMaximum());
        quantityLabel.setText("Money to Repay: $" + slider1.getValue());
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
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                quantityLabel.setText("Money to Repay: $" + slider1.getValue());
            }
        });
        setTitle("Pay Loan");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        mainWindow.changeMoney(-slider1.getValue());
        mainWindow.changeDebt(-slider1.getValue());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void updateLabel() {

    }

    public void display() {

    }

}
