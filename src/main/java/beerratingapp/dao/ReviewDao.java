package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Review;

public interface ReviewDao {
    
    Review create(Review review) throws Exception;
    
    ArrayList<Review> getAll();
    
    void setReviewsList(ArrayList<Review> reviewsList) throws Exception;
    
}
