package net.evelyndrake.game.dialogs;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class PoliceEventDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonFight;
    private JButton buttonRun;
    private JLabel officerHealthLabel;
    private JLabel playerHealthLabel;
    private JTextArea eventArea;
    private JTextPane eventPane;
    private MainWindow mainWindow;
    private int officerHealth = 100;
    private Random rand;

    public PoliceEventDialog(MainWindow mainWindow) {
        rand = new Random();
        this.mainWindow = mainWindow;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonFight);

        buttonFight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonRun.addActionListener(new ActionListener() {
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

        setTitle("Busted!!!");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonFight);
        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        int missChance = 5;
        int playerDamage = rand.nextInt(11) + 10;
        if (rand.nextInt(missChance) == 0) {
            displayMessage("You missed!\n");
        } else {
            displayMessage("You attacked the officer for " + playerDamage + " damage!\n");
            officerHealth -= playerDamage;
        }
        int officerDamage = rand.nextInt(11) + 10;
        if (rand.nextInt(missChance) == 0) {
            displayMessage("The officer missed!\n");
        } else {
            displayMessage("The officer attacked you for " + officerDamage + " damage!\n");
            mainWindow.changeHealth(-1*officerDamage);
        }
        if (mainWindow.getHealth() <= 0) {
            dispose();
            EndGameDialog dialog = new EndGameDialog(mainWindow);
        }
        if (officerHealth <= 0) {
            dispose();
        }
        updateLabels();
        // add your code here
        // dispose();
    }

    private void onCancel() {
        int evadeChance = 4;
        if (rand.nextInt(evadeChance) == 0) {
            dispose();
        } else {
            displayMessage("You tried to escape, but you tripped!\n");
            int missChance = 5;
            int officerDamage = rand.nextInt(11) + 10;
            if (rand.nextInt(missChance) == 0) {
                displayMessage("The officer missed!\n");
            } else {
                displayMessage("The officer attacked you for " + officerDamage + " damage!\n");
                mainWindow.changeHealth(-1*officerDamage);
            }
            if (mainWindow.getHealth() <= 0) {
                dispose();
                EndGameDialog dialog = new EndGameDialog(mainWindow);
            }
            updateLabels();
        }
    }

    private void updateLabels() {
        officerHealthLabel.setText("Officer Health: " + officerHealth);
        playerHealthLabel.setText("Your Health: " + mainWindow.getHealth());
    }

    private void displayMessage(String string) {
        eventArea.append(string);
        eventArea.setCaretPosition(eventArea.getDocument().getLength());
    }

}
