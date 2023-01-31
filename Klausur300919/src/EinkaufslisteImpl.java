package Klausur300919.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EinkaufslisteImpl implements EinkaufslisteInterface{

    private ArrayList<EinkaufslistenElement> list = new ArrayList<EinkaufslistenElement>();
    private final String DATEINAME = "Einkaufsliste.txt";

    public static void main(String[] args) {
        EinkaufslisteInterface kaufen = new EinkaufslisteImpl();
        kaufen.add("Wurst 5", false);
        kaufen.add("foo 1", false);
        kaufen.remove("Wurst");
        kaufen.remove("foo");

        try {
            kaufen.reload();
        } catch (Exception e) {
            System.out.println("in catch block");
            System.out.println(e.getMessage());
        }
        

        kaufen.print();
    }

    @Override
    public void add(String items, boolean kommtVonReload) {
        if (items.equals("") || items.equals(null) || items.equals("\n")) {
            throw new IllegalArgumentException("items must not be null or empty");
        }
        String[] inputs = this.splitInput(items);

        for (EinkaufslistenElement element : list) {
            if (element.getItemName().equals(inputs[0])) {
                throw new IllegalStateException("Exception: doppelte Eingabe");
            }
        }
        list.add(new EinkaufslistenElement(inputs[0], convertStringpriceToInt(inputs[1])));
        if (!kommtVonReload) {
            try {
                this.save();
            } catch (Exception e) {
                System.out.println("could not save the list to a file: " + e.getMessage());
            }
        }
    }


    @Override
    public String[] splitInput(String input) {
        return input.split(" ");
    }

    @Override
    public int convertStringpriceToInt(String preis){
        try {
            return Integer.parseInt(preis);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("kein preis wurde angeben");
        }
    }

    @Override
    public String print() throws IllegalStateException {
        String ausgabe = "";
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Es steht noch nichts auf der Liste");
        }
        for (EinkaufslistenElement element : list) {
            ausgabe += element.toString();
        }
        System.out.println(ausgabe);
        return ausgabe;
    }

    @Override
    public void remove(String item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemName().equals(item)) {
                list.remove(i);
                break;
            }
        }
    }

    @Override
    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(DATEINAME));
        for (EinkaufslistenElement element : list) {
            writer.write(element.toString());
        }
        writer.close();
        
    }

    @Override
    public void reload() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DATEINAME));
        while(true) {
            String read = reader.readLine();
            if (read == null) {
                break;
            } else {
                this.add(read, false);
            }
        }
        reader.close();
    }
}
