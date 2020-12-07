package beerratingapp;


import beerratingapp.ui.MainSceneController;
import beerratingapp.dao.FileAdvancedDao;
import beerratingapp.dao.FileReviewDao;
import org.junit.Test;
import org.junit.Assert;
import java.util.*;
import beerratingapp.ui.ReviewController;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.domain.Review;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import beerratingapp.domain.FakeReviewDao;
import beerratingapp.domain.FakeAdvancedDao;
/**
 *
 * @author juuso
 */
public class MainSceneControllerTest extends ApplicationTest{
    
    ReviewController testRevCon; 
    MainSceneController mainSceCon;
    ArrayList<Review> revList;
    BeerRatingService beRaSe;
    
    
    public MainSceneControllerTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainSceneLoader = new FXMLLoader();
        mainSceneLoader.setLocation(getClass().getResource("/main.fxml"));
        Parent testMainPane = mainSceneLoader.load();
        stage.setScene(new Scene(testMainPane));
        mainSceCon = mainSceneLoader.getController();
        stage.show();
        
        String reviewsFile = "reviewsTest.txt";
        String advancedFile = "advancedTest.txt";
        beRaSe = new BeerRatingService(new FakeReviewDao("we"), new FakeAdvancedDao("wee"));
        
        revList = new ArrayList<>();
        Review rev1 = new Review("pisuli", "olari", "popo" , "date here", "notes here", 7.2, 50, 1.044, new int[]{1, 2, 3, 4}, 0.0);
        Review rev2 = new Review("pisulia", "olaria", "popopo" , "2nd date here", "notes here", 6.2, 40, 1.064, new int[]{4, 2, 1, 4}, 4.0);
        revList.add(rev1);
        revList.add(rev2);
        
        beRaSe.saveReviewsList(revList);
        mainSceCon.getReviewsFromService();
    }

    
}
