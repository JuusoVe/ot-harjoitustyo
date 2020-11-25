package beerratingapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import java.util.*;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.domain.Review;
import javafx.collections.FXCollections;

public class MainSceneController implements Initializable {
    
    private BeerRatingService beerRatingService;
    private Main application;
    
    protected Review currentReview;
    protected ArrayList<Review> reviewsList;
    protected List<String> reviewsListNames;
    protected ListProperty<String> listProperty = new SimpleListProperty<>();

    public void setBeerRatingService(BeerRatingService beerRatingService) {
        this.beerRatingService = beerRatingService;
    }

    public void setApplication(Main application) {
        this.application = application;    
    }
    
    @FXML
    private ListView reviewsListView;

    @FXML
    private TextField beerNameField;
    
    @FXML
    private TextField breweryField;
        
    @FXML
    private TextField beerStyleField;
            
    @FXML
    private TextField dateField;

    @FXML
    private TextField abvField;

    @FXML
    private TextField ibuField;

    @FXML
    private TextField ogField;
    
    @FXML
    private Slider appearanceSlider;

    @FXML
    private Slider smellSlider;
    
    @FXML
    private Slider mouthFeelSlider;
    
    @FXML
    private Slider tasteSlider;
  
    @FXML
    private Button saveButton;
    
    @FXML
    private Button advancedButton;
    
    @FXML 
    private TextArea notesArea;
    
    @FXML 
    private Label averageLabel;
    
    @FXML
    private void handleSave(ActionEvent event) {
        Review toAdd = new Review();
        boolean addAsNew = true;
        int indexOf = reviewsList.indexOf(currentReview);
        if (reviewsList.contains(currentReview)) {
            addAsNew = false;
            toAdd.setId(currentReview.getId());
        }
        toAdd.setName(beerNameField.getText());
        toAdd.setBrewery(breweryField.getText());
        toAdd.setStyle(beerStyleField.getText());
        toAdd.setDate(dateField.getText());
        toAdd.setAbv(Double.valueOf(abvField.getText()));
        toAdd.setIbu(Double.valueOf(ibuField.getText()));
        toAdd.setOg(Double.valueOf(ogField.getText()));
        int[] partScores = new int[] {(int) appearanceSlider.getValue(), (int) smellSlider.getValue(), 
            (int) tasteSlider.getValue(), (int) mouthFeelSlider.getValue()};
        toAdd.setPartScores(partScores);
        toAdd.updateAverage();
        toAdd.setNotes(notesArea.getText());
        reviewsList.add(toAdd);
        if (addAsNew) {
            System.out.println("added as new");
            reviewsList.add(toAdd);
        } else {
            System.out.println("added as old");
            reviewsList.set(indexOf, toAdd);
        }
        beerRatingService.saveReviewsList(reviewsList);
        beerRatingService.getAll();
        updateReviewsListView();
        
    }

    
    @FXML
    private void handleAdvanced(ActionEvent event) {
        System.out.println("Advanced feature not yet implemented");
    }
    
    @FXML
    private void handleListViewClick(MouseEvent clicked) {
        int reviewToSet = reviewsListView.getSelectionModel().getSelectedIndex();
        setCurrentReview(reviewsList.get(reviewToSet));
    }
    
    @FXML
    private void handleCreateButton(ActionEvent event) {
        Review review = new Review();
        setCurrentReview(review);
    }
    
    @FXML
    private void handleAppearanceSlider() {       
        int[] newPartScores = currentReview.getPartScores();
        newPartScores[0] = (int) appearanceSlider.getValue();
        this.currentReview.setPartScores(newPartScores);
        currentReview.updateAverage();
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
    }
    
    @FXML
    private void handleSmellSlider() {
        int[] newPartScores = currentReview.getPartScores();
        newPartScores[1] = (int) smellSlider.getValue();
        this.currentReview.setPartScores(newPartScores);
        currentReview.updateAverage();
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
    }
    
    @FXML
    private void handleMouthFeelSlider() {
        int[] newPartScores = currentReview.getPartScores();
        newPartScores[3] = (int) mouthFeelSlider.getValue();
        this.currentReview.setPartScores(newPartScores);
        currentReview.updateAverage();
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
    }
    
    @FXML
    private void handleTasteSlider() {
        int[] newPartScores = currentReview.getPartScores();
        newPartScores[2] = (int) tasteSlider.getValue();
        this.currentReview.setPartScores(newPartScores);
        currentReview.updateAverage();
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
    }   
    
    public void setCurrentReview(Review review) {
        currentReview = review;
        beerNameField.setText(currentReview.getName());
        breweryField.setText(currentReview.getBrewery());
        beerStyleField.setText(currentReview.getStyle());
        dateField.setText(currentReview.getDate());
        abvField.setText(String.valueOf(currentReview.getAbv()));
        ibuField.setText(String.valueOf(currentReview.getIbu()));
        ogField.setText(String.valueOf(currentReview.getOg()));
        int[] partScores = currentReview.getPartScores();
        appearanceSlider.setValue(partScores[0]);
        smellSlider.setValue(partScores[1]);
        mouthFeelSlider.setValue(partScores[2]);
        tasteSlider.setValue(partScores[3]);
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
        notesArea.setText(currentReview.getNotes());
    }
    
    public void setReviewOnInit() {
        getReviewsFromService();
        if (!reviewsList.isEmpty()) {
            setCurrentReview(reviewsList.get(0));
        } else {
            setCurrentReview(new Review());
        }
        
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
