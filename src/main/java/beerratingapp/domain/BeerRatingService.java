package beerratingapp.domain;
import java.util.*;
import beerratingapp.dao.FileReviewDao;
import beerratingapp.dao.ReviewDao;


public class BeerRatingService {

    private ReviewDao reviewDao;
    
    public BeerRatingService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
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
            reviewDao.setReviewsList(reviewsList);;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public ArrayList<Review> getAll() {
        return reviewDao.getAll();
    }
    
    
    
    
    
}
