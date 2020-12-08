package beerratingapp.domain;

import beerratingapp.dao.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import beerratingapp.domain.Review;
/**
 *
 * @author juuso
 */
public class FakeReviewDao implements ReviewDao {
    
    public ArrayList<Review> reviewsList;
    private String file;
    
    public FakeReviewDao(String file) throws Exception {
        reviewsList = new ArrayList<>();
        Review rev1 = new Review(12345,"pisuli", "olari", "popo" , "date here", "notes here", 7.2, 50, 1.044, new int[]{1, 2, 3, 4}, 0.0);
        Review rev2 = new Review(12324548,"pisulia", "olaria", "popopo" , "2nd date here", "notes here", 6.2, 40, 1.064, new int[]{4, 2, 1, 4}, 4.0);
        reviewsList.add(rev1);
        reviewsList.add(rev2);
        
    }
    
    private void save() throws Exception {

    }    

    
    @Override
    public ArrayList<Review> getAll() {
        return reviewsList;
    }
    

    @Override
    public void saveReviewsList(ArrayList<Review> reviewsList) throws Exception {
        this.reviewsList = reviewsList;
        save();
    }
    
    
    

    
    
    
}
