package beerratingapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import beerratingapp.domain.BeerRatingService;

public class MainSceneController implements Initializable {
    
    private BeerRatingService beerRatingService;
    private Main application;

    public void setTodoService(BeerRatingService beerRatingService) {
        this.beerRatingService = beerRatingService;
    }

    public void setApplication(Main application) {
        this.application = application;
    }
    
    @FXML
    private TextField id;
    
    @FXML
    private void handleSave(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    @FXML
    private void handleAdvanced(ActionEvent event) {
        System.out.println("You clicked me!");
    }

    public void setBeerRatingService(BeerRatingService beerRatingService) {
        this.beerRatingService = beerRatingService;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
