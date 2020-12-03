package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Review;

public interface ReviewDao {
    
    ArrayList<Review> getAll();
    
    void saveReviewsList(ArrayList<Review> reviewsList) throws Exception;
    
}
