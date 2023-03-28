package net.evelyndrake.game.locations;

import net.evelyndrake.game.MainWindow;

import javax.swing.*;
import java.util.ArrayList;

public class Locations {

    private ArrayList<LocationGeneric> locationList;
    private DefaultComboBoxModel boxModel;
    private JComboBox attachedChoices;
    private MainWindow mainWindow;

    public Locations(JComboBox attachedChoices, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.attachedChoices = attachedChoices;
        boxModel = new DefaultComboBoxModel<>();
        locationList = new ArrayList<LocationGeneric>();
        addLocations();
        attachedChoices.setModel(boxModel);
        updateAttachedList();

    }

    public void addLocations() {
        locationList.add(new LocationLoan("Bronx (Loan Shark)", "Repay Loan", 50, true, mainWindow, 10));
        locationList.add(new LocationHospital("Central Park (Hospital)", "Heal", 10, true, mainWindow, 25));
        locationList.add(new LocationGeneric("Ghetto", "Test 3", 90, true, 4));
    }

    public LocationGeneric getLocation(int x) {
        return locationList.get(x);
    }

    public void updateAttachedList() {
        boxModel.removeAllElements();
        for (LocationGeneric location : locationList) {
            boxModel.addElement(location); // unoptimized?
        }
    }




}
