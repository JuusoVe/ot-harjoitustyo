package beerratingapp.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;
import beerratingapp.dao.FileAdvancedDao;
import beerratingapp.dao.FileReviewDao;
import beerratingapp.dao.AdvancedDao;
import beerratingapp.dao.ReviewDao;
import java.util.ArrayList;
import beerratingapp.domain.Advanced;
import beerratingapp.domain.Review;
import beerratingapp.ui.FileFXMLLoader;
import java.io.File;
import java.io.FileWriter;

public class BeerRatingServiceTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    String file;
    
    BeerRatingService beRaSe;
    ReviewDao revDao;
    AdvancedDao advDao;
    
    ArrayList<Review> revList;
    Advanced adv;
    
    
    public BeerRatingServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        File revFile = testFolder.newFile("testfile_revs.txt");
        try (FileWriter revFileWriter = new FileWriter(revFile.getAbsolutePath())) {
            revFileWriter.write("12345;testName;testBrew;testSty;testDate;a made up highly elitist description;6.5;40;1.055;3, 4, 5, 3;3.0\n");
        }
        
        revDao = new FileReviewDao(revFile.getAbsolutePath()); 
        
        File advFile = testFolder.newFile("testfile_adv.txt");
        try (FileWriter advFileWriter = new FileWriter(advFile.getAbsolutePath())) {
            advFileWriter.write("12345;testName;1,2,3,4,1,2,3,4;1,2,3,4,1,2,3,4;diibadaaba diiberi doobrei\n");
        }
        
        advDao = new FileAdvancedDao(advFile.getAbsolutePath());
        
        beRaSe = new BeerRatingService(revDao, advDao, new FileFXMLLoader());
        
    }
    

    @Test
    public void getReviewsFromFile() {
        revList = beRaSe.getReviewsFromFile();
        assertEquals("testName",revList.get(0).getName());
        assertEquals(1,revList.size());
    }
    
    @Test
    public void getAdvancedFromFile() {
        adv = beRaSe.getAdvancedFromFile(12345);
        assertEquals("diibadaaba diiberi doobrei", adv.getNotes());
    }
    
    @Test
    public void addNewReviewAndSave() {
        revList = new ArrayList<>();
        Review newRev = new Review(66666,"pisuli", "olari", "popo" , "date here", "notes here", 7.2, 50, 1.044, new int[]{1, 2, 3, 4}, 0.0);
        Review newRev2 = new Review(11666,"pisauli", "oldari", "dpopo" , "date here", "nodtes heere", 4.2, 56, 1.064, new int[]{4, 1, 3, 4}, 3.0);
        revList.add(newRev);
        revList.add(newRev2);
        beRaSe.saveReviewsList(revList);
        revList = beRaSe.getReviewsFromFile();
        assertEquals(2, revList.size());
        assertEquals("pisuli", revList.get(0).getName());
    }
    
    @Test
    public void attachNewAdvancedToNewReview() {
        Advanced adv1 = new Advanced(12345);
        adv1.setHopScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv1.setMaltScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv1.setNotes("beeeaadadadadadadada");
        revList = beRaSe.getReviewsFromFile();
        
        beRaSe.saveAdvanced(adv1);
        
        adv = beRaSe.getAdvancedFromFile(revList.get(0).getId());
        
        assertEquals(12345, adv.getReviewId());
        assertEquals("beeeaadadadadadadada", adv.getNotes());
        
        
        
    }
    
    
    
}
