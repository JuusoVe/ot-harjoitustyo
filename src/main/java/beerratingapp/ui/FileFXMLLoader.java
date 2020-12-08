package beerratingapp.ui;
import javafx.fxml.FXMLLoader;

/**
 * Loader class to retrieve .fxml files as instances of FXMLLoader from .fxml files
 */

public class FileFXMLLoader {
/**
 * File leader function to request .fxml views as instances of FXMLLoader-class
 * @param viewType the type of view requested as string ie. "review"
 * 
 * @return the requested view as FXMLLoader object
 * 
 */    
    
    public FXMLLoader loadViewFromFile(String viewType) {
        FXMLLoader sceneLoader = new FXMLLoader();
        sceneLoader.setLocation(getClass().getResource("/" + viewType + ".fxml"));
        return sceneLoader;
    }
    
}
