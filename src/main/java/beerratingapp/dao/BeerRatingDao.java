package beerratingapp.dao;

import java.util.ArrayList;
import beerratingapp.domain.Review;

public interface BeerRatingDao {
    
    Review create(Review review) throws Exception;
    
    ArrayList<Review> getAll();
    
}
