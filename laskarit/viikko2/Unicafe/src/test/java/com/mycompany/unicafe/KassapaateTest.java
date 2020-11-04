/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juuso
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test public void rahaaAlussaTonni() {
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test public void eiMyytyjaMaukkaitaAlussa() {
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test public void eiMyytyjaEdullisiaAlussa() {
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
    }
    
    @Test public void rahaMeneeKassaanJaVaihtoRahaOikein() {
        assertEquals(100,kassa.syoMaukkaasti(500));
        assertEquals(100000+400,kassa.kassassaRahaa());
    }
    
     @Test public void syodytEdullisetKasvaaKunMaksuRiittava() {
         kassa.syoEdullisesti(500);
         assertEquals(1,kassa.edullisiaLounaitaMyyty());
     }
     
     @Test public void syodytMaukkaatKasvaaKunMaksuRiittava() {
         kassa.syoMaukkaasti(500);
         assertEquals(1,kassa.maukkaitaLounaitaMyyty());
     }
     
     @Test public void maksuEiRiittavaKassaEiMuutuRahatPalautetaanEiMyytyjaEdullinen() {
         assertEquals(50,kassa.syoEdullisesti(50));
         assertEquals(100000,kassa.kassassaRahaa());
         assertEquals(0,kassa.edullisiaLounaitaMyyty());
     }
     
     @Test public void maksuEiRiittavaKassaEiMuutuRahatPalautetaanEiMyytyjaMaukas() {
         assertEquals(50,kassa.syoMaukkaasti(50));
         assertEquals(100000,kassa.kassassaRahaa());
         assertEquals(0,kassa.maukkaitaLounaitaMyyty());
     }
     
     @Test public void josKortillaTarpeeksiRahaaVeloitetaanSummaJaPalautetaanTrueEdullinen() {
         assertTrue(kassa.syoEdullisesti(kortti));
         assertEquals(1000-240, kortti.saldo());
     }
     
     @Test public void josKortillaTarpeeksiRahaaVeloitetaanSummaJaPalautetaanTrueMaukas() {
         assertTrue(kassa.syoMaukkaasti(kortti));
         assertEquals(1000-400, kortti.saldo());
     }
     
     @Test public void josKortillaTarpeeksiRahaaMyydytKasvaaMaukas() {
         assertTrue(kassa.syoMaukkaasti(kortti));
         assertEquals(1, kassa.maukkaitaLounaitaMyyty());
     }
     
     @Test public void josKortillaTarpeeksiRahaaMyydytKasvaaEdullinen() {
         assertTrue(kassa.syoEdullisesti(kortti));
         assertEquals(1, kassa.edullisiaLounaitaMyyty());
     }
     
     @Test public void josEiRahaaKortinSaldoEiMuutuMyydytEiMuutuPalautetaanFalseMaukas() {
         kortti.otaRahaa(900);
         assertFalse(kassa.syoMaukkaasti(kortti));
         assertEquals(0,kassa.maukkaitaLounaitaMyyty());
     }
     
     @Test public void josEiRahaaKortinSaldoEiMuutuMyydytEiMuutuPalautetaanFalseEdullinen() {
         kortti.otaRahaa(900);
         assertFalse(kassa.syoEdullisesti(kortti));
         assertEquals(0,kassa.edullisiaLounaitaMyyty());
     }
     
     @Test public void kassanRahamaaraEiMuutuKortillaOstettaessa() {
         assertTrue(kassa.syoEdullisesti(kortti));
         assertTrue(kassa.syoMaukkaasti(kortti));
         assertEquals(100000,kassa.kassassaRahaa());
     }
     
     @Test public void ladattaessaKorttiaSaldoMuuttuujaKassaMuuttuu() {
         kassa.lataaRahaaKortille(kortti, 500);
         assertEquals(1500,kortti.saldo());
         assertEquals(100000+500,kassa.kassassaRahaa());
     }
     
     @Test public void eiVoiLadataNegatiivistaSummaa() {
         kassa.lataaRahaaKortille(kortti, -500);
         assertEquals(1000,kortti.saldo());
         assertEquals(100000,kassa.kassassaRahaa());
     }
    
    
    

    
    
}
