package Klausur.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UIImpl implements UIInterface{

    BufferedReader reader;
    AddiererInterface adder;

    public UIImpl() {
        this.adder = new AddiererImpl();
        System.out.println("Gebe eine addition ein: ");
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String einlesen() {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            System.out.println("something went wrong with reading the input: " + e.getMessage());
        }
        return "";
    }

    @Override
    public int[] zerlegeStringZuInt() {
        String eingeleneString = this.einlesen();
        String[] eingelenerStringGesplitet = eingeleneString.split(" ");
        int summant1 = 0;
        int summant2 = 0;

        try {
            summant1 = Integer.parseInt(eingelenerStringGesplitet[1]);
            summant2 = Integer.parseInt(eingelenerStringGesplitet[2]);

        } catch (Exception e) {
            throw new IllegalArgumentException("Keine (integer) zahl im Input gefunden");
        }
        return new int[] {summant1, summant2};
    }

    @Override
    public String rufeAddiererAuf(){
        int[] summanten = zerlegeStringZuInt();
        try {
            return "Das Ergebnis ist: " + String.valueOf(adder.add(summanten[0], summanten[1]));
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
        

    }

    @Override
    public void displayErgebnis() {
        System.out.println(this.rufeAddiererAuf());
        
    }
    
}
