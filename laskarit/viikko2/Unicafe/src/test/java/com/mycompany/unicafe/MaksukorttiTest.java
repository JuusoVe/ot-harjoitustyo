package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test public void saldoAlussaOikein() {
        assertEquals(1000,kortti.saldo());
    }
    
    @Test public void lataaminenKasvattaaOikein() {
        kortti.lataaRahaa(500);
        assertEquals(1500,kortti.saldo());
    }
    
    @Test public void saldoVaheneeJosRahaaTarpeeksi() {
        kortti.otaRahaa(500);
        assertEquals(500,kortti.saldo());
    }
    
    @Test public void saldoEiVaheneJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(1100);
        assertEquals(1000,kortti.saldo());
    }
    
    @Test public void palauttaaTrueJosRahaaTarpeeksi() {
        
        assertTrue(kortti.otaRahaa(500));
    }
    
    @Test public void palauttaaFalseJosRahaaEiTarpeeksi() {
        assertFalse(kortti.otaRahaa(1100));
    }
    
    @Test public void tulostusOikein() {
        assertEquals("saldo: 10.0",kortti.toString());
    }

    
}
