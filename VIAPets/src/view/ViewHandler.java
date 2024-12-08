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
  private MenuItem bookingsSettingsMenuItem;
  @FXML
  private MenuItem bookingsListMenuItem;
  @FXML
  private MenuItem salesMenuItem;

  private Stage stage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.stage = primaryStage;
    primaryStage.setTitle("FXMLTEST");
    switchToScene("fxml/DefaultPetView.fxml");
    primaryStage.show();
  }

  @FXML
  public void switchScene(ActionEvent e) throws IOException {
    Object source = e.getSource();
    String fxmlPath;

    if (source == petsMenuItem) {
      fxmlPath = "fxml/BirdPetView.fxml";
    } else if (source == customersMenuItem) {
      fxmlPath = "fxml/CustomerView.fxml";
    } else if (source == bookingsSettingsMenuItem) {
      fxmlPath = "fxml/BookingsSettingsView.fxml";
    } else if (source == bookingsListMenuItem) {
      fxmlPath = "fxml/BookingsListView.fxml";
    } else if (source == salesMenuItem) {
      fxmlPath = "fxml/SalesView.fxml";
    } else {
      fxmlPath = "fxml/DefaultPetView.fxml"; // Default fallback
    }

    switchToScene(fxmlPath);
  }

  private void switchToScene(String fxmlPath) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);// Update the stage with the new scene
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
