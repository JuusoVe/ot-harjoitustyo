package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import beerratingapp.domain.Advanced;

public class FileAdvancedDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    String file;
  
    AdvancedDao dao;
    
    
    @Before
    public void setUp() throws Exception {
        
        File advFile = testFolder.newFile("testfile_adv.txt");
        try (FileWriter file = new FileWriter(advFile.getAbsolutePath())) {
            file.write("32155321;testName;1,2,3,4,1,2,3,4;1,2,3,4,1,2,3,4;diibadaaba diiberi doobrei\n");
        }
        
        dao = new FileAdvancedDao(advFile.getAbsolutePath());        
    }
    
    @Test
    public void advancedObjectContentFromFileIsReadCorrectly() {
        
        Advanced adv = dao.getByReviewId(32155321);

        assertEquals(32155321, adv.getReviewId());
        assertEquals(1, adv.getHopScores()[0]);
        assertEquals(2, adv.getHopScores()[1]);
        assertEquals(3, adv.getHopScores()[2]);
        assertEquals(4, adv.getHopScores()[3]);
        assertEquals(1, adv.getHopScores()[4]);
        assertEquals(2, adv.getHopScores()[5]);
        assertEquals(3, adv.getHopScores()[6]);
        assertEquals(4, adv.getHopScores()[7]);
        assertEquals(1, adv.getMaltScores()[0]);
        assertEquals(2, adv.getMaltScores()[1]);
        assertEquals(3, adv.getMaltScores()[2]);
        assertEquals(4, adv.getMaltScores()[3]);
        assertEquals(1, adv.getMaltScores()[4]);
        assertEquals(2, adv.getMaltScores()[5]);
        assertEquals(3, adv.getMaltScores()[6]);
        assertEquals(4, adv.getMaltScores()[7]);
        assertEquals("diibadaaba diiberi doobrei", adv.getNotes());
    }
    
    @Test
    public void advancedObjectSaveToFile() {
        Advanced adv = new Advanced(12345);
        adv.setHopScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv.setMaltScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv.setNotes("aadadadadadadada");
        try {
            dao.saveAdvanced(adv);
        } catch (Exception e) {
            System.out.println("FileAdvancedDaoTest advancedObjectSaveToFile failed. Error: ");
            System.out.println(e.toString());
        }
        adv = dao.getByReviewId(12345);
        assertEquals(3, adv.getHopScores()[2]);
        assertEquals("aadadadadadadada", adv.getNotes());
    }

}
