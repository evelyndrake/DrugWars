package net.evelyndrake.game;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import net.evelyndrake.game.dialogs.EndGameDialog;
import net.evelyndrake.game.dialogs.PoliceEventDialog;
import net.evelyndrake.game.dialogs.PurchaseDialog;
import net.evelyndrake.game.dialogs.SellDialog;
import net.evelyndrake.game.inventory.Inventory;
import net.evelyndrake.game.inventory.Market;
import net.evelyndrake.game.locations.LocationGeneric;
import net.evelyndrake.game.locations.Locations;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;

public class MainWindow {
    private JButton button1;
    private JPanel testView;
    private JList playerInventoryList;
    private JList marketList;
    private JTextArea console;
    private JButton buyButton;
    private JButton sellButton;
    private JLabel moneyLabel;
    private JLabel debtLabel;
    private JComboBox locationOptions;
    private JButton locationButton;
    private JLabel dayLabel;
    private JLabel healthLabel;
    private Inventory inventory;
    private Market market;
    private Locations locations;
    private int money = 2000;
    private int debt = 5000;
    private int health = 100;
    private final double DEBT_MULTIPLIER = 1.05;
    private int day = 1;
    private Random rand;

    public MainWindow() { // start game
        // create objects to hold game data
        inventory = new Inventory(playerInventoryList, sellButton, this);
        market = new Market(marketList, console, buyButton, inventory, this);
        locations = new Locations(locationOptions, this);
        locationButton.setVisible(true);
        locationButton.setText(locations.getLocation(0).getButtonText());
        market.restock();
        updateDebtLabel();
        changeMoney(0);
        changeHealth(0);
        rand = new Random();
        // add listeners to UI components
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                advanceDay();
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PurchaseDialog dialog = new PurchaseDialog(MainWindow.this);
                market.updateButton(money);
            }
        });
        marketList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                JList list = (JList)e.getSource();
                if (list.getSelectedIndex() != -1) {
                    market.updateButton(money);
                }
            }
        });
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellDialog dialog = new SellDialog(MainWindow.this);
            }
        });
        playerInventoryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                inventory.updateButton();
            }
        });
        locationOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                int index = box.getSelectedIndex();
                if (index != -1) {
                    LocationGeneric location = getCurrentLocation();
                    locationButton.setVisible(location.getHasButton());
                    locationButton.setText(location.getButtonText());
                }
                advanceDay();
            }
        });
        locationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    getCurrentLocation().buttonAction();
            }
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties theme = new Properties();
        theme.setProperty("controlTextFont", "Verdana bold 14");
        theme.setProperty("systemTextFont", "Verdana bold 14");
        theme.setProperty("userTextFont", "Verdana 14");
        theme.setProperty("menuTextFont", "Verdana bold 14");
        theme.setProperty("windowTitleFont", "Verdana bold 14");
        theme.setProperty("subTextFont", "Verdana 12");
        NoireLookAndFeel.setTheme(theme);
        UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        JFrame frame = new JFrame("NarcoticExchange");
        frame.setContentPane(new MainWindow().testView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Market getMarket() {
        return market;
    }

    public int getMoney() {
        return money;
    }

    public int getDebt() {
        return debt;
    }

    public void changeMoney(int x) {
        money += x;
        moneyLabel.setText("Money: $"+money);
    }

    public void changeDebt(int x) {
        debt += x;
        debtLabel.setText("Debt: $"+debt);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void updateDebtLabel() {
        debtLabel.setText("Debt: $"+debt);
    }

    public void advanceDay() { // advances game time to the next day
        day++;
        dayLabel.setText("Day: " + day);
        // increase debt
        debt *= DEBT_MULTIPLIER;
        updateDebtLabel();
        market.restock();
        inventory.updateButton();
        if (day >= 30) {
            EndGameDialog dialog = new EndGameDialog(this);
        }
        if (rand.nextInt(getCurrentLocation().getRisk()) == 0) {
            PoliceEventDialog policeEventDialog = new PoliceEventDialog(this);
        }
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int x) {
        health += x;
        if (health > 100) { // max health cap
            health = 100;
        } else if (health < 0) { // min health cap
            health = 0;
        }
        healthLabel.setText("Health: " + health);
    }

    public LocationGeneric getCurrentLocation() {
        int index = locationOptions.getSelectedIndex();
        if (index != -1) {
            return locations.getLocation(index);
        } else {
            return locations.getLocation(0);
        }
    }
}
