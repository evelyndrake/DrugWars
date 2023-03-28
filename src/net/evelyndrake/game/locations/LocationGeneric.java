package net.evelyndrake.game.locations;

public class LocationGeneric {

    private String name, buttonText;
    private int marketPercentage;
    private boolean hasButton;
    private int risk;


    public LocationGeneric(String name, String buttonText, int marketPercentage, boolean hasButton, int risk) {
        this.name = name;
        this.buttonText = buttonText;
        this.marketPercentage = marketPercentage;
        this.hasButton = hasButton;
        this.risk = risk;
    }

    public void buttonAction() {

    }

    public String getButtonText() {
        return buttonText;
    }

    public int getMarketPercentage() {
        return marketPercentage;
    }

    public String getName() {
        return name;
    }

    public int getRisk() {
        return risk;
    }

    public boolean getHasButton() {
        return hasButton;
    }

    public String toString() {
        return getName();
    }
}
