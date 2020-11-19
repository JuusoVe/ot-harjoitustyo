package beerratingapp.dao;

import java.util.List;
import beerratingapp.domain.ReviewsList;
import beerratingapp.domain.Review;

public interface BeerRatingDao {
    
    Review create(Review review) throws Exception;
    
    List<Review> getAll();
    
}
