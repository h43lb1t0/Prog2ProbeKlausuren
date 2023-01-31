package Klausur300919.tests;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import Klausur300919.src.EinkaufslisteImpl;
import Klausur300919.src.EinkaufslisteInterface;



public class Tests {

    private EinkaufslisteInterface getEinkaufsliste() {
        return new EinkaufslisteImpl();
    }

    //################## Guttests ##################

    @Test
    public void addItemAndPrintGutTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        String item = "Apfel 1";
        String ausgabe = "";
        try {
            liste.add(item, false);
            ausgabe = liste.print();
        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }
        Assert.assertEquals(item+"\n", ausgabe);
    }

    @Test
    public void removeItemGutTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        String item = "Apfel 1";
        String ausgabe = "";
        try {
            liste.add(item, false);
            liste.remove(item);
            ausgabe = liste.print();
        } catch (Exception e) {
            if (!e.getMessage().equals("Es steht noch nichts auf der Liste")) {
                Assert.fail("something went wrong: " + e.getMessage());
            }
        }
        Assert.assertEquals(item, ausgabe.trim());
    }

    @Test
    public void SaveEinkaufslisteUndLadeGutTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        String item = "Apfel 1";
        String ausgabe = "";
        File f = new File("Einkaufsliste.txt");
        f.delete();
        
        try {
            liste.add(item, false);
            liste.remove("Apfel");
            liste.reload();
            ausgabe = liste.print();
        } catch (Exception e) {
            Assert.fail("something went wrong: " + e.getMessage());
        }
        Assert.assertEquals(item, ausgabe.trim());
    }

    @Test
    public void removeNoneItemGutTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        String item = "Apfel 1";
        try {
            liste.remove(item);
            liste.print();
        } catch (Exception e) {
            if (!e.getMessage().equals("Es steht noch nichts auf der Liste")) {
                Assert.fail("something went wrong: " + e.getMessage());
            }
        }
    }

    //################## Schlechttests ##################

    @Test
    public void add2ItemsAndPrintSchlechtTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        String item = "Apfel 1";
        Exception e = Assert.assertThrows(IllegalStateException.class, () -> {
            liste.add(item, false);
            liste.add(item, false);
        });
        Assert.assertEquals("Exception: doppelte Eingabe", e.getMessage());
    }

    @Test
    public void printLeereListeSchlechtTest() {
        EinkaufslisteInterface liste = this.getEinkaufsliste();
        Exception e = Assert.assertThrows(IllegalStateException.class, () -> {
            liste.print();
        });
        Assert.assertEquals("Es steht noch nichts auf der Liste", e.getMessage());
    }

}
