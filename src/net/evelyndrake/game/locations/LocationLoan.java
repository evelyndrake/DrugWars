package net.evelyndrake.game.locations;

import net.evelyndrake.game.MainWindow;
import net.evelyndrake.game.dialogs.LoanDialog;

import javax.swing.*;

public class LocationLoan extends LocationGeneric {

    private MainWindow mainWindow;

    public LocationLoan(String name, String buttonText, int marketPercentage, boolean hasButton, MainWindow mainWindow, int risk) {
        super(name, buttonText, marketPercentage, hasButton, risk);
        this.mainWindow = mainWindow;
    }

    public void buttonAction() {
        if (mainWindow.getDebt() <= 0) {
            JOptionPane.showMessageDialog(new JFrame(), "You've already repaid your loan!", "Pay Loan", JOptionPane.PLAIN_MESSAGE);
        } else if (mainWindow.getMoney() <= 0) {
            JOptionPane.showMessageDialog(new JFrame(), "You have no money!", "Pay Loan", JOptionPane.PLAIN_MESSAGE);
        } else {
            LoanDialog dialog = new LoanDialog(mainWindow);
        }
    }
}
