package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
        try (FileWriter file = new FileWriter(revFile.getAbsolutePath())) {
            file.write("12345;testName;testBrew;testSty;testDate;a made up highly elitist description;6.5;40;1.055;3, 4, 5, 3;3.0\n");
        }
        
        dao = new FileReviewDao(revFile.getAbsolutePath());        
    }
    
    @Test
    public void readFromFileToReviewListWorks() {
        ArrayList<Review> reviewslist = dao.getAll();
        assertEquals(1, reviewslist.size());
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
