package beerratingapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import beerratingapp.domain.BeerRatingService;
import beerratingapp.dao.FileReviewDao;

public class Main extends Application {
    
    private Stage stage;
    private BeerRatingService beerRatingService;
    private Scene mainScene;
    
    @Override
    public void init() throws Exception {
        
        String reviewsFile = "reviews.txt";
        beerRatingService = new BeerRatingService(new FileReviewDao(reviewsFile));
        
        FXMLLoader mainSceneLoader = new FXMLLoader();
        mainSceneLoader.setLocation(getClass().getResource("/main.fxml"));
        Parent mainPane = mainSceneLoader.load();
        MainSceneController mainSceneController = mainSceneLoader.getController();
        mainSceneController.setBeerRatingService(beerRatingService); 
        mainSceneController.setApplication(this);
        mainSceneController.setReviewOnInit();
        mainSceneController.updateReviewsListView();

        mainScene = new Scene(mainPane);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("BeerRatingApp");
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
