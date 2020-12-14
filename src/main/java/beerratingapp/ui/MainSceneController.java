package beerratingapp.ui;

import beerratingapp.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.util.*;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.domain.Review;
import beerratingapp.domain.Advanced;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;

 /**
  * FXML Controller class for the parent scene with the reviews-list included
  * 
  */ 

public class MainSceneController implements Initializable {
    
    private BeerRatingService beerRatingService;
    private ReviewController reviewController;
    private AdvancedController advancedController;
    private Main application;
    
    private ArrayList<Review> reviewsList;
    private List<String> reviewsListNames;
    private ListProperty<String> listProperty = new SimpleListProperty<>();
    private String displayedView;
    
    @FXML
    private BorderPane mainPane;
    
    @FXML
    private ListView reviewsListView;
    
    @FXML
    private void handleListViewClick(MouseEvent clicked) {
        if (displayedView.equals("advanced")) {
            setReviewsView();
        }
        
        int reviewToSet = reviewsListView.getSelectionModel().getSelectedIndex();
        if (reviewToSet == -1) {
            return;
        }
        reviewController.setCurrentReview(reviewsList.get(reviewToSet));
    }
    
    @FXML
    private void handleCreateButton(ActionEvent event) {
        if (displayedView.equals("advanced")) {
            setReviewsView();
        }
        Review review = new Review();
        reviewController.setCurrentReview(review);
    }
    
 /**
 * 
 * Passes the current reviewsList to BeerRatingService to be saved file.
 */ 
    
    public void saveReviewsList() {
        Review toAdd = reviewController.getCurrentReview();
        boolean addAsNew = true;
        int indexOf = reviewsList.indexOf(toAdd);
        if (reviewsList.contains(toAdd)) {
            addAsNew = false;
        }
        toAdd = reviewController.getValuesFromUi(toAdd);
        if (addAsNew) {
            reviewsList.add(toAdd);
        } else {
            reviewsList.set(indexOf, toAdd);
        }
        beerRatingService.saveReviewsList(reviewsList);
        beerRatingService.getReviewsFromFile();
        updateReviewsListView();
        
    }
 /**
  * Checks if currently displayed Advanced object is attached to a review. If no, creates a new Review and attaches it by id.
  * Passes the Advanced object to BeerRatingService to be saved.
  * 
  * @param advanced Object to be checked for attachment and then saved
  * 
  */        
    public void saveAdvanced(Advanced advanced) {
        boolean advancedIsAttached = false;
        for (Review review: reviewsList) {
            if (advanced.getReviewId() == review.getId()) {
                advancedIsAttached = true;
            }
        }
        if (!advancedIsAttached) {
            Review review = new Review();
            reviewsList.add(review);
            advanced.setReviewId(review.getId());
            updateReviewsListView();
        }
        beerRatingService.saveAdvanced(advanced);
    }
 /**
  * Handles UI-changes when returning from Advanced view. Sets review based on id.
  * 
  * @param id of the advanced object to return to the attached review view
  * 
  */      
    
    
    public void backFromAdvanced(int id) {
        setReviewsView();
        for (Review review : reviewsList) {
            if (review.getId() == id) {
                reviewController.setCurrentReview(review);
            }
        }    
    }

 /**
  * initialization sequence on app start up. Gets reviews list from service. Sets review-view. Sets first review to display.
  * 
  */   

    
    public void setReviewOnInit() {
        getReviewsFromService();
        setReviewsView();
        if (!reviewsList.isEmpty()) {
            reviewController.setCurrentReview(reviewsList.get(0));
        } else {
            reviewController.setCurrentReview(new Review());
        }
        updateReviewsListView();
    }
    
    private void setReviewsView() {
        mainPane.setCenter(loadViewFromFile("review"));
    }
 /**
  * Request advanced data for BeerRatingService. Set advanced view. Set the requested advanced to the view.
  * @param reviewId the of the review to find the attached advanced data
  */       
        
    public void setAdvancedOnClick(int reviewId) {
        Advanced advanced = beerRatingService.getAdvancedFromFile(reviewId);
        setAdvancedView();
        advancedController.setCurrentAdvanced(advanced);       
    }
    
 /**
  * load advanced-view from file and set it to display
  * 
  */   
    
    private void setAdvancedView() {
        mainPane.setCenter(loadViewFromFile("advanced"));
    }
    
    private Pane loadViewFromFile(String viewType) {
        FXMLLoader sceneLoader = beerRatingService.getViewFromFile(viewType);
        Pane pane = new Pane();
        try {
            pane = sceneLoader.load();
        } catch (Exception e) {
            System.out.println("MainSceneController failed to load " + viewType + ".fxml Error message: ");
            System.out.println(e.toString());
        }
        if (viewType.equals("review")) {
            reviewController = sceneLoader.getController();
            reviewController.setMainSceneController(this);
        }
        if (viewType.equals("advanced")) {
            advancedController = sceneLoader.getController();
            advancedController.setMainSceneController(this);
        }
        displayedView = viewType;
        return pane;
    }
    
 /**
  * Request reviewsList from BeerRatingService

  * 
  */       
    
    public void getReviewsFromService() {
        reviewsList = beerRatingService.getReviewsFromFile();
    }
    
    private void updateReviewsListView() {
        reviewsListNames = new ArrayList<>();
        for (Review review : reviewsList) {
            reviewsListNames.add(review.getName());
        }        
        reviewsListView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(reviewsListNames));
    }
    
    
    public void setBeerRatingService(BeerRatingService beerRatingService) {
        this.beerRatingService = beerRatingService;
    }

    public void setApplication(Main application) {
        this.application = application;    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
