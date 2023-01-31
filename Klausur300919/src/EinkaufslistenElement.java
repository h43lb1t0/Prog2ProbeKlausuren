package Klausur300919.src;

public class EinkaufslistenElement {
    private String itemName;
    private int preis;

    public EinkaufslistenElement(String itemName, int preis) {
        this.itemName = itemName;
        this.preis = preis;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getPreis() {
        return this.preis;
    }

    @Override
    public String toString() {
        return this.itemName + " " + preis  + "\n";
    }
}
