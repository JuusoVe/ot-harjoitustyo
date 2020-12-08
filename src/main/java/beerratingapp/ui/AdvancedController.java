package beerratingapp.ui;

import beerratingapp.domain.Advanced;
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
        mainSceneController.backFromAdvanced(currentAdvanced.getReviewId());    
    }
    
    @FXML
    private void handleSaveButton(ActionEvent event) {
        getValuesFromUi();
        mainSceneController.saveAdvanced(currentAdvanced);
    }    
/**
 * sets the the parent mainSceneController for this AdvancedController
 */    
    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }
/**
 * returns the current advanced Object
 * 
 * @return the currently displayed Advanced object
 */
    public Advanced getCurrentAdvanced() {
        return currentAdvanced;
    }
/**
 * Updates the currentAdvanced Object of this controller with the values from the UI 
 * and returns the updated currentAdvanced as an Advanced Object.
 * 
 *@return currentAdvanced updated with values from the UI
 */
    public Advanced getValuesFromUi() {
        Advanced advanced = currentAdvanced;
        
        int[] hopScores = new int[] {(int) floralSlider.getValue(), (int) fruitySlider.getValue(), 
            (int) citrusSlider.getValue(), (int) herbalSlider.getValue(), (int) grassySlider.getValue(),
            (int) earthyhSlider.getValue(), (int) pineySlider.getValue(), (int) spicySlider.getValue()};
        advanced.setHopScores(hopScores);
        
        int[] maltScores = new int[] {(int) caramelSlider.getValue(), (int) biscuitSlider.getValue(), 
            (int) earthytSlider.getValue(), (int) nuttySlider.getValue(), (int) chocolateSlider.getValue(),
            (int) coffeeSlider.getValue(), (int) roastSlider.getValue(), (int) tartSlider.getValue()};
        advanced.setMaltScores(maltScores);
        
        advanced.setNotes(notesArea.getText());
        
        return advanced;
    }
    
 /**
 * Sets the values in the UI according to the Advanced Object
 * 
 *@param advanced Advanced Object the values of which are set to the UI
 */
    
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
