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

    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    public Review getCurrentReview() {
        return currentReview;
    }

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
    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
