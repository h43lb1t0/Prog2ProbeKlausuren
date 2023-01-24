package src;

public interface RechnerInterface {

    /**
     * Subrahiert den minuenten vom Subrahenden und speichert das ergebnis
     * @param subrahend
     * @param minuent
     * @return das ergebnis der Berechnung
     * @throws IllegalStateException wenn der Rechner die Arbeit verweigert weil er laenger als 5 sek nichts getan hat.
     * @throws Exeption wenn ein unterlauf oder ueberlauf passiert
     */
    int subtraktion(int minuent, int subrahend) throws IllegalStateException, Exception;

    /**
     * Subrahiert den gespeicherten minuenten vom Subrahenden und speichert das ergebnis
     * @param subrahend
     * @return das ergebnis der Berechnung
     * @throws IllegalStateException wenn der Rechner die Arbeit verweigert weil er laenger als 5 sek nichts getan hat.
     * @throws Exeption wenn ein unterlauf oder ueberlauf passiert
     */
    int subtraktion(int subrahend) throws IllegalStateException, Exception;

}
