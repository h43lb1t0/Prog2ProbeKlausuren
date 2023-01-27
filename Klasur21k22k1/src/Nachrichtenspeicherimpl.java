package Klasur21k22k1.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Nachrichtenspeicherimpl implements NachrichtenspeicherInterface{

    private String[] NachrichtenSpeicherArray = new String[5];
    private int position = 0;
    private final String NachrichtenSpeicherdateiname = "NachrichtenSepicherPersitiert.txt";

    @Override
    public void speichern(String msg) {
        if (this.position > this.NachrichtenSpeicherArray.length -1) {
            this.position = 0;
        }
        if (msg.length() > 20) {
            throw new IllegalArgumentException("Die Nachrricht ist zu lang");
        }
        NachrichtenSpeicherArray[this.position] = msg;
        this.position++;
    }

    @Override
    public String lesen(int i) throws ArrayIndexOutOfBoundsException {
        return NachrichtenSpeicherArray[i];
    }

    @Override
    public void loescheAlles() {
        for (int i = 0; i < NachrichtenSpeicherArray.length; i++) {
            NachrichtenSpeicherArray[i] = null;
        }
    }

    @Override
    public void persist() throws IOException {
        System.out.println("persit wurde erreicht");
        boolean NachrichtImSpeicher = false;
        for (String nachricht : NachrichtenSpeicherArray) {
            if (nachricht != null) {
                NachrichtImSpeicher = true;
                break;
            }
        }

        if (!NachrichtImSpeicher) {
            throw new IllegalStateException("");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(NachrichtenSpeicherdateiname));
        for (String nachricht : NachrichtenSpeicherArray) {
            writer.write(nachricht+"\n");
            System.out.println(nachricht);
        }
        writer.close();
        
    }

    @Override
    public void reload() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(NachrichtenSpeicherdateiname));
            for (int i = 0; i < NachrichtenSpeicherArray.length; i++) {
                NachrichtenSpeicherArray[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            this.loescheAlles();
        }

        
    }

}
