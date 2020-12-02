package beerratingapp.domain;
import java.util.*;
import beerratingapp.dao.FileReviewDao;
import beerratingapp.dao.ReviewDao;
import beerratingapp.dao.AdvancedDao;
import beerratingapp.dao.FileAdvancedDao;


public class BeerRatingService {

    private ReviewDao reviewDao;
    private AdvancedDao advancedDao;
    
    public BeerRatingService(ReviewDao reviewDao, AdvancedDao advancedDao) {
        this.reviewDao = reviewDao;
        this.advancedDao = advancedDao;
    }
    
    public boolean createReview(String content) {
        Review review = new Review();
        try {   
            reviewDao.create(review);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public boolean saveReviewsList(ArrayList<Review> reviewsList) {
        try {   
            reviewDao.setReviewsList(reviewsList);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public ArrayList<Review> getAll() {
        return reviewDao.getAll();
    }
    
    public Advanced getAdvancedFromFile(String beerName) {
        return advancedDao.getByBeerName(beerName);
    }

    
    
    
    
    
}
