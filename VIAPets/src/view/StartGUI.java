package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class StartGUI extends Application
{



  private Stage stage;  // Keep a reference to the primaryStage

  @Override public void start(Stage primaryStage) throws Exception
  {
    // Set the primary stage as the main window
    primaryStage.setTitle("FXMLTEST");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("fxml/DefaultSalesView.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setScene(scene);  // Set the initial scene
    primaryStage.show();  // Make sure the primary stage is shown
  }
}

