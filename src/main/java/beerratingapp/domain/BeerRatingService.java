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
    
    public boolean saveReviewsList(ArrayList<Review> reviewsList) {
        try {   
            reviewDao.saveReviewsList(reviewsList);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public void saveAdvanced(Advanced advanced) {
        try {
            advancedDao.saveAdvanced(advanced);
        } catch (Exception e) {
            System.out.println("BeerRatingService failed to saveAdvanced. Error:");
            System.out.println(e.toString());
        }
    }
    
    public ArrayList<Review> getAll() {
        return reviewDao.getAll();
    }
    
    public Advanced getAdvancedFromFile(String beerName) {
        return advancedDao.getByBeerName(beerName);
    }

    
    
    
    
    
}
