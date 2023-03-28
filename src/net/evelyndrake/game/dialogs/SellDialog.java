package net.evelyndrake.game.dialogs;

import net.evelyndrake.game.MainWindow;
import net.evelyndrake.game.inventory.Inventory;
import net.evelyndrake.game.inventory.ItemDrug;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class SellDialog extends JDialog {
    private MainWindow mainWindow;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel promptLabel;
    private JSlider slider1;
    private JLabel quantityLabel;
    private Inventory playerInventory;
    public int playerMoney;
    private ItemDrug drug;
    public SellDialog(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        playerInventory = mainWindow.getInventory();
        drug = mainWindow.getInventory().getSelectedDrug();
        promptLabel.setText("How much " + drug.getRawName() + " do you wish to sell?");

        slider1.setMinimum(1);
        slider1.setMaximum(playerInventory.getItemStack(playerInventory.getSelectedIndex()).getQuantity());
        slider1.setValue(slider1.getMaximum());
        quantityLabel.setText("Quantity: " + slider1.getValue() + " ($" + slider1.getValue()*drug.getCurrentPrice()+")");
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
                quantityLabel.setText("Quantity: "+source.getValue() + " ($" + slider1.getValue()*drug.getCurrentPrice()+")");
            }
        });
        setTitle("Sell "+drug.getRawName());
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        playerInventory.removeItem(drug, slider1.getValue());
        mainWindow.changeMoney(drug.getCurrentPrice() * slider1.getValue());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void display() {

    }

}
