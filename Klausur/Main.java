package Klausur;
import java.io.IOException;

import Klausur.src.UIImpl;
import Klausur.src.UIInterface;

public class Main {
    public static void main(String[] args) {
        UIInterface ui = new UIImpl();
        while(true) {
            try {
                ui.einlesen();
            } catch (IOException e) {
                System.out.println("probleme beim einlesen");
            }
        }
    }
}
