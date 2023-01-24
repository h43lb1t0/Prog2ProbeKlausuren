package tests;

import org.junit.Test;

import org.junit.Assert;

import src.RechnerImpl;
import src.RechnerInterface;


public class Tests {

    private RechnerInterface getRechner() {
        return new RechnerImpl();
    }

    //RechnerInterface rechner = new RechnerImpl();
    
    // Gut tests
    @Test
    public void subtraktionGutTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = 2;
        int subrahend = 3;
        int ergebnis = 0;
        try {
            ergebnis = rechner.subtraktion(minuent, subrahend);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Assert.assertEquals(-1, ergebnis);
    }

    @Test
    public void subtraktionNegativeZahlenGutTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = -2;
        int subrahend = -3;
        int ergebnis = 0;
        try {
            ergebnis = rechner.subtraktion(minuent, subrahend);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Assert.assertEquals(1, ergebnis);
    }

    @Test
    public void subtraktionMitNullInizialisiertGutTest() {
        RechnerInterface rechner = this.getRechner();
        int subrahend = 1;
        int ergebnis = 0;
        try {
            ergebnis = rechner.subtraktion(subrahend);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Assert.assertEquals(-1, ergebnis);
    }

    @Test
    public void subtraktionMitGespeichertemErgebnisGutTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = 5;
        int subrahend = 1;
        int ergebnis = 0;
        try {
            rechner.subtraktion(minuent, subrahend);
            ergebnis = rechner.subtraktion(subrahend);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Assert.assertEquals(3, ergebnis);
    }

    //schlecht tests
    @Test
    public void subtraktionUeberlaufSchlechtTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = Integer.MAX_VALUE;
        int subrahend = -1;
        Exception e = Assert.assertThrows(Exception.class, () -> {
            rechner.subtraktion(minuent, subrahend);
        });

        Assert.assertEquals("ein ueberlauf ist passiert", e.getMessage());
    }

    @Test
    public void subtraktionUnterlaufSchlechtTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = Integer.MIN_VALUE;
        int subrahend = 1;
        Exception e = Assert.assertThrows(Exception.class, () -> {
            rechner.subtraktion(minuent, subrahend);
        });

        Assert.assertEquals("ein unterlauf ist passiert", e.getMessage());
    }

    @Test
    public void subtraktionMitGespeichertemErgebnisUndLaengerAls5SekSchlechtTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = 5;
        int subrahend = 1;
        try {
            rechner.subtraktion(minuent, subrahend);
            Thread.sleep(6000);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Exception e = Assert.assertThrows(Exception.class, () -> {
            rechner.subtraktion(minuent, subrahend);
        });

        Assert.assertEquals(e.getMessage(),"to slow");
    }

    //rand test
    @Test
    public void subtraktionMaxValueRandTest() {
        RechnerInterface rechner = this.getRechner();
        int minuent = Integer.MAX_VALUE - 1;
        int subrahend = -1;
        int ergebnis = 0;
        try {
            ergebnis = rechner.subtraktion(minuent, subrahend);
        } catch (Exception e) {
            Assert.fail("something bad happend");
        }

        Assert.assertEquals(Integer.MAX_VALUE, ergebnis);
    }
}
