package Klausur.tests;

import org.junit.Assert;
import org.junit.Test;

import Klausur.src.AddiererImpl;
import Klausur.src.AddiererInterface;

public class Tests {

    private AddiererInterface getAddierer() {
        return new AddiererImpl();
    }

    // ############ Guttests ############

    @Test
    public void AddierePositiveZahlenGuttest() {
        AddiererInterface addierer = this.getAddierer();
        int operant1 = 1;
        int operant2 = 2;
        int ergebnis = 0;
        try {
            ergebnis = addierer.add(operant1, operant2);
        } catch (Exception e) {
            Assert.fail("iwan schlechtes ist passiert: " + e.getMessage());
        }

        Assert.assertEquals(3, ergebnis);
    }


    // ############ Schlechttests ############  

    @Test
    public void AddiereNegativeZahlenSchlechttest() {
        AddiererInterface addierer = this.getAddierer();
        int operant1 = -1;
        int operant2 = -3;
        Exception e = Assert.assertThrows(Exception.class, () -> {
            addierer.add(operant1, operant2);
        });
        
        Assert.assertEquals("Negative Zahlen sind nicht erlaubt", e.getMessage());
    }

    @Test
    public void AddiereMaxIntSchlechttest() {
        AddiererInterface addierer = this.getAddierer();
        int operant1 = Integer.MAX_VALUE;
        int operant2 = 1;
        Exception e = Assert.assertThrows(Exception.class, () -> {
            addierer.add(operant1, operant2);
        });

        Assert.assertEquals("Es gab einen ueberlauf", e.getMessage());

    }

    // ############ Randtests ############
    
    @Test
    public void AddiereMaxIntRandtest() {
        AddiererInterface addierer = this.getAddierer();
        int operant1 = Integer.MAX_VALUE - 1;
        int operant2 = 1;
        int ergebnis = 0;
        try {
            ergebnis = addierer.add(operant1, operant2);
        } catch (Exception e) {
            Assert.fail("iwan schlechtes ist passiert: " + e.getMessage());
        }

        Assert.assertEquals(Integer.MAX_VALUE, ergebnis);
    }
}
