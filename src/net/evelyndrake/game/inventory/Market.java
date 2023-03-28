package net.evelyndrake.game.inventory;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Market extends Inventory {

    private JTextArea console;
    private JButton buyButton;
    private Inventory inventory;
    private ArrayList<ItemDrug> possibleDrugs;
    private MainWindow mainWindow;

    public Market(JList attachedList, JTextArea console, JButton buyButton, Inventory inventory, MainWindow mainWindow) {
        super(attachedList);
        this.console = console;
        this.buyButton = buyButton;
        this.inventory = inventory;
        possibleDrugs = new ArrayList<>();
        this.mainWindow = mainWindow;
    }

    public void refreshAndAddItem(ItemDrug item) {
        possibleDrugs.add(item);
    }

    public void restock() {
        console.setText("");
        possibleDrugs.clear();
        itemList = new ArrayList<>();
        refreshAndAddItem(Items.alcohol);
        refreshAndAddItem(Items.cocaine);
        refreshAndAddItem(Items.heroin);
        refreshAndAddItem(Items.weed);
        refreshAndAddItem(Items.meth);
        refreshAndAddItem(Items.lsd);
        refreshAndAddItem(Items.morphine);
        refreshAndAddItem(Items.oxycodone);
        refreshAndAddItem(Items.cocaine);
        refreshAndAddItem(Items.shrooms);
        refreshAndAddItem(Items.ketamine);
        refreshAndAddItem(Items.xanax);
        refreshAndAddItem(Items.ecstacy);
        refreshAndAddItem(Items.dxm);
        refreshAndAddItem(Items.yerbamate);
        refreshAndAddItem(Items.salvia);
        refreshAndAddItem(Items.pcp);
        refreshAndAddItem(Items.cb);
        refreshAndAddItem(Items.adderall);
        refreshAndAddItem(Items.percocet);
        refreshAndAddItem(Items.vicodin);
        refreshAndAddItem(Items.valium);
        refreshAndAddItem(Items.nitrous);
        refreshAndAddItem(Items.dmt);
        refreshAndAddItem(Items.melatonin);
        refreshAndAddItem(Items.spice);
        refreshAndAddItem(Items.ghb);
        refreshAndAddItem(Items.fentanyl);
        refreshAndAddItem(Items.bathsalts);
        refreshAndAddItem(Items.steroids);
        refreshAndAddItem(Items.mdma);
        addPossibleDrugs();
        updateAttachedList();
    }

    public void updateButton(int money) { // updates the buy button
        ItemDrug selectedItem = getSelectedDrug();
        if (money >= selectedItem.getCurrentPrice() && !inventory.isFull()) {
            buyButton.setEnabled(true);
        } else {
            buyButton.setEnabled(false);
        }
    }

    public void addPossibleDrugs() {
        Random rand = new Random();
        // int drugsToAdd = (int)(possibleDrugs.size()*(mainWindow.getCurrentLocation().getMarketPercentage()/100.0));
        for (ItemDrug possibleDrug : possibleDrugs) {
            currentCapacity = 0;
            if (rand.nextInt(100) <= mainWindow.getCurrentLocation().getMarketPercentage()) {
                String str = possibleDrug.getNewPrice();
                if (!str.equals("")) {
                    console.append(str + "\n");
                }
                addItem(new ItemStack(possibleDrug, 1, true));
            }
        }
    }

    public boolean checkIfDrugIsOffered(ItemDrug drug) {
        System.out.println("checking for " + drug.getRawName());
        for (ItemStack is : itemList) {
            if (is.getItem().getName().equals(drug.getName())) {
                return true;
            }
        }

        return false;
    }

}
