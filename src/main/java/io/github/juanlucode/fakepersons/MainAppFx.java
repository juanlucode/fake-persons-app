package io.github.juanlucode.fakepersons;

import java.io.IOException;

import io.github.juanlucode.fakepersons.control.MakerControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainAppFx extends Application {

	
    private Stage stage;
    private AnchorPane panel;
    
    
	@Override
	public void start(Stage primaryStage) {
	       stage = primaryStage;
	       stage.setTitle("Fake Persons");

	        initPanel();
	}
	
    public void initPanel() {
        try {
        	Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        	// creamos el controlador
        	MakerControl makerControl = new MakerControl();
        	
        	// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Maker.fxml"));
            loader.setController(makerControl);
            panel = (AnchorPane) loader.load();
            

            // Show the scene containing the root layout.
            Scene scene = new Scene(panel, visualBounds.getWidth(), visualBounds.getHeight());
            stage.setScene(scene);
            
			stage.show();            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
	public Stage getPrimaryStage(){
		return this.stage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}