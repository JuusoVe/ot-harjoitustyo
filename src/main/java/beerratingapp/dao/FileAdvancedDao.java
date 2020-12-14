package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import beerratingapp.domain.Advanced;
/**
 *
 * DAO class for reading from and writing to the file storing Advanced classes info permanently
 */
public class FileAdvancedDao implements AdvancedDao {
    
    public ArrayList<Advanced> advancedList;
    private String file;
    
 /**
 * Constructor that reads advanced-file into a ArrayList. Creates a fresh advanced-file if unable to read.
 *
 * @param   file   String to name the file to be read
 *
 * 
 */
    
    public FileAdvancedDao(String file) throws Exception {
        advancedList = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                String reviewName = parts[1];
                int[] hopScores = new int[8];
                String[] hopParts = parts[2].split(",");
                for (int i = 0; i < hopParts.length; i++) {
                    hopParts[i] = hopParts[i].trim(); 
                    hopScores[i] = Integer.parseInt(hopParts[i]);
                }
                int[] maltScores = new int[8];
                String[] maltParts = parts[3].split(",");
                for (int i = 0; i < maltParts.length; i++) {
                    maltParts[i] = maltParts[i].trim(); 
                    maltScores[i] = Integer.parseInt(maltParts[i]);
                }
                String notes = parts[4];
                Advanced advanced = new Advanced(id, reviewName, hopScores, maltScores, notes);
                advancedList.add(advanced);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Advanced advanced: advancedList) {
                writer.write(advanced.getReviewId() + ";" + advanced.getReviewName() + ";" + advanced.getHopScores()[0] + "," + advanced.getHopScores()[1] 
                         + "," + advanced.getHopScores()[2]  + "," + advanced.getHopScores()[3]  + "," + advanced.getHopScores()[4]  + "," + advanced.getHopScores()[5] 
                         + "," + advanced.getHopScores()[6]  + "," + advanced.getHopScores()[7]  + ";" + advanced.getMaltScores()[0]  + "," + advanced.getMaltScores()[1] 
                         + "," + advanced.getMaltScores()[2]  + "," + advanced.getMaltScores()[3]  + "," + advanced.getMaltScores()[4]  + "," + advanced.getMaltScores()[5] 
                         + "," + advanced.getMaltScores()[6]  + "," + advanced.getMaltScores()[7]  + "," + advanced.getNotes() + "\n");
            }
        }
    }    
 /**
 * Returns Advanced object by reviewId
 *
 * @param   reviewId id of the Review attached to the requested Advanced object
 *
 * @return Advanced object to return based on the id request. Return new instance of Advanced if not found by id. 
 */
    
    @Override
    public Advanced getByReviewId(int reviewId) {
        for (Advanced adv:this.advancedList) {
            if (adv.getReviewId() == reviewId) {
                return adv;
            }
        }
        return new Advanced(reviewId);
    }
    
 /**
 * Returns Advanced object by reviewId
 *
 * @param advanced Advanced object to save. Replaces old by id and saves as new if not found.
 *
 * @return advanced object saved 
 */    
    
    @Override
    public Advanced saveAdvanced(Advanced advanced) throws Exception {
        boolean asNew = true;
        for (int i = 0; i < advancedList.size(); i++) {
            if (advancedList.get(i).getReviewId() == advanced.getReviewId()) {
                advancedList.set(i, advanced);
                asNew = false;
            }
        }
        if (asNew) {
            advancedList.add(advanced);
        }
        save();
        return advanced;
    }

    
    
    

    
    
    
}
