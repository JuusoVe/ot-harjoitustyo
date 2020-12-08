package beerratingapp;

import beerratingapp.ui.FileFXMLLoader;
import beerratingapp.ui.MainSceneController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.dao.*;

public class Main extends Application {
    
    private Stage stage;
    private BeerRatingService beerRatingService;
    private Scene mainScene;
    
    @Override
    public void init() throws Exception {
        
        String reviewsFile = "reviews.txt";
        String advancedFile = "advanced.txt";
        beerRatingService = new BeerRatingService(new FileReviewDao(reviewsFile), new FileAdvancedDao(advancedFile),
        new FileFXMLLoader());
        FXMLLoader mainSceneLoader = beerRatingService.getViewFromFile("main");
        Parent mainPane = mainSceneLoader.load();
        MainSceneController mainSceneController = mainSceneLoader.getController();
        mainSceneController.setBeerRatingService(beerRatingService); 
        mainSceneController.setApplication(this);
        mainSceneController.setReviewOnInit();

        mainScene = new Scene(mainPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("BeerRating");
        setMainScene();
        stage.show();
    }
    
    public void setMainScene() {
        stage.setScene(mainScene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
