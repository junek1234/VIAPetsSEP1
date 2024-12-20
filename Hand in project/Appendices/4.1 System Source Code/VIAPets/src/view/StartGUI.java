package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * The StartGUI class represents the main entry point for the GUI of VIAPets application.
 * This class is responsible for setting up the initial graphical user interface
 * (GUI) by loading the default view FXML and displaying it in the primary stage.
 *
 * @author Guillermo Sánchez Martínez
 * @version 1.0
 */
public class StartGUI extends Application
{

  private Stage stage;  // Keep a reference to the primaryStage
  /**
   * Initializes and starts the application by setting up the primary stage.
   * Loads the FXML for the default view and displays it in the primary stage.
   *
   * @param primaryStage The primary stage for this application, provided by JavaFX.
   * @throws Exception If an error occurs during the loading of the FXML file.
   */
  @Override public void start(Stage primaryStage) throws Exception
  {
    // Set the primary stage as the main window
    primaryStage.setTitle("VIAPetsApplication");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("fxml/currentlyworking/DefaultView.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setScene(scene);  // Set the initial scene
    primaryStage.show();  // Make sure the primary stage is shown
  }
}

