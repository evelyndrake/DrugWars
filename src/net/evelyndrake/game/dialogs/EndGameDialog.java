package net.evelyndrake.game.dialogs;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel scoreLabel;

    public EndGameDialog(MainWindow mainWindow) {
        int score = mainWindow.getMoney() * 2 - mainWindow.getDebt() * 4;
        if (score < 0) {
            score = 0;
        }
        setTitle("Game over!");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        scoreLabel.setText("Your score: " + score);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        pack();
        setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

}
