package beerratingapp.ui;

import beerratingapp.domain.Review;
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
import javax.swing.event.ChangeListener;
import javafx.beans.value.ObservableValue;
import beerratingapp.ui.MainSceneController;

public class ReviewController implements Initializable {
    
    
    private Review currentReview;
    private MainSceneController mainSceneController;

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
        mainSceneController.saveReviewsList();
        
    }

    @FXML
    private void handleAdvanced(ActionEvent event) {
        mainSceneController.setAdvancedOnClick(currentReview.getId());
    }
    
    @FXML
    private void handleAppearanceSlider() {       
        handlePartialScoreSlider(appearanceSlider, 0);
    }
    
    @FXML
    private void handleSmellSlider() {
        handlePartialScoreSlider(smellSlider, 1);
    }
        
    @FXML
    private void handleTasteSlider() {
        handlePartialScoreSlider(tasteSlider, 2);
    }
    
    @FXML
    private void handleMouthFeelSlider() {
        handlePartialScoreSlider(mouthFeelSlider, 3);
    }

    
    private void handlePartialScoreSlider(Slider charSlider, int charIndex) {
        int[] newPartScores = currentReview.getPartScores();
        newPartScores[charIndex] = (int) charSlider.getValue();
        this.currentReview.setPartScores(newPartScores);
        currentReview.updateAverage();
        averageLabel.setText(String.valueOf(currentReview.getAverage()));
    }
    
 /**
 * Sets the mainSceneController parent for this ReviewController
 * 
 * @param mainSceneController the mainSceneController instance to set
 */  

    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }
 /**
 * Return the currentReview
 * @return the current displayed Review object
 */  
      
    public Review getCurrentReview() {
        return currentReview;
    }
 /**
 * Gets all values from the UI-elements and return a Review with the values set
 * 
 * @param review the Review object to set the values to from the UI
 * 
 * @return A review object with all values set from the UI
 */  
    
    
    public Review getValuesFromUi(Review review) {
        Review toAdd = review;
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
        return review;
    }
    
 /**
 * Sets the parameter Review object's values to the UI
 * 
 * @param review object from which to set the values
 * 
 */       
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
    
    private void setDoubleFormValidators() {
        abvField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,2}([\\.]\\d{0,1})?")) {
                abvField.setText(oldValue);
            }
        });
        ibuField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,3}([\\.]\\d{0,1})?")) {
                ibuField.setText(oldValue);
            }
        });
        ogField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,1}([\\.]\\d{0,4})?")) {
                ogField.setText(oldValue);
            }
        });
        
    }
    
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDoubleFormValidators();
        

    }    
}
