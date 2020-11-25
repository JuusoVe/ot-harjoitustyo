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
public class ReviewTest {
    
    public ReviewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void setPartScoresForcesMinAndMax() {
        Review rev = new Review();
        int[] mmTest = {1,-2,11,4};
        rev.setPartScores(mmTest);
        assertTrue(0 == rev.getPartScores()[1]);
        assertTrue(5 == rev.getPartScores()[2]);
    }
    
    @Test
    public void updateAverageBetweenZeroFive() {
        Review rev = new Review();
        int[] five = {5,5,5,5};
        rev.setPartScores(five);
        rev.updateAverage();
        assertTrue(0.0 <= rev.getAverage());
        assertTrue(5.0 >= rev.getAverage());   
    }
    
    @Test
    public void weighingWorks() {
        Review rev = new Review();
        int[] four = {3,3,5,3};
        rev.setPartScores(four);
        rev.updateAverage();
        assertTrue(4.0 == rev.getAverage());
        int[] three = {4,4,2,4};
        rev.setPartScores(three);
        rev.updateAverage();
        assertTrue(3.0 == rev.getAverage());
        int[] two = {0,2,2,0};
        rev.setPartScores(two);
        rev.updateAverage();
        assertTrue(2.0 == rev.getAverage());   
    }
    
    @Test
    public void equalsWorks() {
        Review rev = new Review();
        Review rev2 = new Review();
        rev.setName("jouko");
        rev.setId(12345);
        rev2.setName("jouko");
        rev2.setId(12345);
        assertTrue(rev.equals(rev2));
        rev2.setId(1234);
        assertFalse(rev.equals(rev2));
        rev2.setId(12345);
        rev2.setName("kauha");
        assertTrue(rev == rev);
        assertFalse(rev.equals(rev2));
        
    }
    
    
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
