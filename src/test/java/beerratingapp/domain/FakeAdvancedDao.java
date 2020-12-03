package beerratingapp.domain;

import beerratingapp.dao.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import beerratingapp.domain.Advanced;
/**
 *
 * @author juuso
 */
public class FakeAdvancedDao implements AdvancedDao {
    
    public ArrayList<Advanced> advancedList;
    private String file;
    
    public FakeAdvancedDao(String file) throws Exception {
        advancedList = new ArrayList<>();
        
        Advanced adv1 = new Advanced("testName");
        adv1.setHopScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv1.setMaltScores(new int[]{1, 2, 3, 4, 1, 2, 3, 4});
        adv1.setNotes("beeeaadadadadadadada");
        
        Advanced adv2 = new Advanced("testBeer");
        adv2.setHopScores(new int[]{1, 2, 3, 4, 3, 2, 3, 4});
        adv2.setMaltScores(new int[]{4, 2, 3, 4, 1, 1, 3, 4});
        adv2.setNotes("aadadaefaefafeadadadadada");
        
        advancedList.add(adv1);
        advancedList.add(adv2);   
    }
    
    private void save() throws Exception {
       
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
    public Advanced saveAdvanced(Advanced advanced) throws Exception {
        boolean asNew = true;
        for (int i = 0; i < advancedList.size(); i++) {
            if (advancedList.get(i).getId() == advanced.getId()) {
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
