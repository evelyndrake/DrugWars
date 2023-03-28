package net.evelyndrake.game.dialogs;

import net.evelyndrake.game.MainWindow;
import net.evelyndrake.game.inventory.Inventory;
import net.evelyndrake.game.inventory.ItemDrug;
import net.evelyndrake.game.inventory.ItemStack;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class PurchaseDialog extends JDialog {
    private MainWindow mainWindow;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel moneyLabel;
    private JLabel promptLabel;
    private JSlider slider1;
    private JLabel quantityLabel;
    private Inventory playerInventory;
    public int playerMoney;
    private ItemDrug drug;
    public PurchaseDialog(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        playerInventory = mainWindow.getInventory();
        drug = mainWindow.getMarket().getSelectedDrug();
        playerMoney = mainWindow.getMoney();
        // set label text
        moneyLabel.setText("Money: " + playerMoney);
        promptLabel.setText("How much " + drug.getRawName() + " do you wish to purchase?");
        // ensure that player has space and money to make the purchase
        int inventoryMax = playerInventory.getFreeSpaces();
        int amount = playerMoney/drug.getCurrentPrice();
        if (amount > inventoryMax) {
            amount = inventoryMax;
        }
        slider1.setMinimum(1);
        slider1.setMaximum(amount);
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
        setTitle("Purchase "+drug.getRawName());
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.pack();
        this.setVisible(true);
    }

    private void onOK() {
        ItemStack is = new ItemStack(drug, slider1.getValue());
        playerInventory.addItem(is);
        mainWindow.changeMoney(drug.getCurrentPrice() * slider1.getValue() * -1);
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
