package beerratingapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import beerratingapp.domain.Advanced;
/**
 *
 * @author juuso
 */
public class FileAdvancedDao implements AdvancedDao {
    
    public ArrayList<Advanced> advancedList;
    private String file;
    
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
                writer.write(advanced.getId() + ";" + advanced.getReviewName() + ";" + advanced.getHopScores()[0] + ";" + advanced.getHopScores()[1] 
                         + ";" + advanced.getHopScores()[2]  + ";" + advanced.getHopScores()[3]  + ";" + advanced.getHopScores()[4]  + ";" + advanced.getHopScores()[5] 
                         + ";" + advanced.getHopScores()[6]  + ";" + advanced.getHopScores()[7]  + ";" + advanced.getMaltScores()[0]  + ";" + advanced.getMaltScores()[1] 
                         + ";" + advanced.getMaltScores()[2]  + ";" + advanced.getMaltScores()[3]  + ";" + advanced.getMaltScores()[4]  + ";" + advanced.getMaltScores()[5] 
                         + ";" + advanced.getMaltScores()[6]  + ";" + advanced.getMaltScores()[7]  + ";" + advanced.getNotes() + "\n");
            }
        }
    }    

    
    @Override
    public Advanced getByBeerName(String name) {
        for (Advanced adv:this.advancedList) {
            if (adv.getReviewName().equals(name)) {
                return adv;
            }
        }
        return new Advanced(name);
    }
    
    @Override
    public Advanced create(Advanced advanced) throws Exception {
        advancedList.add(advanced);
        save();
        return advanced;
    }

    @Override
    public void setAdvancedList(ArrayList<Advanced> advancedList) throws Exception {
        this.advancedList = advancedList;
        save();
    }
    
    
    

    
    
    
}
