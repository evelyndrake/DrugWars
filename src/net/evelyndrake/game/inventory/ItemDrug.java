package net.evelyndrake.game.inventory;

import java.util.Random;

public class ItemDrug extends Item {

    private int minPrice, maxPrice, currentPrice, oldPrice;
    private String cheapString, expensiveString;
    private boolean specialEvent;
    private final int EVENT_CHANCE = 30;

    public ItemDrug(String name, int minPrice, int maxPrice, String cheapString, String expensiveString) {
        super(name);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.cheapString = cheapString;
        this.expensiveString = expensiveString;
        this.currentPrice = (minPrice + maxPrice) / 2;
        oldPrice = 0;
    }

    public ItemDrug(String name, int minPrice, int maxPrice) {
        super(name);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.cheapString = "The market is flooded with homemade " + name + "!";
        this.expensiveString = "Addicts are buying " +name + " at ridiculous prices!";
        oldPrice = 0;
    }

    public String getNewPrice() {
        oldPrice = currentPrice;
        Random rand = new Random();
        int price = rand.nextInt(maxPrice-minPrice)+minPrice;
        if (rand.nextInt(EVENT_CHANCE) == 0) {
            currentPrice = price / 4;
            if (currentPrice <= 0) {
                currentPrice = 1;
            }
            specialEvent = true;
            return cheapString;
        } else if (rand.nextInt(EVENT_CHANCE) == 0) {
            currentPrice = price * 4;
            specialEvent = true;
            return expensiveString;

        } else {
            currentPrice = price;
            specialEvent = false;
            return "";
        }
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public String getRawName() {
        return super.getName();
    }

    @Override
    public String getName() {
        String character = "";
        if (currentPrice > oldPrice) {
            character = "<font size=6 color=green>↑";
        } else if (oldPrice > currentPrice) {
            character = "<font size=6 color='red'>↓";
        } else {
            character = "";
        }
        if (specialEvent) {
            character += "★";
        }
        return "<html>"+super.getName() + " ($" + currentPrice+") <b>" + character+"</b></font></html>";
    }
}
