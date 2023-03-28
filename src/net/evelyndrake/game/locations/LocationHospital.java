package net.evelyndrake.game.locations;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;

public class LocationHospital extends LocationGeneric {

    private MainWindow mainWindow;

    public LocationHospital(String name, String buttonText, int marketPercentage, boolean hasButton, MainWindow mainWindow, int risk) {
        super(name, buttonText, marketPercentage, hasButton, risk);
        this.mainWindow = mainWindow;
    }

    public void buttonAction() {
        if (mainWindow.getHealth() < 100) {
            int result = JOptionPane.showConfirmDialog(new JFrame(),"Want me to fix you up? It will be $2000.", "Hospital",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                if (mainWindow.getMoney() >= 2000) {
                    mainWindow.changeMoney(-2000);
                    JOptionPane.showMessageDialog(new JFrame(), "You were healed to full health.", "Hospital", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "You cannot afford treatment at this time.", "Hospital", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "You are already at full health!", "Hospital", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
