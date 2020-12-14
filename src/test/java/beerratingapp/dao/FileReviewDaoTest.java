package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import beerratingapp.domain.Review;

/**
 *
 * @author juuso
 */
public class FileReviewDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    String file;
  
    ReviewDao dao;
    
    
    @Before
    public void setUp() throws Exception {
        
        File revFile = testFolder.newFile("testfile_revs.txt");
        try (FileWriter fileWriter = new FileWriter(revFile.getAbsolutePath())) {
            fileWriter.write("12345;testName;testBrew;testSty;testDate;a made up highly elitist description;6.5;40;1.055;3, 4, 5, 3;3.0\n");
        }
        
        dao = new FileReviewDao(revFile.getAbsolutePath());        
    }
    
    @Test
    public void readFromFileToReviewListWorks() {
        ArrayList<Review> reviewslist = dao.getAll();
        assertEquals(1, reviewslist.size());
    }
    
    @Test
    public void saveWorks() {
        ArrayList<Review> reviewslist = dao.getAll();
        assertEquals(1, reviewslist.size());
        ArrayList<Review> reviewslist2 = new ArrayList<>();
        Review rev1 = new Review(12345,"pisuli", "olari", "popo" , "date here", "notes here", 7.2, 50, 1.044, new int[]{1, 2, 3, 4}, 0.0);
        Review rev2 = new Review(12324548,"pisulia", "olaria", "popopo" , "2nd date here", "notes here", 6.2, 40, 1.064, new int[]{4, 2, 1, 4}, 4.0);
        reviewslist2.add(rev2);
        reviewslist2.add(rev1);
        try {
            dao.saveReviewsList(reviewslist2);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        ArrayList<Review> reviewslist3 = dao.getAll();
        assertEquals(2, reviewslist3.size());
    }
    
    
    @Test
    public void reviewObjectContentFromListIsReadCorrectly() {
        ArrayList<Review> reviewslist = dao.getAll();
        Review review = reviewslist.get(0);
        assertEquals("testName", review.getName());
        assertEquals("testBrew", review.getBrewery());
        assertEquals("testSty", review.getStyle());
        assertEquals("testDate", review.getDate());
        assertEquals("a made up highly elitist description", review.getNotes());
        assertTrue(6.5 == review.getAbv());
        assertTrue(40 == review.getIbu());
        assertTrue(1.055 == review.getOg());
        assertTrue(4 == review.getPartScores().length);
        assertTrue(3.0 == review.getAverage());
    }

}
