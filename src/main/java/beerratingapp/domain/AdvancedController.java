package beerratingapp.domain;

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

import beerratingapp.MainSceneController;

public class AdvancedController implements Initializable {
    
    
    private Advanced currentAdvanced;
    private MainSceneController mainSceneController;
    
    @FXML
    private Slider floralSlider;

    @FXML
    private Slider fruitySlider;
    
    @FXML
    private Slider citrusSlider;
    
    @FXML
    private Slider herbalSlider;
    
    @FXML
    private Slider grassySlider;
    
    @FXML
    private Slider earthyhSlider;
    
    @FXML
    private Slider pineySlider;
    
    @FXML
    private Slider spicySlider;
    
    @FXML
    private Slider caramelSlider;
    
    @FXML
    private Slider biscuitSlider;
    
    @FXML
    private Slider earthytSlider;
    
    @FXML
    private Slider nuttySlider;
    
    @FXML
    private Slider chocolateSlider;
    
    @FXML
    private Slider coffeeSlider;
    
    @FXML
    private Slider roastSlider;
    
    @FXML
    private Slider tartSlider;
  
    @FXML 
    private TextArea notesArea;
    
    @FXML 
    private Label beerNameLabel;
    
    @FXML
    private void handleBackButton(ActionEvent event) {
        mainSceneController.backFromAdvanced(currentAdvanced.getReviewName());
        
    }
    
    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    public Advanced getCurrentAdvanced() {
        return currentAdvanced;
    }

//    public Review getValuesFromUi(Review review) {
//        Review toAdd = review;
//        toAdd.setName(beerNameField.getText());
//        toAdd.setBrewery(breweryField.getText());
//        toAdd.setStyle(beerStyleField.getText());
//        toAdd.setDate(dateField.getText());
//        toAdd.setAbv(Double.valueOf(abvField.getText()));
//        toAdd.setIbu(Double.valueOf(ibuField.getText()));
//        toAdd.setOg(Double.valueOf(ogField.getText()));
//        int[] partScores = new int[] {(int) appearanceSlider.getValue(), (int) smellSlider.getValue(), 
//            (int) tasteSlider.getValue(), (int) mouthFeelSlider.getValue()};
//        toAdd.setPartScores(partScores);
//        toAdd.updateAverage();
//        toAdd.setNotes(notesArea.getText());
//        return review;
//    }
    
    public void setCurrentAdvanced(Advanced advanced) {
        currentAdvanced = advanced;
        beerNameLabel.setText(currentAdvanced.getReviewName());
        
        int[] hopScores = advanced.getHopScores();
        floralSlider.setValue(hopScores[0]);
        fruitySlider.setValue(hopScores[1]);
        citrusSlider.setValue(hopScores[2]);
        herbalSlider.setValue(hopScores[3]);
        grassySlider.setValue(hopScores[4]);
        earthyhSlider.setValue(hopScores[5]);
        pineySlider.setValue(hopScores[6]);
        spicySlider.setValue(hopScores[7]);
        
        int[] maltScores = advanced.getMaltScores();
        caramelSlider.setValue(maltScores[0]);
        biscuitSlider.setValue(maltScores[1]);
        earthytSlider.setValue(maltScores[2]);
        nuttySlider.setValue(maltScores[3]);
        chocolateSlider.setValue(maltScores[4]);
        coffeeSlider.setValue(maltScores[5]);
        roastSlider.setValue(maltScores[6]);
        tartSlider.setValue(maltScores[7]);
        notesArea.setText(currentAdvanced.getNotes());
    }
    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
