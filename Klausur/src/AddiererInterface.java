package Klausur.src;

public interface AddiererInterface {

    /**
     * Addiert zwei nicht negative, ganze Zahlen
     * @param operant1 summant1
     * @param operant2 summant2
     * @return das ergebnis der berechnung
     * @throws IllegalArgumentException einer oder beide der summaten getativ ist
     * @throws Exception wenn es einen ueberlauf gibt
     */
    int add(int operant1, int operant2) throws IllegalArgumentException, Exception;

}
