package beerratingapp.domain;

import beerratingapp.dao.BeerRatingDao;
/**
 *
 * @author juuso
 */
public class ReviewService {
    private BeerRatingDao reviewDao;
           


    /**
    * Create a new empty Review
    *
    */
    
    public boolean createReview() {
        ReviewsList reviewslist = new ReviewsList();
        try {   
            reviewDao.create(reviewslist);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}


