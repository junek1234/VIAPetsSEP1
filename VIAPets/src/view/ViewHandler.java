package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler extends Application {

  @FXML
  private MenuItem petsMenuItem;
  @FXML
  private MenuItem customersMenuItem;
  @FXML
  private MenuItem bookingsSettingsMenu;
  @FXML
  private MenuItem bookingsListMenuItem;
  @FXML
  private MenuItem salesMenuItem;

  private Stage stage;  // Keep a reference to the primaryStage

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Set the primary stage as the main window
    stage = primaryStage;
    primaryStage.setTitle("FXMLTEST");
    switchToScene("fxml/DefaultPetView.fxml");  // Set the initial scene
    primaryStage.show();  // Make sure the primary stage is shown
  }

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    // Handle menu item click event to determine which scene to load
    if (source == petsMenuItem) {
      fxmlPath = "fxml/BirdPetView.fxml";
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/CustomerView.fxml";
    } else if (source == bookingsSettingsMenu) {
      fxmlPath = "fxml/BookingSettingsView.fxml";
    } else if (source == bookingsListMenuItem) {
      fxmlPath = "fxml/BookingsListView.fxml";
    } else if (source == salesMenuItem) {
      fxmlPath = "fxml/SalesView.fxml";
    } else {
      fxmlPath = "fxml/DefaultPetView.fxml";  // Default fallback scene
    }

    switchToScene(fxmlPath);  // Switch to the selected scene
  }

  private void switchToScene(String fxmlPath) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(fxmlPath));
    Scene scene = new Scene(loader.load());  // Load the new FXML scene
    stage.setScene(scene);  // Set the new scene on the primary stage
  }

  public static void main(String[] args) {
    Application.launch(ViewHandler.class);  // Launch the JavaFX application
  }
}
