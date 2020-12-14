package beerratingapp.domain;
import beerratingapp.ui.FileFXMLLoader;
import java.util.ArrayList;
import beerratingapp.dao.*;
import beerratingapp.ui.MainSceneController;
import javafx.fxml.FXMLLoader;

/**
 *
 * Logic class handling communication between DAO and UI
 */
public class BeerRatingService {

    private ReviewDao reviewDao;
    private AdvancedDao advancedDao;
    private FileFXMLLoader fileFXMLLoader;
    
    public BeerRatingService(ReviewDao reviewDao, AdvancedDao advancedDao, FileFXMLLoader fileFXMLLoader) {
        this.reviewDao = reviewDao;
        this.advancedDao = advancedDao;
        this.fileFXMLLoader = fileFXMLLoader;
    }
    
 /**
 * Request ReviewDAO to save reviewsList
 * 
 * @param reviewsList list of reviews as an ArrayList to be saved
 */
    
    public void saveReviewsList(ArrayList<Review> reviewsList) {
        try {   
            reviewDao.saveReviewsList(reviewsList);
        } catch (Exception ex) {
            System.out.println("BeerRatingService failed to saveReviewsList. Error: ");
            System.out.println(ex.toString());
        }    
    }

 /**
 * Request DAO to save advanced
 * 
 * @param advanced object to be saved
 */
    
    public void saveAdvanced(Advanced advanced) {
        try {
            advancedDao.saveAdvanced(advanced);
        } catch (Exception e) {
            System.out.println("BeerRatingService failed to saveAdvanced. Error:");
            System.out.println(e.toString());
        }
    }

 /**
 * Request DAO to return Reviews from file as ArrayList
 * 
 * @return Reviews as an ArrayList of Revews
 */

    
    public ArrayList<Review> getReviewsFromFile() {
        return reviewDao.getAll();
    }
 /**
 * Request DAO to return advanced object by reviewId
 * 
 * @param reviewId for which to return advanced object
 * 
 * @return advanced object, new if no matching was found
 */    
    public Advanced getAdvancedFromFile(int reviewId) {
        return advancedDao.getByReviewId(reviewId);
    }
    
 /**
 * Request Loader class for FXMLLoader object by viewType
 * 
 * @param viewType type of the view to return
 * 
 * @return FXMLLoader object corresponding to the viewType requested
 */     
    
    public FXMLLoader getViewFromFile(String viewType) {
        return fileFXMLLoader.loadViewFromFile(viewType);
    }
}
