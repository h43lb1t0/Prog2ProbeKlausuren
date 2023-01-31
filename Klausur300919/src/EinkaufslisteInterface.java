package Klausur300919.src;

import java.io.IOException;

public interface EinkaufslisteInterface {

    /**
     * Fuegt ein item und dessen Preis zu der Einkaufsliste hinzu
     * @param items das Item das hinzugefuegt werden soll
     * @throws IllegalStateException wenn das item schon der der liste steht
     */
    void add(String items, boolean kommtVonReload) throws IllegalStateException, IllegalArgumentException;

    String[] splitInput(String input);

    int convertStringpriceToInt(String preis) throws Exception;

    /**
     * Gibt die Einkaufsliste zurueck
     * @return die Einkaufsliste als String
     * @throws IllegalStateException wenn die EinkaufsListe leer ist
     */
    String print() throws IllegalStateException;

    /**
     * Loescht ein Item aus der Liste, gibt es dieses nichts passiert nichts
     * @param item das zu loeschende item
     */
    void remove(String item);

    /**
     * Speichert die Einkaufsliste in einer Datei
     * @throws IOException wenn es probleme beim schreiben der Datei gab
     */
    void save() throws IOException;

    /**
     * laed die Einkaufsliste aus einer datei
     * @throws IOException wenn es probleme beim Laden der Datei gab
     */
    void reload() throws IOException;


}
