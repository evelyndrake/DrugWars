package net.evelyndrake.game.inventory;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Inventory {
    ArrayList<ItemStack> itemList;
    DefaultListModel listModel;
    private JList attachedList;
    private JButton sellButton;
    int capacity = 100;
    int currentCapacity = 0;
    private MainWindow mainWindow;

    public Inventory(JList attachedList, JButton sellButton, MainWindow mainWindow) {
        this.sellButton = sellButton;
        this.attachedList = attachedList;
        listModel = new DefaultListModel();
        itemList = new ArrayList();
        attachedList.setModel(listModel);
        this.mainWindow = mainWindow;
    }

    public Inventory(JList attachedList) {
        this.attachedList = attachedList;
        listModel = new DefaultListModel();
        itemList = new ArrayList();
        attachedList.setModel(listModel);
    }

    public boolean removeItem(Item item, int quantity) { // removes an item from the inventory
        for (int x = 0; x < itemList.size(); x++) {
            ItemStack is = itemList.get(x);
            if (is.getItem().getName().equals(item.getName())) { // if items are the same...
                is.changeQuantity(-1*quantity);
                if (is.quantity <= 0) {
                    itemList.remove(x);
                    currentCapacity -= quantity;
                    updateAttachedList();
                    return true;
                }
            }
        }
        updateAttachedList();
        return false;
    }


    public boolean addItem(ItemStack stack) { // adds an item to the inventory
        if (currentCapacity + stack.getQuantity() <= capacity) {
            currentCapacity += stack.getQuantity();
            for (ItemStack is : itemList) {
                if (is.sameItem(stack)) {
                    is.changeQuantity(stack.getQuantity());
                    updateAttachedList();
                    return true;
                }
            }
            itemList.add(stack);
            updateAttachedList();
            return true;
        } else {
            updateAttachedList();
            return false;
        }
    }

    public void updateAttachedList() { // updates the corresponding UI list
        listModel.clear();
        for (ItemStack is : itemList) {
            listModel.addElement(is); // unoptimized?
        }
    }

    public JList getAttachedList() {
        return attachedList;
    }

    public Item getItem(int x) {
        return itemList.get(x).getItem();
    }

    public ItemStack getItemStack(int x) {
        return itemList.get(x);
    }

    public int getFreeSpaces() {
        return capacity - currentCapacity;
    }

    public boolean isFull() {
        return getFreeSpaces() <= 0;
    }

    public int getSelectedIndex() {
        return getAttachedList().getSelectedIndex();
    }

    public ItemDrug getSelectedDrug() {
        return (ItemDrug)getItem(getSelectedIndex());
    }

    public void updateButton() { // updates the sell button
        if (getSelectedIndex() != -1) {
            System.out.println(mainWindow.getMarket().checkIfDrugIsOffered(getSelectedDrug()));
            sellButton.setEnabled(mainWindow.getMarket().checkIfDrugIsOffered(getSelectedDrug()));
        } else {
            sellButton.setEnabled(false);
        }
    }

    public void clear() {
        itemList.clear();
    }
}
