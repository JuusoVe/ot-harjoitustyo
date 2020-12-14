package beerratingapp.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juuso
 */
public class ReviewTest {
    
    
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
        rev2.setName("jouko");
        assertTrue(rev.equals(rev2));
        rev2.setName("kauha");
        assertTrue(rev == rev);
        assertFalse(rev.equals(rev2));
        
    }
    
    @Test
    public void settersWork() {
        Review rev = new Review();
        rev.setBrewery(";;;;brew;");
        rev.setStyle(";;;;sahti;");
        rev.setNotes(";;;;hope no comma;;;s here;");
        rev.setDate(";;;;January1;");
        rev.setIbu(40);
        rev.setAbv(4.2);
        rev.setOg(1.055);
        assertEquals("brew", rev.getBrewery());
        assertEquals("sahti", rev.getStyle());
        assertEquals("hope no commas here", rev.getNotes());
        assertTrue(4.2 == rev.getAbv());
        assertTrue(40 == rev.getIbu());
        assertTrue(1.055 == rev.getOg());
    }

}
