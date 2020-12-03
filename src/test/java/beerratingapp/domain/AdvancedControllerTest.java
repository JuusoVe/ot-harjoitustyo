/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beerratingapp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juuso
 */
public class AdvancedControllerTest {
    
    AdvancedController advCon;
    
    public AdvancedControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        advCon = new AdvancedController();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetCurrentAdvanced() {
        int[] hScores = new int[] {2, 3, 4, 5, 1, 2, 3, 2};
        int[] mScores = new int[] {2, 3, 1, 5, 1, 2, 3, 1};
        Advanced a = new Advanced("bName".hashCode(), "bName", hScores, mScores, "very tasty junit testing");
        
        
    }
    
}
