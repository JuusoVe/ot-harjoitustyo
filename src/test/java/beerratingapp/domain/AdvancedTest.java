package beerratingapp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdvancedTest {
    
    public AdvancedTest() {
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
    public void testConsructorOnlyName() {
        Advanced adv = new Advanced(12345);
        assertTrue(12345 == adv.getReviewId());
        assertEquals(8, adv.hopScores.length);
        assertEquals(8, adv.maltScores.length);
        assertEquals("", adv.getNotes());
    }
    
}
