package Klasur21k22k1.src;

import java.io.IOException;

public interface NachrichtenspeicherInterface {

    /**
     * Speichert die Nachrricht in ein Array
     * @param msg the nachrricht zu speichern
     */
    void speichern(String msg) throws IllegalArgumentException;

    String lesen(int i) throws ArrayIndexOutOfBoundsException;

    /**
     * Loescht alle elemente im NachrichtenSpeicher
     */
    void loescheAlles();

    /**
     * Schreibt den Nachrichtensepicher in eine Datei
     * @throws IOException wenn es probleme beim schreiben der Datei gibt
     * @throws IllegalStateException wenn noch keine nachricht im NachrichtenSpeicher ist
     */
    void persist() throws IOException, IllegalStateException;

    /**
     * Laed den inhalt einer Datei in den Nachrichtensepicher.
     * ist die Datei leer so wird der Nachrichtenspeicher geloescht.
     * @throws IOException wenn es probleme beim lesen der Datei gibt.
     */
    void reload() throws IOException;

}
