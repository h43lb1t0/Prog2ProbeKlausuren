package Klausur.src;

import java.io.IOException;

public interface UIInterface {
    
    /**
     * Liest ein, was der Benutzer eingibt
     * @return was der benutzer eingeben hat
     * @throws IOException wenn es proble beim Einlesen gab
     */
    String einlesen() throws IOException;

    /**
     * Zerlegt den String in integer
     * @return array mit den summanten
     * @throws IllegalArgumentException wenn keine Zahlen im String sind, oder die Zahl kein int ist
     */
    int[] zerlegeStringZuInt() throws IllegalArgumentException;

    /**
     * Ruft die Addierer Methode mit dem int Array auf
     * @return Das ergebnis als String
     */
    String rufeAddiererAuf() throws Exception;

    /**
     * Gibt das Ergebnis der berechnung im Terminal aus
     */
    void displayErgebnis();
}
