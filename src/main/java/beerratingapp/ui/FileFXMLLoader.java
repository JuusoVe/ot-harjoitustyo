package beerratingapp.ui;
import javafx.fxml.FXMLLoader;

public class FileFXMLLoader {
    
    
    public FXMLLoader loadViewFromFile(String viewType) {
        FXMLLoader sceneLoader = new FXMLLoader();
        sceneLoader.setLocation(getClass().getResource("/" + viewType + ".fxml"));
        return sceneLoader;
    }
    
}
