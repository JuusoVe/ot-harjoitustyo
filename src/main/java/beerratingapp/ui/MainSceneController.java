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
        Review review = new Review();
        reviewController.setCurrentReview(review);
    }
    
 /**
 * 
 * 
 * 
 * 
 * 
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
        beerRatingService.getAll();
        updateReviewsListView();
        
    }
    
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
    
    public void backFromAdvanced(int id) {
        setReviewsView();
        for (Review review : reviewsList) {
            if (review.getId() == id) {
                reviewController.setCurrentReview(review);
            }
        }    
    }
    
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
    
    public void setAdvancedOnClick(int reviewId) {
        Advanced advanced = beerRatingService.getAdvancedFromFile(reviewId);
        setAdvancedView();
        advancedController.setCurrentAdvanced(advanced);
        
    }
    
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
    
    
    public void getReviewsFromService() {
        reviewsList = beerRatingService.getAll();
    }
    
    public void updateReviewsListView() {
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
