package Klasur21k22k1.tests;

import java.io.File;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.junit.Assert;
import org.junit.Test;

import Klasur21k22k1.src.NachrichtenspeicherInterface;
import Klasur21k22k1.src.Nachrichtenspeicherimpl;

public class Tests {

    private static final int SPEICHERLAENGE = 5;

    private NachrichtenspeicherInterface getNachtrichtenSpeicher() {
        return new Nachrichtenspeicherimpl();
    }

    // --------------------Guttests--------------------------------------------

    @Test
    public void testNachrichtenspeicherAusUndEingabeGutTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        String msg = "Hello world!";
        String geleseneMsg = null;

        try {
            speicher.speichern(msg);
            geleseneMsg = speicher.lesen(0);
        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }

        Assert.assertEquals(msg, geleseneMsg);
    }

    @Test
    public void testNachrichtAlleLoeschenGutTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        

        String msg = "Hello world!";

        try {
            for (int i = 0; i < SPEICHERLAENGE; i++) {
                speicher.speichern(msg);
            };

            speicher.loescheAlles();

            for (int i = 0; i < SPEICHERLAENGE; i++) {
                Assert.assertEquals(null, speicher.lesen(i));
            };
        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }
    }

    @Test
    public void testNachrichtUeberschreibenGutTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();


        String msg1 = "Hello world!";
        String msg2 = "jetzt index 0";

        try {
            for (int i = 0; i < SPEICHERLAENGE; i++) {
                speicher.speichern(msg1);
            };

            speicher.speichern(msg2);

            Assert.assertEquals(msg2, speicher.lesen(0));

        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }
    }

    @Test
    public void testNachrichtenspeicherInFileGutTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        String msg = "Hello world";
        String msg2 = null;
        try {
            File f = new File("NachrichtenSepicherPersitiert.txt");
            f.delete();
            speicher.speichern(msg);
            speicher.persist();
            speicher.loescheAlles();
            speicher.reload();
            msg2 = speicher.lesen(0);
        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }

        Assert.assertEquals(msg, msg2);
    }

    // --------------------Schlechttests--------------------------------------------

    @Test
    public void testNachrrichtlaengerAls20ZeichenSchlechtTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        String msg = "1234567890123456789012345_28";

        Exception e = Assert.assertThrows(Exception.class, () -> {
            speicher.speichern(msg);
        });

        Assert.assertEquals("Die Nachrricht ist zu lang", e.getMessage());
    }

    @Test
    public void testNichtVorhandeneNachrrichtAuslesehenSchlechtTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        Assert.assertThrows(Exception.class, () -> {
            speicher.lesen(8);
        });
    }

    @Test
    public void testNachrichtenspeicherInFileOhneInhaltSchlechtTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        Assert.assertThrows(Exception.class, () -> {
            speicher.persist();
        }); 
            
    }

    // --------------------Randtests--------------------------------------------

    @Test
    public void testNachrrichtFuenfRandTest() {
        NachrichtenspeicherInterface speicher = this.getNachtrichtenSpeicher();

        String msg = "Hello world!";

        try {
            for (int i = 0; i < SPEICHERLAENGE; i++) {
                speicher.speichern(msg + i);
            };

            Assert.assertEquals(msg+(SPEICHERLAENGE-1), speicher.lesen(4));
        } catch (Exception e) {
            Assert.fail("something went wrong" + e.getMessage());
        }
    }
}