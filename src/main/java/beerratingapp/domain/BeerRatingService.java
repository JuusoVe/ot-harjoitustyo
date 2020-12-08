package beerratingapp.domain;
import beerratingapp.ui.FileFXMLLoader;
import java.util.ArrayList;
import beerratingapp.dao.*;
import beerratingapp.ui.MainSceneController;
import javafx.fxml.FXMLLoader;


public class BeerRatingService {

    private ReviewDao reviewDao;
    private AdvancedDao advancedDao;
    private FileFXMLLoader fileFXMLDao;
    
    public BeerRatingService(ReviewDao reviewDao, AdvancedDao advancedDao, FileFXMLLoader fileFXMLDao) {
        this.reviewDao = reviewDao;
        this.advancedDao = advancedDao;
        this.fileFXMLDao = fileFXMLDao;
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
    
    public Advanced getAdvancedFromFile(int reviewId) {
        return advancedDao.getByReviewId(reviewId);
    }
    
    public FXMLLoader getViewFromFile(String viewType) {
        return fileFXMLDao.loadViewFromFile(viewType);
    }
}
